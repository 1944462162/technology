package com.imust.domain.Po;
import com.imust.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2020-01-03 13:09:37
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