package com.imustacm.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.Users;
import com.imustacm.dao.base.BaseDaoImpl;
import com.imustacm.dao.UsersDao;

/**
 * UsersDao 实现类
 * @author Lenovo
 * @since 2019-12-25 10:45:24
 */
@Repository("usersDao")
public class UsersDaoImpl extends BaseDaoImpl<Users, Long> implements UsersDao {
	private final static String NAMESPACE = "com.imustacm.dao.UsersDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}