package com.imustacm.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.Smelt;
import com.imustacm.dao.base.BaseDaoImpl;
import com.imustacm.dao.SmeltDao;

/**
 * SmeltDao 实现类
 * @author Lenovo
 * @since 2019-12-25 10:45:24
 */
@Repository("smeltDao")
public class SmeltDaoImpl extends BaseDaoImpl<Smelt, Long> implements SmeltDao {
	private final static String NAMESPACE = "com.imustacm.dao.SmeltDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}