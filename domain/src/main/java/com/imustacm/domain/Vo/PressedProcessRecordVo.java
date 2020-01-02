package com.imustacm.domain.Vo;
import com.imustacm.domain.base.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @author Lenovo
 * @since 2020-01-02 10:10:07
 */

@ApiModel("压型工艺记录表")
@Data
public class PressedProcessRecordVo extends BaseDomain {

	private static final long serialVersionUID = 6097849367L;

	public PressedProcessRecordVo() {
		//默认无参构造方法
	}

	@ApiModelProperty(value = "压型工艺记录表ID",example = "1")
	private Integer id;

	// max length: 100
	@ApiModelProperty(value = "编号",example = "#336")
	private String serial;

	@ApiModelProperty(value = "创建时间",example = "2020-1-3")
	private String createTime;

	// max length: 1000

	@ApiModelProperty(value = "压型工艺相关信息")
	private String pressedInfor;

}