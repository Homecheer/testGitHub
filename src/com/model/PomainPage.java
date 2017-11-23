package com.model;

import java.util.ArrayList;

public class PomainPage {
	private int toTalPage;
	private int nowPage;
	private int pageSize;
	private ArrayList data;
	public int getToTalPage() {
		return toTalPage;
	}
	public void setToTalPage(int toTalPage) {
		this.toTalPage = toTalPage;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public ArrayList getData() {
		return data;
	}
	public void setData(ArrayList data) {
		this.data = data;
	}
	
}
