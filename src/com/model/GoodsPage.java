package com.model;

import java.util.ArrayList;

import com.model.SomainModel;

public class GoodsPage {
	//当前页码
	private int nowPage;
	//每页显示条数
	private int pageSize;
	//总页数
	private int totalPage;
	//当前页数据
	ArrayList<SomainModel> data;
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
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public ArrayList<SomainModel> getData() {
		return data;
	}
	public void setData(ArrayList<SomainModel> data) {
		this.data = data;
	}
}
