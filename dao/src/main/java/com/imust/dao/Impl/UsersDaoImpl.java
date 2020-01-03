package com.imust.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imust.domain.Po.Users;
import com.imust.dao.base.BaseDaoImpl;
import com.imust.dao.UsersDao;

/**
 * UsersDao 实现类
 * @author Lenovo
 * @since 2020-01-03 13:09:37
 */
@Repository("usersDao")
public class UsersDaoImpl extends BaseDaoImpl<Users, Long> implements UsersDao {
	private final static String NAMESPACE = "com.com.imust.dao.UsersDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}