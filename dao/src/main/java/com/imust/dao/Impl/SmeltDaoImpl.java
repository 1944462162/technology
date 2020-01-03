package com.imust.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imust.domain.Po.Smelt;
import com.imust.dao.base.BaseDaoImpl;
import com.imust.dao.SmeltDao;

/**
 * SmeltDao 实现类
 * @author Lenovo
 * @since 2020-01-03 13:09:37
 */
@Repository("smeltDao")
public class SmeltDaoImpl extends BaseDaoImpl<Smelt, Long> implements SmeltDao {
	private final static String NAMESPACE = "com.com.imust.dao.SmeltDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}