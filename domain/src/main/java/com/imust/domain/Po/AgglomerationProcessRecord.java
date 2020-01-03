/*
 * Copyright (c) 2020 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imust.domain.Po;
import com.imust.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2020-01-03 13:09:36
 */
public class AgglomerationProcessRecord extends BaseDomain {

	private static final long serialVersionUID = 17737313815L;

	public AgglomerationProcessRecord() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 80
	private String createTime;

	private String serial;

	private Integer furnaceNumber;

	private String furnaceWeight;

	private String singleWeight;

	private String boxCapacity;

	private String startPower;

	private String endPower;

	private String totalPower;

	// max length: 1000
	private String operatorInfo;

	private String note;

	// max length: 20000
	private String sinterRecord;

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
	
	public Integer getFurnaceNumber() {
		return this.furnaceNumber;
	}
    public void setFurnaceNumber(Integer furnaceNumber) {
		this.furnaceNumber = furnaceNumber;
	}
	
	public String getFurnaceWeight() {
		return this.furnaceWeight;
	}
    public void setFurnaceWeight(String furnaceWeight) {
		this.furnaceWeight = furnaceWeight;
	}
	
	public String getSingleWeight() {
		return this.singleWeight;
	}
    public void setSingleWeight(String singleWeight) {
		this.singleWeight = singleWeight;
	}
	
	public String getBoxCapacity() {
		return this.boxCapacity;
	}
    public void setBoxCapacity(String boxCapacity) {
		this.boxCapacity = boxCapacity;
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
	
	public String getTotalPower() {
		return this.totalPower;
	}
    public void setTotalPower(String totalPower) {
		this.totalPower = totalPower;
	}
	
	public String getOperatorInfo() {
		return this.operatorInfo;
	}
    public void setOperatorInfo(String operatorInfo) {
		this.operatorInfo = operatorInfo;
	}
	
	public String getNote() {
		return this.note;
	}
    public void setNote(String note) {
		this.note = note;
	}
	
	public String getSinterRecord() {
		return this.sinterRecord;
	}
    public void setSinterRecord(String sinterRecord) {
		this.sinterRecord = sinterRecord;
	}
	 
}