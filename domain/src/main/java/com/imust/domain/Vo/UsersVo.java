package com.imust.domain.Vo;
import com.imust.domain.base.BaseDomain;
import lombok.Data;

/**
 * 
 * @author Lenovo
 * @since 2019-12-23 17:41:03
 */

@Data
public class UsersVo extends BaseDomain {



	public UsersVo() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 80
	private String username;

	private String password;

	// max length: 80
	private String usercode;

	 
}