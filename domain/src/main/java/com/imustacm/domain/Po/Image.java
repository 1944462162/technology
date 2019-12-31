/*
 * Copyright (c) 2019 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imustacm.domain.Po;
import com.imustacm.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2019-12-31 13:12:26
 */
public class Image extends BaseDomain {

	private static final long serialVersionUID = 3282052422L;

	public Image() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 100
	private String imagename;

	private String path;

	public Integer getId() {
		return this.id;
	}
    public void setId(Integer id) {
		this.id = id;
	}
	
	public String getImagename() {
		return this.imagename;
	}
    public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	
	public String getPath() {
		return this.path;
	}
    public void setPath(String path) {
		this.path = path;
	}
	 
}