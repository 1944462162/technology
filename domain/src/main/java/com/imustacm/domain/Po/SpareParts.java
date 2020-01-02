package com.imustacm.domain.Po;
import com.imustacm.domain.base.BaseDomain;

/**
 * 
 * @author Lenovo
 * @since 2019-12-25 10:45:24
 */
public class SpareParts extends BaseDomain {

	private static final long serialVersionUID = 15063070240L;

	public SpareParts() {
		//默认无参构造方法
	}
	private Integer id;

	// max length: 100
	private String composition;

	private String requirementWeight;

	private String ingredientsWeigth;

	// max length: 400
	private String note;

	private String createTime;

	// max length: 100
	private String serial;

	private String ingredientOperator;

	// max length: 100
	private String compositeOperator;

	public Integer getId() {
		return this.id;
	}
    public void setId(Integer id) {
		this.id = id;
	}
	
	public String getComposition() {
		return this.composition;
	}
    public void setComposition(String composition) {
		this.composition = composition;
	}
	
	public String getRequirementWeight() {
		return this.requirementWeight;
	}
    public void setRequirementWeight(String requirementWeight) {
		this.requirementWeight = requirementWeight;
	}
	
	public String getIngredientsWeigth() {
		return this.ingredientsWeigth;
	}
    public void setIngredientsWeigth(String ingredientsWeigth) {
		this.ingredientsWeigth = ingredientsWeigth;
	}
	
	public String getNote() {
		return this.note;
	}
    public void setNote(String note) {
		this.note = note;
	}
	
	public String getCreateTime() {
		return this.createTime;
	}
    public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getSerial() {
		return this.serial;
	}
    public void setSerial(String serial) {
		this.serial = serial;
	}
	
	public String getIngredientOperator() {
		return this.ingredientOperator;
	}
    public void setIngredientOperator(String ingredientOperator) {
		this.ingredientOperator = ingredientOperator;
	}
	
	public String getCompositeOperator() {
		return this.compositeOperator;
	}
    public void setCompositeOperator(String compositeOperator) {
		this.compositeOperator = compositeOperator;
	}
	 
}