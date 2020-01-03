package com.imust.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imust.domain.Po.FlourMillingProcessRecord;
import com.imust.dao.base.BaseDaoImpl;
import com.imust.dao.FlourMillingProcessRecordDao;

/**
 * FlourMillingProcessRecordDao 实现类
 * @author Lenovo
 * @since 2020-01-03 13:09:36
 */
@Repository("flourMillingProcessRecordDao")
public class FlourMillingProcessRecordDaoImpl extends BaseDaoImpl<FlourMillingProcessRecord, Long> implements FlourMillingProcessRecordDao {
	private final static String NAMESPACE = "com.com.imust.dao.FlourMillingProcessRecordDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}