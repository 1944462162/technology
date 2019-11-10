/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.domain.Po;
import com.imustacm.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2019-11-10 20:45:57
 */
public class SmeltingRecord extends BaseDomain {

	private static final long serialVersionUID = 24461831965L;

	public SmeltingRecord() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 100
	private String number;

	private String createTime;

	// max length: 100
	private String operator;

	private String rawMaterialAllUp;

	private String tundishMaterial;

	private Integer crucibleCount;

	// max length: 100
	private String operationSteps;

	private String operationTime;

	private String vacuum;

	private String heatPower;

	private String temperature;

	private String discharge;

	private String waterTemperature;

	// max length: 400
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
	
	public String getCreateTime() {
		return this.createTime;
	}
    public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getOperator() {
		return this.operator;
	}
    public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getRawMaterialAllUp() {
		return this.rawMaterialAllUp;
	}
    public void setRawMaterialAllUp(String rawMaterialAllUp) {
		this.rawMaterialAllUp = rawMaterialAllUp;
	}
	
	public String getTundishMaterial() {
		return this.tundishMaterial;
	}
    public void setTundishMaterial(String tundishMaterial) {
		this.tundishMaterial = tundishMaterial;
	}
	
	public Integer getCrucibleCount() {
		return this.crucibleCount;
	}
    public void setCrucibleCount(Integer crucibleCount) {
		this.crucibleCount = crucibleCount;
	}
	
	public String getOperationSteps() {
		return this.operationSteps;
	}
    public void setOperationSteps(String operationSteps) {
		this.operationSteps = operationSteps;
	}
	
	public String getOperationTime() {
		return this.operationTime;
	}
    public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}
	
	public String getVacuum() {
		return this.vacuum;
	}
    public void setVacuum(String vacuum) {
		this.vacuum = vacuum;
	}
	
	public String getHeatPower() {
		return this.heatPower;
	}
    public void setHeatPower(String heatPower) {
		this.heatPower = heatPower;
	}
	
	public String getTemperature() {
		return this.temperature;
	}
    public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	public String getDischarge() {
		return this.discharge;
	}
    public void setDischarge(String discharge) {
		this.discharge = discharge;
	}
	
	public String getWaterTemperature() {
		return this.waterTemperature;
	}
    public void setWaterTemperature(String waterTemperature) {
		this.waterTemperature = waterTemperature;
	}
	
	public String getRemarks() {
		return this.remarks;
	}
    public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	 
}