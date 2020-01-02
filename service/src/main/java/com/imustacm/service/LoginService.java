package com.imustacm.service;

import com.imustacm.domain.Vo.UsersVo;

import java.util.List;

/**
 * Date: 2020/1/3 4:18
 * Content:
 */
public interface LoginService {

    List<UsersVo> getAllUser();

    int UpdateUserByCode(UsersVo usersVo);

    int DeleteUserByCode(String code);

}
