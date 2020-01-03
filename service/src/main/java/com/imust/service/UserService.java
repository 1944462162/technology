package com.imust.service;

import com.imust.domain.Po.Users;

import java.util.List;

public interface UserService {
    Users getUserByCode(String code) throws Exception;

    Users login(Users user);

    Users getUserById(int id);

    List<String> getRolemsByCode(String code) throws Exception;

    List<String> getPermisssionByCode(String code) throws Exception;


}
