package com.imust.domain.Vo;
import com.imust.domain.base.BaseDomain;
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