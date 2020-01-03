package com.imust.domain.Vo;
import com.imust.domain.base.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @author Lenovo
 * @since 2019-12-23 19:22:16
 */
@ApiModel("销售表")
@Data
public class SalesVo extends BaseDomain {

	public SalesVo() {
		//默认无参构造方法
	}
	@ApiModelProperty(value = "销售表ID",example = "1")
	private Integer id;

	// max length: 100
	@ApiModelProperty(value = "编号",example = "179")
	private String serial;

	@ApiModelProperty(value = "数量",example = "23")
	private String amount;

	// max length: 100
	@ApiModelProperty(value = "日期",example = "2016-5-3")
	private String createDate;

	@ApiModelProperty(value = "备注",example = "正常")
	private String note;

	 
}