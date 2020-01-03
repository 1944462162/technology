package com.imust.domain.Vo;
import com.imust.domain.base.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @author Lenovo
 * @since 2019-12-23 17:41:03
 */
@ApiModel("冶炼操作记录")
@Data
public class SmeltingRecordVo extends BaseDomain {

	private static final long serialVersionUID = 16080274113L;

	public SmeltingRecordVo() {
		//默认无参构造方法
	}
	@ApiModelProperty(value = "记录ID",example = "1")
	private Integer id;

	// max length: 100
	@ApiModelProperty(value = "编号",example = "#635")
	private String serial;

	@ApiModelProperty(value = "记录日期",example = "2016-5-9")
	private String createTime;

	// max length: 100

	@ApiModelProperty(value = "操作人员",example = "张三")
	private String operator;

	@ApiModelProperty(value = "原料总重",example = "36.2")
	private String feedWeight;

	@ApiModelProperty(value = "中间包料",example = "63.2")
	private String midWeight;

	@ApiModelProperty(value = "坩埚使用次数",example = "33")
	private Integer crucibleCount;

	@ApiModelProperty(value = "备注",example = "正常")
	// max length: 400
	private String note;

	@ApiModelProperty(value = "冶炼细节",example = "冶炼相关操作")
	private String smeltingDetails;


}