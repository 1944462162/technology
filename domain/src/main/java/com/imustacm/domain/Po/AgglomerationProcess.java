/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.domain.Po;
import com.imustacm.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2019-11-10 20:45:56
 */
public class AgglomerationProcess extends BaseDomain {

	private static final long serialVersionUID = 10232194985L;

	public AgglomerationProcess() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 80
	private String datatime;

	private String totalTime;

	// max length: 100
	private String sinterProcess;

	private String furnaceTemperature;

	private String vacuumDegree;

	public Integer getId() {
		return this.id;
	}
    public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDatatime() {
		return this.datatime;
	}
    public void setDatatime(String datatime) {
		this.datatime = datatime;
	}
	
	public String getTotalTime() {
		return this.totalTime;
	}
    public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	
	public String getSinterProcess() {
		return this.sinterProcess;
	}
    public void setSinterProcess(String sinterProcess) {
		this.sinterProcess = sinterProcess;
	}
	
	public String getFurnaceTemperature() {
		return this.furnaceTemperature;
	}
    public void setFurnaceTemperature(String furnaceTemperature) {
		this.furnaceTemperature = furnaceTemperature;
	}
	
	public String getVacuumDegree() {
		return this.vacuumDegree;
	}
    public void setVacuumDegree(String vacuumDegree) {
		this.vacuumDegree = vacuumDegree;
	}
	 
}