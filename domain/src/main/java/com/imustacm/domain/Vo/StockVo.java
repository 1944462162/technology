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
@ApiModel("原料库存")
@Data
public class StockVo extends BaseDomain {


	public StockVo() {
		//默认无参构造方法
	}
	@ApiModelProperty(value = "原料库存ID",example = "1")
	private Integer id;

	// max length: 80
	@ApiModelProperty(value = "名称",example = "Fe")
	private String stockName;

	@ApiModelProperty(value = "单位",example = "kg")
	private String unit;

	@ApiModelProperty(value = "重量",example = "36.5")
	private String weight;
	 
}