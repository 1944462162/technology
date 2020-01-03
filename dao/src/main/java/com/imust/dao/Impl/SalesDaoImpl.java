package com.imust.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imust.domain.Po.Sales;
import com.imust.dao.base.BaseDaoImpl;
import com.imust.dao.SalesDao;

/**
 * SalesDao 实现类
 * @author Lenovo
 * @since 2020-01-03 13:09:37
 */
@Repository("salesDao")
public class SalesDaoImpl extends BaseDaoImpl<Sales, Long> implements SalesDao {
	private final static String NAMESPACE = "com.com.imust.dao.SalesDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}