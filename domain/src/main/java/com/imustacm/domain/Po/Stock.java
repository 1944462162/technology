/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.domain.Po;

import com.imustacm.domain.base.BaseDomain;

import java.util.Date;

/**
 * 
 * @author Lenovo
 * @since 2019-09-28 20:19:30
 */
public class Stock extends BaseDomain {

	private static final long serialVersionUID = 8975113928L;

	public Stock() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 80
	private String name;

	private String company;

	private String initialStage;

	private String increase;

	private String reduce;

	private String weight;

	private Date createTime;

	public Integer getId() {
		return this.id;
	}
    public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
    public void setName(String name) {
		this.name = name;
	}
	
	public String getCompany() {
		return this.company;
	}
    public void setCompany(String company) {
		this.company = company;
	}
	
	public String getInitialStage() {
		return this.initialStage;
	}
    public void setInitialStage(String initialStage) {
		this.initialStage = initialStage;
	}
	
	public String getIncrease() {
		return this.increase;
	}
    public void setIncrease(String increase) {
		this.increase = increase;
	}
	
	public String getReduce() {
		return this.reduce;
	}
    public void setReduce(String reduce) {
		this.reduce = reduce;
	}
	
	public String getWeight() {
		return this.weight;
	}
    public void setWeight(String weight) {
		this.weight = weight;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
    public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	 
}