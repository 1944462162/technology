package com.imust.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imust.domain.Po.PressureRecord;
import com.imust.dao.base.BaseDaoImpl;
import com.imust.dao.PressureRecordDao;

/**
 * PressureRecordDao 实现类
 * @author Lenovo
 * @since 2020-01-03 13:09:36
 */
@Repository("pressureRecordDao")
public class PressureRecordDaoImpl extends BaseDaoImpl<PressureRecord, Long> implements PressureRecordDao {
	private final static String NAMESPACE = "com.com.imust.dao.PressureRecordDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}