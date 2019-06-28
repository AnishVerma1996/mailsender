package com.tp.service;

import java.util.List;

import com.tp.Entity.EmployeeDetails;
import com.tp.dto.ResponseStatus;



public interface EmployeeDetailsService {
	EmployeeDetails save (EmployeeDetails employeeDetails);
     
 List<EmployeeDetails> findByUserId(String userId);
	//List<EmployeeDetails> findAllData(EmployeeDetails employeeDetails );
 ResponseStatus updateProfileData(EmployeeDetails emp);
	//ResponseStatus updateProfileData(Profile profile);
}
