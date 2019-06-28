package com.tp.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tp.Entity.EmployeeDetails;
@Transactional
@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails,Long> {
	@Query("select ed from EmployeeDetails ed inner join  AdvisorType at on ed.userId=at.userId and sysdate() between at.startDate and at.endDate inner join HierarchyDetails he on he.userId=ed.userId and sysdate() between he.startDate and he.endDate where ed.userId=:userId and sysdate() between ed.startDate and ed.endDate")
	List<EmployeeDetails> findByuserId(@Param("userId") String userId);
	
	//@Query("select  ed.userId,ed.firstName,ed.lastName,ed.startDate,ed.endDate from EmployeeDetails as ed")
	/*@Query("select   from EmployeeDetails  ed")
	List<EmployeeDetails> findAllRecords();*/
	

}
