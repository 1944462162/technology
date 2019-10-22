/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.domain.Po;
import com.imustacm.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2019-10-21 11:00:16
 */
public class RelationshipDieAndBlank extends BaseDomain {

	private static final long serialVersionUID = 6169752249L;

	public RelationshipDieAndBlank() {
		//默认无参构造方法
	}
	private Integer pressureRecordId;

	private Integer blankSizeId;

	public Integer getPressureRecordId() {
		return this.pressureRecordId;
	}
    public void setPressureRecordId(Integer pressureRecordId) {
		this.pressureRecordId = pressureRecordId;
	}
	
	public Integer getBlankSizeId() {
		return this.blankSizeId;
	}
    public void setBlankSizeId(Integer blankSizeId) {
		this.blankSizeId = blankSizeId;
	}
	 
}