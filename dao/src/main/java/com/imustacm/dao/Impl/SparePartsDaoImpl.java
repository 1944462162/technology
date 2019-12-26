/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.SpareParts;
import com.imustacm.dao.base.BaseDaoImpl;
import com.imustacm.dao.SparePartsDao;

/**
 * SparePartsDao 实现类
 * @author Lenovo
 * @since 2019-12-25 10:45:24
 */
@Repository("sparePartsDao")
public class SparePartsDaoImpl extends BaseDaoImpl<SpareParts, Long> implements SparePartsDao {
	private final static String NAMESPACE = "com.imustacm.dao.SparePartsDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}