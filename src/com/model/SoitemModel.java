package com.model;

public class SoitemModel {
	private String SOID;
	private String ProductCode;
	private float UnitPrice;
	private int Num;
	private String UnitName;
	private float ItemPrice;
	public String getSOID() {
		return SOID;
	}
	public void setSOID(String sOID) {
		SOID = sOID;
	}
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	public float getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		UnitPrice = unitPrice;
	}
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public String getUnitName() {
		return UnitName;
	}
	public void setUnitName(String unitName) {
		UnitName = unitName;
	}
	public float getItemPrice() {
		return ItemPrice;
	}
	public void setItemPrice(float itemPrice) {
		ItemPrice = itemPrice;
	}
	public SoitemModel(String sOID, String productCode, float unitPrice,
			int num, String unitName, float itemPrice) {
		super();
		SOID = sOID;
		ProductCode = productCode;
		UnitPrice = unitPrice;
		Num = num;
		UnitName = unitName;
		ItemPrice = itemPrice;
	}
	public SoitemModel() {
		super();
	}
	
	
	
}
