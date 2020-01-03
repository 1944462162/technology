package com.imust.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imust.domain.Po.PressedProcessRecord;
import com.imust.dao.base.BaseDaoImpl;
import com.imust.dao.PressedProcessRecordDao;

/**
 * PressedProcessRecordDao 实现类
 * @author Lenovo
 * @since 2020-01-03 13:09:36
 */
@Repository("pressedProcessRecordDao")
public class PressedProcessRecordDaoImpl extends BaseDaoImpl<PressedProcessRecord, Long> implements PressedProcessRecordDao {
	private final static String NAMESPACE = "com.com.imust.dao.PressedProcessRecordDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}