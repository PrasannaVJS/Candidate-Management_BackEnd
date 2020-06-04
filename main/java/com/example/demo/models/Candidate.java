package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Candidate {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstname;
	private String lastname;
	private String emailID;
	private String location;
	private String feedback;
	private String jobdescrip;
	private int contactno;
	private boolean cpp;
	private boolean java;
	private boolean python;
	private boolean angular;
	private boolean spring;
	public Candidate() {
		
	}
	public Candidate(int id, String firstname, String lastname, String emailID, String location, String feedback,
			String jobdescrip, int contactno, boolean cpp, boolean java, boolean python, boolean angular,
			boolean spring) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailID = emailID;
		this.location = location;
		this.feedback = feedback;
		this.jobdescrip = jobdescrip;
		this.contactno = contactno;
		this.cpp = cpp;
		this.java = java;
		this.python = python;
		this.angular = angular;
		this.spring = spring;
	}
	public Candidate(String firstname, String lastname, String emailID, String location, String feedback,
			String jobdescrip, int contactno, boolean cpp, boolean java, boolean python, boolean angular,
			boolean spring) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailID = emailID;
		this.location = location;
		this.feedback = feedback;
		this.jobdescrip = jobdescrip;
		this.contactno = contactno;
		this.cpp = cpp;
		this.java = java;
		this.python = python;
		this.angular = angular;
		this.spring = spring;
	}
	public int getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getJobdescrip() {
		return jobdescrip;
	}
	public void setJobdescrip(String jobdescrip) {
		this.jobdescrip = jobdescrip;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	public boolean isCpp() {
		return cpp;
	}
	public void setCpp(boolean cpp) {
		this.cpp = cpp;
	}
	public boolean isJava() {
		return java;
	}
	public void setJava(boolean java) {
		this.java = java;
	}
	public boolean isPython() {
		return python;
	}
	public void setPython(boolean python) {
		this.python = python;
	}
	public boolean isAngular() {
		return angular;
	}
	public void setAngular(boolean angular) {
		this.angular = angular;
	}
	public boolean isSpring() {
		return spring;
	}
	public void setSpring(boolean spring) {
		this.spring = spring;
	}
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", emailID=" + emailID
				+ ", location=" + location + ", feedback=" + feedback + ", jobdescrip=" + jobdescrip + ", contactno="
				+ contactno + ", cpp=" + cpp + ", java=" + java + ", python=" + python + ", angular=" + angular
				+ ", spring=" + spring + "]";
	}
	
	
	

}
