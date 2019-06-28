package com.tp.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

@Entity
@Table(name="IDMC_Employee_Details")
public class EmployeeDetails extends SerializableSerializer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	@Column(name="User_Id")
	private String userId;
	@Column(name="First_Name")
	private String firstName;
	@Column(name="Last_Name")
	private String lastName;
	
	@Column(name="Start_Date")
	private Date  startDate;
	@Column(name="End_Date")
	private Date  endDate;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "User_Id",referencedColumnName="User_Id")
	private List<HierarchyDetails>hierarchyDetails;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "User_Id",referencedColumnName="User_Id")
	private List<AdvisorType>advisorType;
	
	
	
	public List<HierarchyDetails> getHierarchyDetails() {
		return hierarchyDetails;
	}
	public void setHierarchyDetails(List<HierarchyDetails> hierarchyDetails) {
		this.hierarchyDetails = hierarchyDetails;
	}
	public List<AdvisorType> getAdvisorType() {
		return advisorType;
	}
	public void setAdvisorType(List<AdvisorType> advisorType) {
		this.advisorType = advisorType;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	
}
