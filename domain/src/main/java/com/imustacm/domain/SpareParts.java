/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.domain;

import com.imustacm.domain.base.BaseDomain;

import java.util.Date;

/**
 * 
 * @author Lenovo
 * @since 2019-09-28 20:19:30
 */
public class SpareParts extends BaseDomain {

	private static final long serialVersionUID = 14974223664L;

	public SpareParts() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 100
	private String component;

	private String requirement;

	private String dosage;

	// max length: 400
	private String remarks;

	private Date createTime;

	private Integer brandName;

	// max length: 100
	private String ingredientPerson;

	private String reviewer;

	public Integer getId() {
		return this.id;
	}
    public void setId(Integer id) {
		this.id = id;
	}
	
	public String getComponent() {
		return this.component;
	}
    public void setComponent(String component) {
		this.component = component;
	}
	
	public String getRequirement() {
		return this.requirement;
	}
    public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	
	public String getDosage() {
		return this.dosage;
	}
    public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	
	public String getRemarks() {
		return this.remarks;
	}
    public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
    public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Integer getBrandName() {
		return this.brandName;
	}
    public void setBrandName(Integer brandName) {
		this.brandName = brandName;
	}
	
	public String getIngredientPerson() {
		return this.ingredientPerson;
	}
    public void setIngredientPerson(String ingredientPerson) {
		this.ingredientPerson = ingredientPerson;
	}
	
	public String getReviewer() {
		return this.reviewer;
	}
    public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	 
}