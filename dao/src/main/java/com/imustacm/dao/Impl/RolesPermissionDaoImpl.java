/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.dao.Impl;

import com.imustacm.dao.RolesPermissionDao;
import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.RolesPermission;
import com.imustacm.dao.base.BaseDaoImpl;

/**
 * RolesPermissionDao 实现类
 * @author Lenovo
 * @since 2019-11-10 20:45:57
 */
@Repository("rolesPermissionDao")
public class RolesPermissionDaoImpl extends BaseDaoImpl<RolesPermission, Long> implements RolesPermissionDao {
	private final static String NAMESPACE = "com.imustacm.dao.RolesPermissionDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}