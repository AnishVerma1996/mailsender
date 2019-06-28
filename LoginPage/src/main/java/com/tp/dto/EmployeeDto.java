package com.tp.dto;

public class EmployeeDto {
	
	private String userId;
	private String firstName;
	private String lastName;
	private String advisorType;
	private String  startDate;
	private String  endDate;
	private String emailId;

	private String manager;
	private String genaralmanager;
	private String VP;
	private String director;
	private String TL;
	
	
		
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getGenaralmanager() {
		return genaralmanager;
	}
	public void setGenaralmanager(String genaralmanager) {
		this.genaralmanager = genaralmanager;
	}
	public String getVP() {
		return VP;
	}
	public void setVP(String vP) {
		VP = vP;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getTL() {
		return TL;
	}
	public void setTL(String tL) {
		TL = tL;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAdvisorType() {
		return advisorType;
	}
	public void setAdvisorType(String advisorType) {
		this.advisorType = advisorType;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
