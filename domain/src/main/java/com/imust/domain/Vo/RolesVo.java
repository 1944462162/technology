package com.imust.domain.Vo;
import com.imust.domain.base.BaseDomain;
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