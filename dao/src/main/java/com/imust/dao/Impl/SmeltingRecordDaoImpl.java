package com.imust.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imust.domain.Po.SmeltingRecord;
import com.imust.dao.base.BaseDaoImpl;
import com.imust.dao.SmeltingRecordDao;

/**
 * SmeltingRecordDao 实现类
 * @author Lenovo
 * @since 2020-01-03 13:09:37
 */
@Repository("smeltingRecordDao")
public class SmeltingRecordDaoImpl extends BaseDaoImpl<SmeltingRecord, Long> implements SmeltingRecordDao {
	private final static String NAMESPACE = "com.com.imust.dao.SmeltingRecordDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}