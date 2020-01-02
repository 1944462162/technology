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
@ApiModel("制粉工艺记录")
@Data
public class FlourMillingProcessRecordVo extends BaseDomain {


	public FlourMillingProcessRecordVo() {
		//默认无参构造方法
	}
	@ApiModelProperty(value = "制粉工艺记录ID",example = "1")
	private Integer id;

	// max length: 100
	@ApiModelProperty(value = "编号",example = "#199")
	private String serial;

	@ApiModelProperty("操作人")
	private String operator;

	// max length: 80
	@ApiModelProperty(value = "创建时间",example = "2019-6-5")
	private String createTime;

	@ApiModelProperty(value = "设备运行情况",example = "正常")
	private String machineStatus;

	@ApiModelProperty(value = "投料料量",example = "63.2")
	private String feedWeight;

	// max length: 400
	@ApiModelProperty(value = "投料说明",example = "全部投入")
	private String feedNote;

	@ApiModelProperty(value = "料重",example = "69.3")
	private String materialWeight;

	@ApiModelProperty(value = "吐料",example = "65.3")
	private String spittingWeight;

	@ApiModelProperty(value = "收率",example = "0.69")
	private String yield;

	@ApiModelProperty(value = "备注",example = "正常")
	// max length: 400
	private String note;

	@ApiModelProperty(value = "制粉细节",example = "制粉相关的信息")
	private String flourDetails;


}