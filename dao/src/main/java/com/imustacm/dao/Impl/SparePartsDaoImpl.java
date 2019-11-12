package com.imustacm.dao.Impl;

import com.imustacm.dao.SparePartsDao;
import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.SpareParts;
import com.imustacm.dao.base.BaseDaoImpl;

/**
 * SparePartsDao 实现类
 * @author Lenovo
 * @since 2019-11-10 20:45:57
 */
@Repository("sparePartsDao")
public class SparePartsDaoImpl extends BaseDaoImpl<SpareParts, Long> implements SparePartsDao {
	private final static String NAMESPACE = "com.imustacm.dao.SparePartsDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}