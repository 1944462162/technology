package com.imustacm.dao.Impl;

import com.imustacm.dao.BlankSizeDao;
import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.BlankSize;
import com.imustacm.dao.base.BaseDaoImpl;

/**
 * BlankSizeDao 实现类
 * @author Lenovo
 * @since 2019-11-10 20:45:56
 */
@Repository("blankSizeDao")
public class BlankSizeDaoImpl extends BaseDaoImpl<BlankSize, Long> implements BlankSizeDao {
	private final static String NAMESPACE = "com.imustacm.dao.BlankSizeDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}