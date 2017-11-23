package com.model;

public class OutstockRecord {
	private int stockID;
	private String productCode;
	private String productName;
	private String orderCode;
	private float productPrice;
	
	private int stockNum;
	private int stockType;
	private String stockTime;
	private String createUser;
	public int getStockID() {
		return stockID;
	}
	public void setStockID(int stockID) {
		this.stockID = stockID;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public int getStockNum() {
		return stockNum;
	}
	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}
	public int getStockType() {
		return stockType;
	}
	public void setStockType(int stockType) {
		this.stockType = stockType;
	}
	public String getStockTime() {
		return stockTime;
	}
	public void setStockTime(String stockTime) {
		this.stockTime = stockTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	@Override
	public String toString() {
		return "OutstockRecord [stockID=" + stockID + ", productCode="
				+ productCode + ", productName=" + productName + ", orderCode="
				+ orderCode + ", productPrice=" + productPrice + ", stockNum="
				+ stockNum + ", stockType=" + stockType + ", stockTime="
				+ stockTime + ", createUser=" + createUser + "]";
	}
	
}
