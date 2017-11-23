package com.model;

public class IdWeightModel {
	private String id;
	private String weight;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public IdWeightModel(String id, String weight, String name) {
		super();
		this.id = id;
		this.weight = weight;
		this.name = name;
	}
	public IdWeightModel() {
		
	}
	
	
}
