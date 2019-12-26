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
@Data
@ApiModel("烧结工艺记录")
public class AgglomerationProcessRecordVo extends BaseDomain {

	public AgglomerationProcessRecordVo() {
		//默认无参构造方法
	}
	@ApiModelProperty(value = "烧结工艺记录ID", example = "1")
	private Integer id;

	// max length: 80
	@ApiModelProperty(value = "日期",example = "2016-9-6")
	private String createTime;

	@ApiModelProperty(value = "编号",example = "192")
	private String serial;

	@ApiModelProperty(value = "装炉块数",example = "12")
	private Integer furnaceNumber;

	@ApiModelProperty(value = "装炉重量",example = "23.5")
	private String furnaceWeight;

	@ApiModelProperty(value = "单间重量",example = "26")
	private String singleWeight;

	@ApiModelProperty(value = "单盒重量",example = "27")
	private String boxCapacity;

	@ApiModelProperty(value = "开始电量",example = "56")
	private String startPower;

	@ApiModelProperty(value = "结束电量",example = "96")
	private String endPower;

	@ApiModelProperty(value = "合计电量",example = "46")
	private String totalPower;

	@ApiModelProperty(value = "操作人信息",example = "白班 张三 夜班 李四")
	// max length: 100
	private String operatorInfo;

	@ApiModelProperty(value = "备注",example = "正常")
	private String note;

	@ApiModelProperty(value = "烧结工艺",example = "烧结工艺信息")
	// max length: 20000
	private String sinterRecord;
	 
}