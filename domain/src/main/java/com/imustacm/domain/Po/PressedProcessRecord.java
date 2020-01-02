package com.imustacm.domain.Po;
import com.imustacm.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2020-01-02 10:10:07
 */
public class PressedProcessRecord extends BaseDomain {

	private static final long serialVersionUID = 6097849367L;

	public PressedProcessRecord() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 100
	private String serial;

	private String createTime;

	// max length: 1000
	private String pressedInfor;

	public Integer getId() {
		return this.id;
	}
    public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSerial() {
		return this.serial;
	}
    public void setSerial(String serial) {
		this.serial = serial;
	}
	
	public String getCreateTime() {
		return this.createTime;
	}
    public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getPressedInfor() {
		return this.pressedInfor;
	}
    public void setPressedInfor(String pressedInfor) {
		this.pressedInfor = pressedInfor;
	}
	 
}