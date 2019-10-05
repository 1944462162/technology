/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.dao.Impl;

import com.imustacm.dao.AgglomerationProcessRecordDao;
import com.imustacm.dao.base.BaseDaoImpl;
import com.imustacm.domain.AgglomerationProcessRecord;
import org.springframework.stereotype.Repository;


/**
 * AgglomerationProcessRecordDao 实现类
 * @author Lenovo
 * @since 2019-09-28 20:19:30
 */

@Repository
public class AgglomerationProcessRecordDaoImpl extends BaseDaoImpl<AgglomerationProcessRecord, Long> implements AgglomerationProcessRecordDao {
	private final static String NAMESPACE = "com.imustacm.dao.AgglomerationProcessRecordDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}