package com.model;

import java.util.ArrayList;

public class CategoryPage {
	private int nowPage;
	private int totalPage;
	private int pageSize;
	ArrayList<Category> dataAl;
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public ArrayList<Category> getDataAl() {
		return dataAl;
	}
	public void setDataAl(ArrayList<Category> dataAl) {
		this.dataAl = dataAl;
	}
}
