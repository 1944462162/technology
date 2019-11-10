/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.domain.Po;
import com.imustacm.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2019-11-10 20:45:57
 */
public class Users extends BaseDomain {

	private static final long serialVersionUID = 7473531509L;

	public Users() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 80
	private String username;

	private String password;

	// max length: 80
	private String usercode;

	public Integer getId() {
		return this.id;
	}
    public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return this.username;
	}
    public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
    public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsercode() {
		return this.usercode;
	}
    public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	 
}