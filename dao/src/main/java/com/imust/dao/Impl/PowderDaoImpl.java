package com.imust.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imust.domain.Po.Powder;
import com.imust.dao.base.BaseDaoImpl;
import com.imust.dao.PowderDao;

/**
 * PowderDao 实现类
 * @author Lenovo
 * @since 2020-01-03 20:12:18
 */
@Repository("powderDao")
public class PowderDaoImpl extends BaseDaoImpl<Powder, Long> implements PowderDao {
	private final static String NAMESPACE = "com.imust.dao.PowderDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}