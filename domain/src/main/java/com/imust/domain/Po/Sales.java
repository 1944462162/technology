package com.imust.domain.Po;
import com.imust.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2020-01-03 13:09:37
 */
public class Sales extends BaseDomain {

	private static final long serialVersionUID = 6464772684L;

	public Sales() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 100
	private String serial;

	private String amount;

	// max length: 100
	private String createDate;

	private String note;

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
	
	public String getAmount() {
		return this.amount;
	}
    public void setAmount(String amount) {
		this.amount = amount;
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