package com.imustacm.service.Impl;

import com.imustacm.dao.RolesDao;
import com.imustacm.dao.RolesPermissionDao;
import com.imustacm.dao.UsersDao;
import com.imustacm.domain.Po.Roles;
import com.imustacm.domain.Po.RolesPermission;
import com.imustacm.domain.Po.Users;
import com.imustacm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UsersDao usersDao;

    @Autowired
    RolesDao rolesDao;

    @Autowired
    RolesPermissionDao rolesPermissionDao;

    @Override
    public Users getUserByCode(String code) throws Exception {
        Users users = new Users();
        users.setUsercode(code);
        List<Users> usersList = usersDao.selectEntryList(users);

        return CollectionUtils.isEmpty(usersList) ? null : usersList.get(0);
    }

    @Override
    public Users login(Users user) {

        return null;
    }

    @Override
    public Users getUserById(int id) {
        return null;
    }


//    获取角色信息
    @Override
    public List<String> getRolemsByCode(String code) throws Exception {
       Roles roles = new Roles();
       roles.setUserCode(code);
       List<Roles> list = rolesDao.selectEntryList(roles);
       List<String> rolesName = new ArrayList<>();
        for (Roles roles1 : list) {
            rolesName.add(roles1.getRoleName());
        }
        return rolesName;
    }

    @Override
    public List<String> getPermisssionByCode(String code) throws Exception {
        Roles roles = new Roles();
        roles.setUserCode(code);
//        通过账号获取角色
        List<Roles> list = rolesDao.selectEntryList(roles);
        List<String> permission = new ArrayList<>();

        RolesPermission rolesPermission = new RolesPermission();
//        通过角色获取权限
        for (Roles roles1 : list) {
            rolesPermission.setRoleName(roles1.getRoleName());
            List<RolesPermission> rolesPermissions = rolesPermissionDao.selectEntryList(rolesPermission);
            for (RolesPermission rolesPermission1 : rolesPermissions) {
                permission.add(rolesPermission1.getPermission());
            }
        }
        return permission;
    }
}
