package com.tp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.Entity.EmployeeDetails;
import com.tp.dto.ResponseStatus;
import com.tp.repository.EmployeeDetailsRepository;
import com.tp.service.EmployeeDetailsService;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
@Autowired
private EmployeeDetailsRepository  employeeDetailsRepository; 
	@Override
	public EmployeeDetails save(EmployeeDetails employeeDetails) {
		
		return employeeDetailsRepository.save(employeeDetails);
	}
	
	@Override
		public List<EmployeeDetails> findByUserId(String userId) {
			// TODO Auto-generated method stub
		return employeeDetailsRepository.findByuserId(userId);
		}
	/*public List<EmployeeDetails> findAllData(EmployeeDetails employeeDetails ){
		System.out.println("==========");
		
		
		 
			System.out.println("=========="+ employeeDetailsRepository.findAllRecords());
			
			
			
			System.out.println("***********************8");
		
		return null;
		
	}*/

	@Override
	public ResponseStatus updateProfileData(EmployeeDetails emp) {
		employeeDetailsRepository.save(emp);
		return  new ResponseStatus(201,"record update successfully");
			
			
	}

}
