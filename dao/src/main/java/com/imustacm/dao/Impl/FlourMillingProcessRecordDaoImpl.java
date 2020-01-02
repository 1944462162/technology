package com.imustacm.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.FlourMillingProcessRecord;
import com.imustacm.dao.base.BaseDaoImpl;
import com.imustacm.dao.FlourMillingProcessRecordDao;

/**
 * FlourMillingProcessRecordDao 实现类
 * @author Lenovo
 * @since 2019-12-25 10:45:23
 */
@Repository("flourMillingProcessRecordDao")
public class FlourMillingProcessRecordDaoImpl extends BaseDaoImpl<FlourMillingProcessRecord, Long> implements FlourMillingProcessRecordDao {
	private final static String NAMESPACE = "com.imustacm.dao.FlourMillingProcessRecordDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}