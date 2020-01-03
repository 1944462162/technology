/*
 * Copyright (c) 2020 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都研究院所有
 */
package com.imust.domain.Po;
import com.imust.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2020-01-03 13:09:37
 */
public class Storage extends BaseDomain {

	private static final long serialVersionUID = 4639839445L;

	public Storage() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 80
	private String name;

	private String numbers;

	// max length: 100
	private String createDate;

	private String note;

	public Integer getId() {
		return this.id;
	}
    public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
    public void setName(String name) {
		this.name = name;
	}
	
	public String getNumbers() {
		return this.numbers;
	}
    public void setNumbers(String numbers) {
		this.numbers = numbers;
	}
	
	public String getCreateDate() {
		return this.createDate;
	}
    public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public String getNote() {
		return this.note;
	}
    public void setNote(String note) {
		this.note = note;
	}
	 
}