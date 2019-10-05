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
public class AgglomerationProcessRecord extends BaseDomain {

	private static final long serialVersionUID = 22417943534L;

	public AgglomerationProcessRecord() {
		//默认无参构造方法
	}
	private Integer id;

	private Date createTime;

	// max length: 100
	private String number;

	private Integer blockNumber;

	private String furnaceWeight;

	private String singleRoomWeight;

	private String mononuclearWeight;

	private String startPower;

	private String endPower;

	private String sharePower;

	// max length: 100
	private String fristOperatorDay;

	private String fristOperatorNight;

	// max length: 100
	private String secondOperatorDay;

	private String secondOperatorNight;

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
	
	public Integer getBlockNumber() {
		return this.blockNumber;
	}
    public void setBlockNumber(Integer blockNumber) {
		this.blockNumber = blockNumber;
	}
	
	public String getFurnaceWeight() {
		return this.furnaceWeight;
	}
    public void setFurnaceWeight(String furnaceWeight) {
		this.furnaceWeight = furnaceWeight;
	}
	
	public String getSingleRoomWeight() {
		return this.singleRoomWeight;
	}
    public void setSingleRoomWeight(String singleRoomWeight) {
		this.singleRoomWeight = singleRoomWeight;
	}
	
	public String getMononuclearWeight() {
		return this.mononuclearWeight;
	}
    public void setMononuclearWeight(String mononuclearWeight) {
		this.mononuclearWeight = mononuclearWeight;
	}
	
	public String getStartPower() {
		return this.startPower;
	}
    public void setStartPower(String startPower) {
		this.startPower = startPower;
	}
	
	public String getEndPower() {
		return this.endPower;
	}
    public void setEndPower(String endPower) {
		this.endPower = endPower;
	}
	
	public String getSharePower() {
		return this.sharePower;
	}
    public void setSharePower(String sharePower) {
		this.sharePower = sharePower;
	}
	
	public String getFristOperatorDay() {
		return this.fristOperatorDay;
	}
    public void setFristOperatorDay(String fristOperatorDay) {
		this.fristOperatorDay = fristOperatorDay;
	}
	
	public String getFristOperatorNight() {
		return this.fristOperatorNight;
	}
    public void setFristOperatorNight(String fristOperatorNight) {
		this.fristOperatorNight = fristOperatorNight;
	}
	
	public String getSecondOperatorDay() {
		return this.secondOperatorDay;
	}
    public void setSecondOperatorDay(String secondOperatorDay) {
		this.secondOperatorDay = secondOperatorDay;
	}
	
	public String getSecondOperatorNight() {
		return this.secondOperatorNight;
	}
    public void setSecondOperatorNight(String secondOperatorNight) {
		this.secondOperatorNight = secondOperatorNight;
	}
	 
}