/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.domain.Vo;
import com.imustacm.domain.base.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 
 * @author Lenovo
 * @since 2019-12-23 17:41:03
 */
@ApiModel("压型记录表")
@Data
public class PressureRecordVo extends BaseDomain {

	public PressureRecordVo() {
		//默认无参构造方法
	}
	@ApiModelProperty(value = "压型记录表ID",example = "1")
	private Integer id;

	@ApiModelProperty(value = "编号",example = "693")
	// max length: 100
	private String serial;

	@ApiModelProperty(value = "压机编号",example = "#336")
	private String machineSerial;

	@ApiModelProperty(value = "创建时间",example = "2016-3-5")
	// max length: 80
	private String createTime;

	@ApiModelProperty(value = "毛坯数量",example = "32")
	private Integer billetAmount;

	@ApiModelProperty(value = "领料",example = "56")
	private String pickingWeight;

	@ApiModelProperty(value = "产品单重",example = "36.5")
	private String singleProduct;

	// max length: 100
	@ApiModelProperty(value = "磨具编号和尺寸",example = "36.5")
	private String toolsInfo;

	@ApiModelProperty(value = "开始氧气量",example = "35.5")
	private String starNitrogen;

	@ApiModelProperty(value = "结束氧气量",example = "786.3")
	private String endNitrogen;

	// max length: 100
	@ApiModelProperty(value = "操作人",example = "张三")
	private String operator;

	@ApiModelProperty(value = "备注",example = "正常")
	private String note;

	@ApiModelProperty(value = "设计压坯尺寸",example = "尺寸信息")
	// max length: 10000
	private String billetSizes;

	 
}