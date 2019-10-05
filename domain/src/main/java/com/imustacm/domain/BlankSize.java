/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.domain;

import com.imustacm.domain.base.BaseDomain;


/**
 * 
 * @author Lenovo
 * @since 2019-09-28 20:19:30
 */
public class BlankSize extends BaseDomain {

	private static final long serialVersionUID = 6892851957L;

	public BlankSize() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 100
	private String number;

	private String suppress;

	private String modeWidth;

	private String orientation;

	public Integer getId() {
		return this.id;
	}
    public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNumber() {
		return this.number;
	}
    public void setNumber(String number) {
		this.number = number;
	}
	
	public String getSuppress() {
		return this.suppress;
	}
    public void setSuppress(String suppress) {
		this.suppress = suppress;
	}
	
	public String getModeWidth() {
		return this.modeWidth;
	}
    public void setModeWidth(String modeWidth) {
		this.modeWidth = modeWidth;
	}
	
	public String getOrientation() {
		return this.orientation;
	}
    public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	 
}