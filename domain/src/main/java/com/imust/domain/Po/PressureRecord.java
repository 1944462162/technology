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
public class PressureRecord extends BaseDomain {

	private static final long serialVersionUID = 19752893159L;

	public PressureRecord() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 100
	private String serial;

	private String machineSerial;

	// max length: 80
	private String createTime;

	private Integer billetAmount;

	private String pickingWeight;

	private String singleProduct;

	// max length: 100
	private String toolsInfo;

	private String starNitrogen;

	private String endNitrogen;

	// max length: 100
	private String operator;

	private String note;

	// max length: 10000
	private String billetSizes;

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
	
	public String getMachineSerial() {
		return this.machineSerial;
	}
    public void setMachineSerial(String machineSerial) {
		this.machineSerial = machineSerial;
	}
	
	public String getCreateTime() {
		return this.createTime;
	}
    public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public Integer getBilletAmount() {
		return this.billetAmount;
	}
    public void setBilletAmount(Integer billetAmount) {
		this.billetAmount = billetAmount;
	}
	
	public String getPickingWeight() {
		return this.pickingWeight;
	}
    public void setPickingWeight(String pickingWeight) {
		this.pickingWeight = pickingWeight;
	}
	
	public String getSingleProduct() {
		return this.singleProduct;
	}
    public void setSingleProduct(String singleProduct) {
		this.singleProduct = singleProduct;
	}
	
	public String getToolsInfo() {
		return this.toolsInfo;
	}
    public void setToolsInfo(String toolsInfo) {
		this.toolsInfo = toolsInfo;
	}
	
	public String getStarNitrogen() {
		return this.starNitrogen;
	}
    public void setStarNitrogen(String starNitrogen) {
		this.starNitrogen = starNitrogen;
	}
	
	public String getEndNitrogen() {
		return this.endNitrogen;
	}
    public void setEndNitrogen(String endNitrogen) {
		this.endNitrogen = endNitrogen;
	}
	
	public String getOperator() {
		return this.operator;
	}
    public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getNote() {
		return this.note;
	}
    public void setNote(String note) {
		this.note = note;
	}
	
	public String getBilletSizes() {
		return this.billetSizes;
	}
    public void setBilletSizes(String billetSizes) {
		this.billetSizes = billetSizes;
	}
	 
}