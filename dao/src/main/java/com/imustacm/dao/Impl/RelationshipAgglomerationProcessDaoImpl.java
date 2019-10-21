/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imustacm.domain.RelationshipAgglomerationProcess;
import com.imustacm.dao.base.BaseDaoImpl;
import com.imustacm.dao.RelationshipAgglomerationProcessDao;

/**
 * RelationshipAgglomerationProcessDao 实现类
 * @author Lenovo
 * @since 2019-10-21 11:00:16
 */
@Repository("relationshipAgglomerationProcessDao")
public class RelationshipAgglomerationProcessDaoImpl extends BaseDaoImpl<RelationshipAgglomerationProcess, Long> implements RelationshipAgglomerationProcessDao {
	private final static String NAMESPACE = "com.imustacm.dao.RelationshipAgglomerationProcessDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}