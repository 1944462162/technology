package com.imustacm.domain.Po;
import com.imustacm.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2019-12-25 10:45:24
 */
public class Stock extends BaseDomain {

	private static final long serialVersionUID = 4518665436L;

	public Stock() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 80
	private String stockName;

	private String unit;

	private String weight;

	public Integer getId() {
		return this.id;
	}
    public void setId(Integer id) {
		this.id = id;
	}
	
	public String getStockName() {
		return this.stockName;
	}
    public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	public String getUnit() {
		return this.unit;
	}
    public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getWeight() {
		return this.weight;
	}
    public void setWeight(String weight) {
		this.weight = weight;
	}
	 
}