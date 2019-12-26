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
@ApiModel("权限")
@Data
public class RolesPermissionVo extends BaseDomain {



	public RolesPermissionVo() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 100
	private String roleName;

	private String permission;

	 
}