package com.imust.domain.Po;
import com.imust.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2020-01-03 13:09:37
 */
public class SmeltingRecord extends BaseDomain {

	private static final long serialVersionUID = 16080274113L;

	public SmeltingRecord() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 100
	private String serial;

	private String createTime;

	// max length: 100
	private String operator;

	private String feedWeight;

	private String midWeight;

	private Integer crucibleCount;

	// max length: 400
	private String note;

	private String smeltingDetails;

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
	
	public String getOperator() {
		return this.operator;
	}
    public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getFeedWeight() {
		return this.feedWeight;
	}
    public void setFeedWeight(String feedWeight) {
		this.feedWeight = feedWeight;
	}
	
	public String getMidWeight() {
		return this.midWeight;
	}
    public void setMidWeight(String midWeight) {
		this.midWeight = midWeight;
	}
	
	public Integer getCrucibleCount() {
		return this.crucibleCount;
	}
    public void setCrucibleCount(Integer crucibleCount) {
		this.crucibleCount = crucibleCount;
	}
	
	public String getNote() {
		return this.note;
	}
    public void setNote(String note) {
		this.note = note;
	}
	
	public String getSmeltingDetails() {
		return this.smeltingDetails;
	}
    public void setSmeltingDetails(String smeltingDetails) {
		this.smeltingDetails = smeltingDetails;
	}
	 
}