package com.imustacm.dao.Impl;

import com.imustacm.dao.RelationshipDieAndBlankDao;
import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.RelationshipDieAndBlank;
import com.imustacm.dao.base.BaseDaoImpl;

/**
 * RelationshipDieAndBlankDao 实现类
 * @author Lenovo
 * @since 2019-11-10 20:45:57
 */
@Repository("relationshipDieAndBlankDao")
public class RelationshipDieAndBlankDaoImpl extends BaseDaoImpl<RelationshipDieAndBlank, Long> implements RelationshipDieAndBlankDao {
	private final static String NAMESPACE = "com.imustacm.dao.RelationshipDieAndBlankDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}