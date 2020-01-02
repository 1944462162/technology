package com.imustacm.domain.Po;
import com.imustacm.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2019-12-25 10:45:24
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