/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.dao.Impl;

import com.imustacm.dao.StockDao;
import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.Stock;
import com.imustacm.dao.base.BaseDaoImpl;

/**
 * StockDao 实现类
 * @author Lenovo
 * @since 2019-11-10 20:45:57
 */
@Repository("stockDao")
public class StockDaoImpl extends BaseDaoImpl<Stock, Long> implements StockDao {
	private final static String NAMESPACE = "com.imustacm.dao.StockDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}