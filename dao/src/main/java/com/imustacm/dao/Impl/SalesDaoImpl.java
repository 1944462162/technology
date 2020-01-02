package com.imustacm.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.Sales;
import com.imustacm.dao.base.BaseDaoImpl;
import com.imustacm.dao.SalesDao;

/**
 * SalesDao 实现类
 * @author Lenovo
 * @since 2019-12-25 10:45:24
 */
@Repository("salesDao")
public class SalesDaoImpl extends BaseDaoImpl<Sales, Long> implements SalesDao {
	private final static String NAMESPACE = "com.imustacm.dao.SalesDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}