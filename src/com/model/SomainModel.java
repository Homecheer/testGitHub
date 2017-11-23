package com.model;

public class SomainModel {
	private String SOID;
	private String CustomerCode;
	private String Account;
	private String CreateTime;
	private float TipFee;
	private float ProductTotal;
	private float SOTotal;
	private String PayType;
	private float PrePayFee;
	private int Status;
	private String Remark;
	private String StockTime;
	private String StockUser;
	private String PayTime;
	private String PayUser;
	private String PrePayTime;
	private String PrePayUser;
	private String EndTime;
	private String EndUser;
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String EndTime) {
		EndTime = EndTime;
	}public String getEndUser() {
		return EndUser;
	}
	public void setEndUser(String EndUser) {
		EndUser = EndUser;
	}
	public String getSOID() {
		return SOID;
	}
	public void setSOID(String sOID) {
		SOID = sOID;
	}
	public String getCustomerCode() {
		return CustomerCode;
	}
	public void setCustomerCode(String customerCode) {
		CustomerCode = customerCode;
	}
	public String getAccount() {
		return Account;
	}
	public void setAccount(String account) {
		Account = account;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public float getTipFee() {
		return TipFee;
	}
	public void setTipFee(float tipFee) {
		TipFee = tipFee;
	}
	public float getProductTotal() {
		return ProductTotal;
	}
	public void setProductTotal(float productTotal) {
		ProductTotal = productTotal;
	}
	public float getSOTotal() {
		return SOTotal;
	}
	public void setSOTotal(float sOTotal) {
		SOTotal = sOTotal;
	}
	public String getPayType() {
		return PayType;
	}
	public void setPayType(String payType) {
		PayType = payType;
	}
	public float getPrePayFee() {
		return PrePayFee;
	}
	public void setPrePayFee(float prePayFee) {
		PrePayFee = prePayFee;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getStockTime() {
		return StockTime;
	}
	public void setStockTime(String stockTime) {
		StockTime = stockTime;
	}
	public String getStockUser() {
		return StockUser;
	}
	public void setStockUser(String stockUser) {
		StockUser = stockUser;
	}
	public String getPayTime() {
		return PayTime;
	}
	public void setPayTime(String payTime) {
		PayTime = payTime;
	}
	public String getPayUser() {
		return PayUser;
	}
	public void setPayUser(String payUser) {
		PayUser = payUser;
	}
	public String getPrePayTime() {
		return PrePayTime;
	}
	public void setPrePayTime(String prePayTime) {
		PrePayTime = prePayTime;
	}
	public String getPrePayUser() {
		return PrePayUser;
	}
	public void setPrePayUser(String prePayUser) {
		PrePayUser = prePayUser;
	}
	public SomainModel(String sOID, String customerCode, String account,
			String createTime, float tipFee, float productTotal, float sOTotal,
			String payType, float prePayFee, int status, String remark,
			String stockTime, String stockUser, String payTime, String payUser,
			String prePayTime, String prePayUser, String endTime, String endUser) {
		super();
		SOID = sOID;
		CustomerCode = customerCode;
		Account = account;
		CreateTime = createTime;
		TipFee = tipFee;
		ProductTotal = productTotal;
		SOTotal = sOTotal;
		PayType = payType;
		PrePayFee = prePayFee;
		Status = status;
		Remark = remark;
		StockTime = stockTime;
		StockUser = stockUser;
		PayTime = payTime;
		PayUser = payUser;
		PrePayTime = prePayTime;
		PrePayUser = prePayUser;
		EndTime = endTime;
		EndUser = endUser;
	}
	public SomainModel() {
		super();
	}
	
	
	
	
	
	
	
}
