package com.tp.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IDMC_ADVISOR")
public class AdvisorType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(name="User_ID")
    private String userId;
	@Column(name="Advisor_Type")
	private String advisorType;
	@Column(name="Start_Date")
	private Date startDate;
	@Column(name="End_Date")
	private Date endDate;
	@Column(name="Email_ID")
	private String emailId;
	
	
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAdvisorType() {
		return advisorType;
	}
	public void setAdvisorType(String advisorType) {
		this.advisorType = advisorType;
	}
	
}
