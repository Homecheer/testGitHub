package com.model;

public class ProductModel {
	private String ProductCode;
	private int categoryID;
	private String Name; 
	private String UnitName;
	private float Price;
	private String CreateDate;
	private String Remark;
	private int PONum;
	private int SONum;
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getUnitName() {
		return UnitName;
	}
	public void setUnitName(String unitName) {
		UnitName = unitName;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public String getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(String createDate) {
		CreateDate = createDate;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public int getPONum() {
		return PONum;
	}
	public void setPONum(int pONum) {
		PONum = pONum;
	}
	public int getSONum() {
		return SONum;
	}
	public void setSONum(int sONum) {
		SONum = sONum;
	}
	public ProductModel(String productCode, int categoryID, String name,
			String unitName, float price, String createDate, String remark,
			int pONum, int sONum) {
		super();
		ProductCode = productCode;
		this.categoryID = categoryID;
		Name = name;
		UnitName = unitName;
		Price = price;
		CreateDate = createDate;
		Remark = remark;
		PONum = pONum;
		SONum = sONum;
	}
	public ProductModel() {
		super();
	}
	
}
