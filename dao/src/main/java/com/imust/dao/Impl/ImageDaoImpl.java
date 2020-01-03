package com.imust.dao.Impl;

import org.springframework.stereotype.Repository;
import com.imust.domain.Po.Image;
import com.imust.dao.base.BaseDaoImpl;
import com.imust.dao.ImageDao;

/**
 * ImageDao 实现类
 * @author Lenovo
 * @since 2020-01-03 13:09:36
 */
@Repository("imageDao")
public class ImageDaoImpl extends BaseDaoImpl<Image, Long> implements ImageDao {
	private final static String NAMESPACE = "com.com.imust.dao.ImageDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}