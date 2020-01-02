package com.imustacm.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imustacm.domain.Po.Storage;
import com.imustacm.dao.base.BaseDaoImpl;
import com.imustacm.dao.StorageDao;

/**
 * StorageDao 实现类
 * @author Lenovo
 * @since 2019-12-25 10:45:24
 */
@Repository("storageDao")
public class StorageDaoImpl extends BaseDaoImpl<Storage, Long> implements StorageDao {
	private final static String NAMESPACE = "com.imustacm.dao.StorageDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}