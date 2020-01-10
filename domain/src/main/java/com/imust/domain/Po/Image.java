package com.imust.domain.Po;
import com.imust.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2020-01-03 13:09:36
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