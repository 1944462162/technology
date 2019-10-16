/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.dao.Impl;

import com.imustacm.dao.SmeltingRecordDao;
import com.imustacm.dao.base.BaseDaoImpl;
import com.imustacm.domain.Po.SmeltingRecord;
import org.springframework.stereotype.Repository;


/**
 * SmeltingRecordDao 实现类
 * @author Lenovo
 * @since 2019-09-28 20:19:30
 */
@Repository("smeltingRecordDao")
public class SmeltingRecordDaoImpl extends BaseDaoImpl<SmeltingRecord, Long> implements SmeltingRecordDao {
	private final static String NAMESPACE = "com.imustacm.dao.SmeltingRecordDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}