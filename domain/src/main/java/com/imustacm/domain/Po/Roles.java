/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.domain.Po;
import com.imustacm.domain.base.BaseDomain;


/**
 * 
 * @author Lenovo
 * @since 2019-09-28 20:19:30
 */
public class Roles extends BaseDomain {

	private static final long serialVersionUID = 1353913237L;

	public Roles() {
		//默认无参构造方法
	}
	// max length: 80
	private String userName;

	private String roleName;

	public String getUserName() {
		return this.userName;
	}
    public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getRoleName() {
		return this.roleName;
	}
    public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	 
}