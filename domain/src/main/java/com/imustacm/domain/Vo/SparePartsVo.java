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
@ApiModel("备料")
@Data
public class SparePartsVo extends BaseDomain {

	public SparePartsVo() {
		//默认无参构造方法
	}
	@ApiModelProperty(value = "配料信息ID",example = "1")
	private Integer id;

	@ApiModelProperty(value = "成分",example = "Fe")
	// max length: 100
	private String composition;

	@ApiModelProperty(value = "需求量",example = "23.6")
	private String requirementWeight;

	@ApiModelProperty(value = "配料量",example = "56.3")
	private String ingredientsWeigth;

	@ApiModelProperty(value = "备注",example = "正常")
	// max length: 400
	private String note;

	@ApiModelProperty(value = "创建时间",example = "2016-9-3")
	private String createTime;

	@ApiModelProperty(value = "牌号",example = "#563")
	// max length: 100
	private String serial;

	@ApiModelProperty(value = "配料人",example = "张三")
	private String ingredientOperator;

	// max length: 100
	@ApiModelProperty(value = "复合人",example = "李四")
	private String compositeOperator;

}