/*
 * Copyright (c) 2020 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imust.domain.Po;
import com.imust.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2020-01-03 13:09:37
 */
public class Smelt extends BaseDomain {

	private static final long serialVersionUID = 11093169371L;

	public Smelt() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 80
	private String createTime;

	private String serial;

	// max length: 100
	private String bucketsInfo;

	private String outWeigth;

	private String feedWeigth;

	private String yield;

	// max length: 100
	private String operator;

	public Integer getId() {
		return this.id;
	}
    public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCreateTime() {
		return this.createTime;
	}
    public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getSerial() {
		return this.serial;
	}
    public void setSerial(String serial) {
		this.serial = serial;
	}
	
	public String getBucketsInfo() {
		return this.bucketsInfo;
	}
    public void setBucketsInfo(String bucketsInfo) {
		this.bucketsInfo = bucketsInfo;
	}
	
	public String getOutWeigth() {
		return this.outWeigth;
	}
    public void setOutWeigth(String outWeigth) {
		this.outWeigth = outWeigth;
	}
	
	public String getFeedWeigth() {
		return this.feedWeigth;
	}
    public void setFeedWeigth(String feedWeigth) {
		this.feedWeigth = feedWeigth;
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