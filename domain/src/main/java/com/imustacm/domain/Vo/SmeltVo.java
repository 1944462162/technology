/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.domain.Vo;
import com.imustacm.domain.base.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @author Lenovo
 * @since 2019-12-23 17:41:03
 */
@ApiModel("冶炼表")
@Data
public class SmeltVo extends BaseDomain {


	public SmeltVo() {
		//默认无参构造方法
	}
	@ApiModelProperty(value = "冶炼ID",example = "1")
	private Integer id;

	// max length: 80
	@ApiModelProperty(value = "创建日期",example = "2016-5-3")
	private String createTime;

	@ApiModelProperty(value = "编号",example = "#635")
	private String serial;

	@ApiModelProperty(value = "桶信息",example = "桶相关的信息")
	// max length: 100
	private String bucketsInfo;

	@ApiModelProperty(value = "出料",example = "63.2")
	private String outWeigth;

	@ApiModelProperty(value = "入料",example = "653.3")
	private String feedWeigth;

	@ApiModelProperty(value = "收率",example = "0.63")
	private String yield;

	// max length: 100
	@ApiModelProperty(value = "操作人",example = "张三")
	private String operator;

}