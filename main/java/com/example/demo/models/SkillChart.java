package com.example.demo.models;


public class SkillChart {
private String sname;
private int gradcount;



public SkillChart() {
	
}
public SkillChart(String sname, int gradcount) {
	super();
	this.sname = sname;
	this.gradcount = gradcount;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public int getGradcount() {
	return gradcount;
}
public void setGradcount(int gradcount) {
	this.gradcount = gradcount;
}



}
