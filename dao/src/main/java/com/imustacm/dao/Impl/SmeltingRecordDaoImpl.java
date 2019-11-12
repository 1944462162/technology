package com.imustacm.dao.Impl;

import com.imustacm.dao.SmeltingRecordDao;
import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.SmeltingRecord;
import com.imustacm.dao.base.BaseDaoImpl;

/**
 * SmeltingRecordDao 实现类
 * @author Lenovo
 * @since 2019-11-10 20:45:57
 */
@Repository("smeltingRecordDao")
public class SmeltingRecordDaoImpl extends BaseDaoImpl<SmeltingRecord, Long> implements SmeltingRecordDao {
	private final static String NAMESPACE = "com.imustacm.dao.SmeltingRecordDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}