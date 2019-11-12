package com.imustacm.dao.Impl;

import com.imustacm.dao.PressureRecordDao;
import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.PressureRecord;
import com.imustacm.dao.base.BaseDaoImpl;

/**
 * PressureRecordDao 实现类
 * @author Lenovo
 * @since 2019-11-10 20:45:57
 */
@Repository("pressureRecordDao")
public class PressureRecordDaoImpl extends BaseDaoImpl<PressureRecord, Long> implements PressureRecordDao {
	private final static String NAMESPACE = "com.imustacm.dao.PressureRecordDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}