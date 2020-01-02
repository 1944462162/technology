package com.imustacm.service.Impl;

import com.imustacm.dao.UsersDao;
import com.imustacm.domain.Po.Users;
import com.imustacm.domain.Vo.UsersVo;
import com.imustacm.service.LoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/1/3 4:17
 * Content:
 */

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public List<UsersVo> getAllUser() {
        List<UsersVo> usersVos = new ArrayList<>();
        try {
            List<Users> usersList = usersDao.selectEntryList(null);
            if (usersList != null && usersList.size() != 0){
                for (Users users : usersList) {
                    UsersVo usersVo = new UsersVo();
                    BeanUtils.copyProperties(users,usersVo);
                    usersVos.add(usersVo);
                }
                return usersVos;
            }
            else{
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("获取所有用户出现异常");
        }
    }

    @Override
    public int UpdateUserByCode(UsersVo usersVo) {
        Users users = new Users();
        users.setUsercode(users.getUsercode());
        try {
            Integer isExist = usersDao.selectEntryListCount(users);
            if (isExist == 1){
                BeanUtils.copyProperties(usersVo,users);
                return usersDao.updateByKey(users);
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException("更改用户信息出现异常");
        }
    }

    @Override
    public int DeleteUserByCode(String code) {
        Users users = new Users();
        users.setUsercode(code);
        try {
            Integer isExist = usersDao.selectEntryListCount(users);
            if (isExist == 0){
                return 0;
            }
            return usersDao.deleteByKey(users);
        } catch (Exception e) {
            throw new RuntimeException("删除用户信息失败");
        }
    }

}
