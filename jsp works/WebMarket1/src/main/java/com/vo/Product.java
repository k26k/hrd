package com.vo;

import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String productId;	
	private String pName;
	private Integer unitPrice;
	private String description;
	private String menufacturer;
	private Long unitsInStock;
	private String condition;
	private String filename;
	
	public Product() {}

	public Product(String productId, String pName, Integer unitPrice) {
		this.productId = productId;
		this.pName = pName;
		this.unitPrice = unitPrice;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMenufacturer() {
		return menufacturer;
	}
	public void setMenufacturer(String menufacturer) {
		this.menufacturer = menufacturer;
	}
	public Long getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(Long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
