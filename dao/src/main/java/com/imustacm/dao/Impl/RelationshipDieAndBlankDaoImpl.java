/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imustacm.domain.RelationshipDieAndBlank;
import com.imustacm.dao.base.BaseDaoImpl;
import com.imustacm.dao.RelationshipDieAndBlankDao;

/**
 * RelationshipDieAndBlankDao 实现类
 * @author Lenovo
 * @since 2019-10-21 11:00:16
 */
@Repository("relationshipDieAndBlankDao")
public class RelationshipDieAndBlankDaoImpl extends BaseDaoImpl<RelationshipDieAndBlank, Long> implements RelationshipDieAndBlankDao {
	private final static String NAMESPACE = "com.imustacm.dao.RelationshipDieAndBlankDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}