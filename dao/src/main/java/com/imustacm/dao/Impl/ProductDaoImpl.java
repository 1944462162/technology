/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.Product;
import com.imustacm.dao.base.BaseDaoImpl;
import com.imustacm.dao.ProductDao;

/**
 * ProductDao 实现类
 * @author Lenovo
 * @since 2019-12-25 10:45:23
 */
@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product, Long> implements ProductDao {
	private final static String NAMESPACE = "com.imustacm.dao.ProductDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}