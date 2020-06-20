package com.example.demo.models;

public class DesignationChart {
String pos;
int poscount;


public DesignationChart() {
	
}
public DesignationChart(String pos, int poscount) {
	super();
	this.pos = pos;
	this.poscount = poscount;
}
public String getPos() {
	return pos;
}
public void setPos(String pos) {
	this.pos = pos;
}
public int getPoscount() {
	return poscount;
}
public void setPoscount(int poscount) {
	this.poscount = poscount;
}

}
