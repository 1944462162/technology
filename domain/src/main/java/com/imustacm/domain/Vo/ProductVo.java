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
@ApiModel("产品库")
@Data
public class ProductVo extends BaseDomain {

	public ProductVo() {
		//默认无参构造方法
	}
	@ApiModelProperty(value = "产品库Id",example = "1")
	private Integer id;

	@ApiModelProperty(value = "编号",example = "#336")
	// max length: 100
	private String serial;

	@ApiModelProperty(value = "数量",example = "32")
	private String amount;

	@ApiModelProperty(value = "产片细节",example = "细节")
	// max length: 100
	private String details;

	@ApiModelProperty(value = "检测信息",example = "正常")
	private String detectionInfo;
	 
}