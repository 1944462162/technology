/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.domain.Po;
import com.imustacm.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2019-11-10 20:45:57
 */
public class RelationshipAgglomerationProcess extends BaseDomain {

	private static final long serialVersionUID = 5286883264L;

	public RelationshipAgglomerationProcess() {
		//默认无参构造方法
	}
	private Integer recordId;

	private Integer agglomerationId;

	public Integer getRecordId() {
		return this.recordId;
	}
    public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	
	public Integer getAgglomerationId() {
		return this.agglomerationId;
	}
    public void setAgglomerationId(Integer agglomerationId) {
		this.agglomerationId = agglomerationId;
	}
	 
}