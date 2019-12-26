/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.domain.Po;
import com.imustacm.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2019-12-25 10:45:23
 */
public class FlourMillingProcessRecord extends BaseDomain {

	private static final long serialVersionUID = 16702185387L;

	public FlourMillingProcessRecord() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 100
	private String serial;

	private String operator;

	// max length: 80
	private String createTime;

	private String machineStatus;

	private String feedWeight;

	// max length: 400
	private String feedNote;

	private String materialWeight;

	private String spittingWeight;

	private String yield;

	// max length: 400
	private String note;

	private String flourDetails;

	public Integer getId() {
		return this.id;
	}
    public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSerial() {
		return this.serial;
	}
    public void setSerial(String serial) {
		this.serial = serial;
	}
	
	public String getOperator() {
		return this.operator;
	}
    public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getCreateTime() {
		return this.createTime;
	}
    public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getMachineStatus() {
		return this.machineStatus;
	}
    public void setMachineStatus(String machineStatus) {
		this.machineStatus = machineStatus;
	}
	
	public String getFeedWeight() {
		return this.feedWeight;
	}
    public void setFeedWeight(String feedWeight) {
		this.feedWeight = feedWeight;
	}
	
	public String getFeedNote() {
		return this.feedNote;
	}
    public void setFeedNote(String feedNote) {
		this.feedNote = feedNote;
	}
	
	public String getMaterialWeight() {
		return this.materialWeight;
	}
    public void setMaterialWeight(String materialWeight) {
		this.materialWeight = materialWeight;
	}
	
	public String getSpittingWeight() {
		return this.spittingWeight;
	}
    public void setSpittingWeight(String spittingWeight) {
		this.spittingWeight = spittingWeight;
	}
	
	public String getYield() {
		return this.yield;
	}
    public void setYield(String yield) {
		this.yield = yield;
	}
	
	public String getNote() {
		return this.note;
	}
    public void setNote(String note) {
		this.note = note;
	}
	
	public String getFlourDetails() {
		return this.flourDetails;
	}
    public void setFlourDetails(String flourDetails) {
		this.flourDetails = flourDetails;
	}
	 
}