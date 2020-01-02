package com.imustacm.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.PressedProcessRecord;
import com.imustacm.dao.base.BaseDaoImpl;
import com.imustacm.dao.PressedProcessRecordDao;

/**
 * PressedProcessRecordDao 实现类
 * @author Lenovo
 * @since 2020-01-02 10:10:07
 */
@Repository("pressedProcessRecordDao")
public class PressedProcessRecordDaoImpl extends BaseDaoImpl<PressedProcessRecord, Long> implements PressedProcessRecordDao {
	private final static String NAMESPACE = "com.imustacm.dao.PressedProcessRecordDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}