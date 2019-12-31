/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.domain.Vo;
import com.imustacm.domain.base.BaseDomain;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 
 * @author Lenovo
 * @since 2019-12-31 13:12:26
 */

@ApiModel("图片库")
@Data
public class ImageVo extends BaseDomain {

	private static final long serialVersionUID = 3282052422L;

	public ImageVo() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 100
	private String imagename;

	private String path;
	 
}