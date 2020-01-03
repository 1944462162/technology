package com.imust.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imust.domain.Po.AgglomerationProcessRecord;
import com.imust.dao.base.BaseDaoImpl;
import com.imust.dao.AgglomerationProcessRecordDao;

/**
 * AgglomerationProcessRecordDao 实现类
 * @author Lenovo
 * @since 2020-01-03 13:09:36
 */
@Repository("agglomerationProcessRecordDao")
public class AgglomerationProcessRecordDaoImpl extends BaseDaoImpl<AgglomerationProcessRecord, Long> implements AgglomerationProcessRecordDao {
	private final static String NAMESPACE = "com.com.imust.dao.AgglomerationProcessRecordDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}