/*
 * Copyright (c) 2020 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imust.domain.Po;
import com.imust.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2020-01-03 13:09:37
 */
public class RolesPermission extends BaseDomain {

	private static final long serialVersionUID = 4119662878L;

	public RolesPermission() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 100
	private String roleName;

	private String permission;

	public Integer getId() {
		return this.id;
	}
    public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return this.roleName;
	}
    public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getPermission() {
		return this.permission;
	}
    public void setPermission(String permission) {
		this.permission = permission;
	}
	 
}