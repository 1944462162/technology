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
public class Smelt extends BaseDomain {

	private static final long serialVersionUID = 14899818172L;

	public Smelt() {
		//默认无参构造方法
	}
	private Integer id;

	private Date createTime;

	// max length: 100
	private String number;

	private String fristTare;

	private String fristNetWeight;

	private String secondTare;

	private String secondNetWeight;

	private String discharge;

	private String feeding;

	private String yield;

	// max length: 100
	private String operator;

	public Integer getId() {
		return this.id;
	}
    public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
    public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getNumber() {
		return this.number;
	}
    public void setNumber(String number) {
		this.number = number;
	}
	
	public String getFristTare() {
		return this.fristTare;
	}
    public void setFristTare(String fristTare) {
		this.fristTare = fristTare;
	}
	
	public String getFristNetWeight() {
		return this.fristNetWeight;
	}
    public void setFristNetWeight(String fristNetWeight) {
		this.fristNetWeight = fristNetWeight;
	}
	
	public String getSecondTare() {
		return this.secondTare;
	}
    public void setSecondTare(String secondTare) {
		this.secondTare = secondTare;
	}
	
	public String getSecondNetWeight() {
		return this.secondNetWeight;
	}
    public void setSecondNetWeight(String secondNetWeight) {
		this.secondNetWeight = secondNetWeight;
	}
	
	public String getDischarge() {
		return this.discharge;
	}
    public void setDischarge(String discharge) {
		this.discharge = discharge;
	}
	
	public String getFeeding() {
		return this.feeding;
	}
    public void setFeeding(String feeding) {
		this.feeding = feeding;
	}
	
	public String getYield() {
		return this.yield;
	}
    public void setYield(String yield) {
		this.yield = yield;
	}
	
	public String getOperator() {
		return this.operator;
	}
    public void setOperator(String operator) {
		this.operator = operator;
	}
	 
}