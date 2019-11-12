package com.imustacm.dao.Impl;

import com.imustacm.dao.RelationshipAgglomerationProcessDao;
import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.RelationshipAgglomerationProcess;
import com.imustacm.dao.base.BaseDaoImpl;

/**
 * RelationshipAgglomerationProcessDao 实现类
 * @author Lenovo
 * @since 2019-11-10 20:45:57
 */
@Repository("relationshipAgglomerationProcessDao")
public class RelationshipAgglomerationProcessDaoImpl extends BaseDaoImpl<RelationshipAgglomerationProcess, Long> implements RelationshipAgglomerationProcessDao {
	private final static String NAMESPACE = "com.imustacm.dao.RelationshipAgglomerationProcessDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}