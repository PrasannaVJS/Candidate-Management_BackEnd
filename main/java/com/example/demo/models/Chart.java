package com.example.demo.models;



public class Chart {
	private String loc;
	private Integer count;
	
	public Chart() {
		
	}
	
	public Chart(String loc, Integer count) {
		super();
		this.loc = loc;
		this.count = count;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	

}
