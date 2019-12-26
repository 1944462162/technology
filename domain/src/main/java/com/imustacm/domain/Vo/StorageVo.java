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
@ApiModel("入库表")
@Data
public class StorageVo extends BaseDomain {

	public StorageVo() {
		//默认无参构造方法
	}
	@ApiModelProperty(value = "入库ID", example = "1")
	private Integer id;

	// max length: 80
	@ApiModelProperty(value = "名称", example = "Fe")
	private String name;

	@ApiModelProperty(value = "数量", example = "100.55")
	private String numbers;

	@ApiModelProperty(value = "创建日期",example = "2017-5-3")
	// max length: 100
	private String createDate;

	@ApiModelProperty(value = "备注",example = "正常")
	private String note;

}