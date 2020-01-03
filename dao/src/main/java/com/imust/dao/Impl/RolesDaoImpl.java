package com.imust.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imust.domain.Po.Roles;
import com.imust.dao.base.BaseDaoImpl;
import com.imust.dao.RolesDao;

/**
 * RolesDao 实现类
 * @author Lenovo
 * @since 2020-01-03 13:09:37
 */
@Repository("rolesDao")
public class RolesDaoImpl extends BaseDaoImpl<Roles, Long> implements RolesDao {
	private final static String NAMESPACE = "com.com.imust.dao.RolesDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}