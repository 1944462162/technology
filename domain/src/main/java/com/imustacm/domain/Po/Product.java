package com.imustacm.domain.Po;
import com.imustacm.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2019-12-25 10:45:23
 */
public class Product extends BaseDomain {

	private static final long serialVersionUID = 6412285363L;

	public Product() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 100
	private String serial;

	private String amount;

	// max length: 100
	private String details;

	private String detectionInfo;

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
	
	public String getDetails() {
		return this.details;
	}
    public void setDetails(String details) {
		this.details = details;
	}
	
	public String getDetectionInfo() {
		return this.detectionInfo;
	}
    public void setDetectionInfo(String detectionInfo) {
		this.detectionInfo = detectionInfo;
	}
	 
}