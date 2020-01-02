package com.imustacm.service;

import com.imustacm.domain.Po.Users;
import com.imustacm.domain.Vo.UsersVo;

import java.util.List;

public interface UserService {
    Users getUserByCode(String code) throws Exception;

    Users login(Users user);

    Users getUserById(int id);

    List<String> getRolemsByCode(String code) throws Exception;

    List<String> getPermisssionByCode(String code) throws Exception;


}
