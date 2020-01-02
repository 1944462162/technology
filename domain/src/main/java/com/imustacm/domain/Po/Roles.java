package com.imustacm.domain.Po;
import com.imustacm.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2019-12-25 10:45:24
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