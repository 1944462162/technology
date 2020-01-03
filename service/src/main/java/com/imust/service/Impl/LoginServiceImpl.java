package com.imust.service.Impl;

import com.imust.dao.UsersDao;
import com.imust.domain.Po.Users;
import com.imust.domain.Vo.UsersVo;
import com.imust.service.LoginService;
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
        users.setId(usersVo.getId());
        try {
            Integer isExist = usersDao.selectEntryListCount(users);
            if (isExist == 1){
                BeanUtils.copyProperties(usersVo,users);
                return usersDao.updateByKey(users);
            }
            else{
                return 0;
            }

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

    @Override
    public int insertUser(UsersVo usersVo) {
        Users users = new Users();
        BeanUtils.copyProperties(usersVo,users);
        try {
            Integer isExsit = usersDao.selectEntryListCount(users);
            if (isExsit == 1){
                return 0;
            }
            return usersDao.insertEntry(users);
        } catch (Exception e) {
            throw new RuntimeException("增加用户信息失败");
        }

    }

}
