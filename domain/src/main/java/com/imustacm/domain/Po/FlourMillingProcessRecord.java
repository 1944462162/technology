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
public class FlourMillingProcessRecord extends BaseDomain {

	private static final long serialVersionUID = 29401824817L;

	public FlourMillingProcessRecord() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 80
	private String number;

	private String operator;

	// max length: 80
	private String createTime;

	private String operationOfEquipment;

	private String feedWeight;

	// max length: 400
	private String feedInstructions;

	private String millingStarTime;

	// max length: 80
	private String millingEndTime;

	private String millingTime;

	private String starOxygenContent;

	private String processOxygenContent;

	private String endOxygenContent;

	private String speed;

	private String grindPressure;

	private String millingStarFlow;

	private String millingEndFlow;

	private String materialWeight;

	private String spitting;

	private String yield;

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
	
	public String getOperationOfEquipment() {
		return this.operationOfEquipment;
	}
    public void setOperationOfEquipment(String operationOfEquipment) {
		this.operationOfEquipment = operationOfEquipment;
	}
	
	public String getFeedWeight() {
		return this.feedWeight;
	}
    public void setFeedWeight(String feedWeight) {
		this.feedWeight = feedWeight;
	}
	
	public String getFeedInstructions() {
		return this.feedInstructions;
	}
    public void setFeedInstructions(String feedInstructions) {
		this.feedInstructions = feedInstructions;
	}
	
	public String getMillingStarTime() {
		return this.millingStarTime;
	}
    public void setMillingStarTime(String millingStarTime) {
		this.millingStarTime = millingStarTime;
	}
	
	public String getMillingEndTime() {
		return this.millingEndTime;
	}
    public void setMillingEndTime(String millingEndTime) {
		this.millingEndTime = millingEndTime;
	}
	
	public String getMillingTime() {
		return this.millingTime;
	}
    public void setMillingTime(String millingTime) {
		this.millingTime = millingTime;
	}
	
	public String getStarOxygenContent() {
		return this.starOxygenContent;
	}
    public void setStarOxygenContent(String starOxygenContent) {
		this.starOxygenContent = starOxygenContent;
	}
	
	public String getProcessOxygenContent() {
		return this.processOxygenContent;
	}
    public void setProcessOxygenContent(String processOxygenContent) {
		this.processOxygenContent = processOxygenContent;
	}
	
	public String getEndOxygenContent() {
		return this.endOxygenContent;
	}
    public void setEndOxygenContent(String endOxygenContent) {
		this.endOxygenContent = endOxygenContent;
	}
	
	public String getSpeed() {
		return this.speed;
	}
    public void setSpeed(String speed) {
		this.speed = speed;
	}
	
	public String getGrindPressure() {
		return this.grindPressure;
	}
    public void setGrindPressure(String grindPressure) {
		this.grindPressure = grindPressure;
	}
	
	public String getMillingStarFlow() {
		return this.millingStarFlow;
	}
    public void setMillingStarFlow(String millingStarFlow) {
		this.millingStarFlow = millingStarFlow;
	}
	
	public String getMillingEndFlow() {
		return this.millingEndFlow;
	}
    public void setMillingEndFlow(String millingEndFlow) {
		this.millingEndFlow = millingEndFlow;
	}
	
	public String getMaterialWeight() {
		return this.materialWeight;
	}
    public void setMaterialWeight(String materialWeight) {
		this.materialWeight = materialWeight;
	}
	
	public String getSpitting() {
		return this.spitting;
	}
    public void setSpitting(String spitting) {
		this.spitting = spitting;
	}
	
	public String getYield() {
		return this.yield;
	}
    public void setYield(String yield) {
		this.yield = yield;
	}
	
	public String getRemarks() {
		return this.remarks;
	}
    public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	 
}