package com.imustacm.dao.Impl;

import com.imustacm.dao.RolesDao;
import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.Roles;
import com.imustacm.dao.base.BaseDaoImpl;

/**
 * RolesDao 实现类
 * @author Lenovo
 * @since 2019-11-10 20:45:57
 */
@Repository("rolesDao")
public class RolesDaoImpl extends BaseDaoImpl<Roles, Long> implements RolesDao {
	private final static String NAMESPACE = "com.imustacm.dao.RolesDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}