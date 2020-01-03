package com.imust.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imust.domain.Po.Stock;
import com.imust.dao.base.BaseDaoImpl;
import com.imust.dao.StockDao;

/**
 * StockDao 实现类
 * @author Lenovo
 * @since 2020-01-03 13:09:37
 */
@Repository("stockDao")
public class StockDaoImpl extends BaseDaoImpl<Stock, Long> implements StockDao {
	private final static String NAMESPACE = "com.com.imust.dao.StockDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}