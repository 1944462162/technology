package com.imustacm.service;

import com.imustacm.domain.Po.Users;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2019/10/25 9:56
 * Content:
 */
public interface UserService {
    Users getUserByCode(String code) throws Exception;

    Users login(Users user);

    Users getUserById(int id);

    List<String> getRolemsByCode(String code) throws Exception;

    List<String> getPermisssionByCode(String code) throws Exception;
}
