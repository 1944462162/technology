package com.imust.domain.Vo;
import com.imust.domain.base.BaseDomain;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 
 * @author Lenovo
 * @since 2020-01-03 20:12:18
 */

@ApiModel("入粉库")
@Data
public class PowderVo extends BaseDomain {

	private static final long serialVersionUID = 6501993529L;

	public PowderVo() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 100
	private String serial;

	private String number;

	// max length: 80
	private String createTime;
	 
}