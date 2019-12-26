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
 * @since 2019-12-23 17:41:03
 */
@ApiModel("角色")
@Data
public class RolesVo extends BaseDomain {


	public RolesVo() {
		//默认无参构造方法
	}
	// max length: 80
	private String userCode;

	private String roleName;

	 
}