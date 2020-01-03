package com.imust.shiro;

import com.imust.domain.Po.Users;
import com.imust.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Date: 2019/10/25 9:30
 * Content:
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
   private UserService userService;

    //    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        获取用户账号
        String userCode = (String) principalCollection.getPrimaryPrincipal();
        Set<String> role = null;
        try {
            role = getRoleByCode(userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<String> permissions = null;
        try {
            permissions = getPermissionsByCode(userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(role);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    private Set<String> getPermissionsByCode(String userCode) throws Exception {
        List<String> list = userService.getPermisssionByCode(userCode);
        return new HashSet<>(list);
    }

    private Set<String> getRoleByCode(String userCode) throws Exception {
        List<String> list = userService.getRolemsByCode(userCode);
        return new HashSet<>(list);
    }


//    认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

//        获取当前用户的账号
        String userCode = (String)authenticationToken.getPrincipal();

        String password = null;

//        根据账号获取密码
        try {
            password = getPasswordByCode(userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (password == null){
            return null;
        }
//        进行认证
        return new SimpleAuthenticationInfo(userCode,password,"CustomRealm");
    }

    private String getPasswordByCode(String userCode) throws Exception {
        Users user = userService.getUserByCode(userCode);
        if(user != null){
            return user.getPassword();
        }
        else{
            return null;
        }
    }
}
