package com.imust.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imust.domain.Po.RolesPermission;
import com.imust.dao.base.BaseDaoImpl;
import com.imust.dao.RolesPermissionDao;

/**
 * RolesPermissionDao 实现类
 * @author Lenovo
 * @since 2020-01-03 13:09:37
 */
@Repository("rolesPermissionDao")
public class RolesPermissionDaoImpl extends BaseDaoImpl<RolesPermission, Long> implements RolesPermissionDao {
	private final static String NAMESPACE = "com.com.imust.dao.RolesPermissionDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}