package com.imustacm.dao.Impl;

import com.imustacm.dao.SmeltDao;
import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.Smelt;
import com.imustacm.dao.base.BaseDaoImpl;

/**
 * SmeltDao 实现类
 * @author Lenovo
 * @since 2019-11-10 20:45:57
 */
@Repository("smeltDao")
public class SmeltDaoImpl extends BaseDaoImpl<Smelt, Long> implements SmeltDao {
	private final static String NAMESPACE = "com.imustacm.dao.SmeltDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}