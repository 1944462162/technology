package com.imustacm.dao.Impl;

import com.imustacm.dao.AgglomerationProcessDao;
import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.AgglomerationProcess;
import com.imustacm.dao.base.BaseDaoImpl;

/**
 * AgglomerationProcessDao 实现类
 * @author Lenovo
 * @since 2019-11-10 20:45:56
 */
@Repository("agglomerationProcessDao")
public class AgglomerationProcessDaoImpl extends BaseDaoImpl<AgglomerationProcess, Long> implements AgglomerationProcessDao {
	private final static String NAMESPACE = "com.imustacm.dao.AgglomerationProcessDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}