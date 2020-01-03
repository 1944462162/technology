package com.imust.service;

import com.imust.domain.Vo.UsersVo;

import java.util.List;

/**
 * Date: 2020/1/3 4:18
 * Content:
 */
public interface LoginService {

    List<UsersVo> getAllUser();

    int UpdateUserByCode(UsersVo usersVo);

    int DeleteUserByCode(String code);

    int insertUser(UsersVo usersVo);

}
