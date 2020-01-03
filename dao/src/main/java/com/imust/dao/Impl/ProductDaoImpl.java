package com.imust.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imust.domain.Po.Product;
import com.imust.dao.base.BaseDaoImpl;
import com.imust.dao.ProductDao;

/**
 * ProductDao 实现类
 * @author Lenovo
 * @since 2020-01-03 13:09:36
 */
@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product, Long> implements ProductDao {
	private final static String NAMESPACE = "com.com.imust.dao.ProductDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}