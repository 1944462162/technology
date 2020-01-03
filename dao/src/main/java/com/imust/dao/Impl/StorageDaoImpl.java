package com.imust.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imust.domain.Po.Storage;
import com.imust.dao.base.BaseDaoImpl;
import com.imust.dao.StorageDao;

/**
 * StorageDao 实现类
 * @author Lenovo
 * @since 2020-01-03 13:09:37
 */
@Repository("storageDao")
public class StorageDaoImpl extends BaseDaoImpl<Storage, Long> implements StorageDao {
	private final static String NAMESPACE = "com.com.imust.dao.StorageDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}