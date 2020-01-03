package com.imust.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imust.domain.Po.SpareParts;
import com.imust.dao.base.BaseDaoImpl;
import com.imust.dao.SparePartsDao;

/**
 * SparePartsDao 实现类
 * @author Lenovo
 * @since 2020-01-03 13:09:37
 */
@Repository("sparePartsDao")
public class SparePartsDaoImpl extends BaseDaoImpl<SpareParts, Long> implements SparePartsDao {
	private final static String NAMESPACE = "com.com.imust.dao.SparePartsDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}