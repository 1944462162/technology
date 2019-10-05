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
public class PressureRecord extends BaseDomain {

	private static final long serialVersionUID = 29483407244L;

	public PressureRecord() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 100
	private String number;

	private String pressNumber;

	private Date createTime;

	private Integer roughcastNumber;

	private String picking;

	private String singleProduct;

	// max length: 100
	private String toolsNumber;

	private String toolsSize;

	private String suppressPressure;

	private Date suppressTime;

	private String magnetizingCurrent;

	private Date magentizingTime;

	private String demagnetizationCurrent;

	private Date demagnetizatioTime;

	// max length: 100
	private String oxygenWeighingRoom;

	private String oxygenPackingRoom;

	private String starNitrogen;

	private String endNitrogen;

	// max length: 100
	private String operator;

	private String remarks;

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
	
	public String getPressNumber() {
		return this.pressNumber;
	}
    public void setPressNumber(String pressNumber) {
		this.pressNumber = pressNumber;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
    public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Integer getRoughcastNumber() {
		return this.roughcastNumber;
	}
    public void setRoughcastNumber(Integer roughcastNumber) {
		this.roughcastNumber = roughcastNumber;
	}
	
	public String getPicking() {
		return this.picking;
	}
    public void setPicking(String picking) {
		this.picking = picking;
	}
	
	public String getSingleProduct() {
		return this.singleProduct;
	}
    public void setSingleProduct(String singleProduct) {
		this.singleProduct = singleProduct;
	}
	
	public String getToolsNumber() {
		return this.toolsNumber;
	}
    public void setToolsNumber(String toolsNumber) {
		this.toolsNumber = toolsNumber;
	}
	
	public String getToolsSize() {
		return this.toolsSize;
	}
    public void setToolsSize(String toolsSize) {
		this.toolsSize = toolsSize;
	}
	
	public String getSuppressPressure() {
		return this.suppressPressure;
	}
    public void setSuppressPressure(String suppressPressure) {
		this.suppressPressure = suppressPressure;
	}
	
	public Date getSuppressTime() {
		return this.suppressTime;
	}
    public void setSuppressTime(Date suppressTime) {
		this.suppressTime = suppressTime;
	}
	
	public String getMagnetizingCurrent() {
		return this.magnetizingCurrent;
	}
    public void setMagnetizingCurrent(String magnetizingCurrent) {
		this.magnetizingCurrent = magnetizingCurrent;
	}
	
	public Date getMagentizingTime() {
		return this.magentizingTime;
	}
    public void setMagentizingTime(Date magentizingTime) {
		this.magentizingTime = magentizingTime;
	}
	
	public String getDemagnetizationCurrent() {
		return this.demagnetizationCurrent;
	}
    public void setDemagnetizationCurrent(String demagnetizationCurrent) {
		this.demagnetizationCurrent = demagnetizationCurrent;
	}
	
	public Date getDemagnetizatioTime() {
		return this.demagnetizatioTime;
	}
    public void setDemagnetizatioTime(Date demagnetizatioTime) {
		this.demagnetizatioTime = demagnetizatioTime;
	}
	
	public String getOxygenWeighingRoom() {
		return this.oxygenWeighingRoom;
	}
    public void setOxygenWeighingRoom(String oxygenWeighingRoom) {
		this.oxygenWeighingRoom = oxygenWeighingRoom;
	}
	
	public String getOxygenPackingRoom() {
		return this.oxygenPackingRoom;
	}
    public void setOxygenPackingRoom(String oxygenPackingRoom) {
		this.oxygenPackingRoom = oxygenPackingRoom;
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
	
	public String getRemarks() {
		return this.remarks;
	}
    public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	 
}