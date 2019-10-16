/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.dao.Impl;

import com.imustacm.dao.BlankSizeDao;
import com.imustacm.dao.base.BaseDaoImpl;
import com.imustacm.domain.Po.BlankSize;
import org.springframework.stereotype.Repository;


/**
 * BlankSizeDao 实现类
 * @author Lenovo
 * @since 2019-09-28 20:19:30
 */
@Repository("blankSizeDao")
public class BlankSizeDaoImpl extends BaseDaoImpl<BlankSize, Long> implements BlankSizeDao {
	private final static String NAMESPACE = "com.imustacm.dao.BlankSizeDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}
}