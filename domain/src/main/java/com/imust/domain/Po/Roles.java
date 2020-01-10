package com.imust.domain.Po;
import com.imust.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2020-01-03 13:09:37
 */
public class Roles extends BaseDomain {

	private static final long serialVersionUID = 1353598711L;

	public Roles() {
		//默认无参构造方法
	}
	// max length: 80
	private String userCode;

	private String roleName;

	public String getUserCode() {
		return this.userCode;
	}
    public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	public String getRoleName() {
		return this.roleName;
	}
    public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	 
}