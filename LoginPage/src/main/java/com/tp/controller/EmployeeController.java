package com.tp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.Entity.AdvisorType;
import com.tp.Entity.EmployeeDetails;
import com.tp.Entity.HierarchyDetails;
import com.tp.dto.EmployeeDto;
import com.tp.dto.ResponseStatus;
import com.tp.service.EmployeeDetailsService;
import com.tp.util.MailSenderUtil;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDetailsService employeeDetailsService;
	@Autowired
	private MailSenderUtil mailSenderUtil;
	
	@SuppressWarnings("deprecation")
	@PostMapping(value="/add",produces="application/json")
	public ResponseEntity<String> saveEmployee (@RequestBody EmployeeDto dto) throws ParseException{
		
		 SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
         java.util.Date beginDate = new java.util.Date();
         int endYear = beginDate.getYear() + 20;
         java.sql.Date endDate = new java.sql.Date(endYear, 11, 31);
         
         
         EmployeeDetails employeeDetails=new EmployeeDetails();
         employeeDetails.setFirstName(dto.getFirstName());
         employeeDetails.setLastName(dto.getLastName());
         employeeDetails.setUserId(dto.getUserId());
         if(null!=dto.getStartDate()&&!dto.getStartDate().isEmpty()) {
        	 beginDate=sdf.parse(dto.getStartDate());
         }
         employeeDetails.setStartDate(beginDate);
         employeeDetails.setEndDate(endDate);
         
         AdvisorType advisorType=new AdvisorType();
        List< AdvisorType> advisorTypelist=new ArrayList<AdvisorType>();
         advisorType.setAdvisorType(dto.getAdvisorType());
         advisorType.setEmailId(dto.getEmailId());
         if(null!=dto.getStartDate()&&!dto.getStartDate().isEmpty()) {
        	 
        	 beginDate=sdf.parse(dto.getStartDate());
         }
         advisorType.setStartDate(beginDate);
         advisorType.setEndDate(endDate);
         advisorTypelist.add(advisorType);
         employeeDetails.setAdvisorType(advisorTypelist);
         
         //HierarchyDetails hierarchyDetails =new HierarchyDetails();
         List<HierarchyDetails> hiersrchyList=new ArrayList<HierarchyDetails>();
         if(null!=dto.getManager()&&!dto.getManager().isEmpty()) {
        	  HierarchyDetails hierarchyManager =new HierarchyDetails();
        	  hierarchyManager.setSuperId(dto.getManager());
        	  if(null!=dto.getStartDate()&&!dto.getStartDate().isEmpty()) {
        		  beginDate=sdf.parse(dto.getStartDate());
        	  }
        	  hierarchyManager.setStartDate(beginDate);
        	  hierarchyManager.setStartDate(endDate);
        	  hiersrchyList.add(hierarchyManager);
         }
         if(null!=dto.getDirector()&&!dto.getDirector().isEmpty()) {
        	  HierarchyDetails hierarchyDirector =new HierarchyDetails(); 
        	  hierarchyDirector.setSuperId(dto.getDirector());
        	  if(null!=dto.getStartDate()&&dto.getStartDate().isEmpty()) {
        		  beginDate=sdf.parse(dto.getStartDate());  
        	  }
        	  hierarchyDirector.setStartDate(beginDate);
        	  hierarchyDirector.setEndDate(endDate);
        	  hiersrchyList.add(hierarchyDirector);
         }
         if(null!=dto.getTL()&&!dto.getTL().isEmpty()) {
        	 HierarchyDetails hierarchyTL =new HierarchyDetails();  
        	 hierarchyTL.setSuperId(dto.getTL());
        	 if(null!=dto.getStartDate()&&!dto.getStartDate().isEmpty()) {
        		 beginDate=sdf.parse(dto.getStartDate());  
        		 
        	 }
        	 hierarchyTL.setStartDate(beginDate);
        	 hierarchyTL.setEndDate(endDate);
        	 hiersrchyList.add(hierarchyTL);
        	 
         }
         if(null!=dto.getTL()&&!dto.getTL().isEmpty()) {
        	 HierarchyDetails hierarchyVP =new HierarchyDetails();  
        	 hierarchyVP.setSuperId(dto.getVP());
        	 if(null!=dto.getStartDate()&&!dto.getStartDate().isEmpty()) {
        		 beginDate=sdf.parse(dto.getStartDate());  
        		 
        	 }
        	 hierarchyVP.setStartDate(beginDate);
        	 hierarchyVP.setEndDate(endDate);
        	 hiersrchyList.add(hierarchyVP);
         }
         if(null!=dto.getTL()&&!dto.getTL().isEmpty()) {
        	 HierarchyDetails hierarchyGM =new HierarchyDetails();  
        	 hierarchyGM.setSuperId(dto.getGenaralmanager());
        	 if(null!=dto.getStartDate()&&!dto.getStartDate().isEmpty()) {
        		 beginDate=sdf.parse(dto.getStartDate());  
        		 
        	 }
        	 hierarchyGM.setStartDate(beginDate);
        	 hierarchyGM.setEndDate(endDate);
        	 hiersrchyList.add(hierarchyGM);
         }
         employeeDetails.setHierarchyDetails(hiersrchyList);
         
         employeeDetailsService.save(employeeDetails);
         mailSenderUtil.sendConfirmationEmail( employeeDetails);
		return new ResponseEntity<String>("Data Added",HttpStatus.OK);
	
	}
		
		/*EmployeeDetails employeeDetails =new EmployeeDetails();
		employeeDetails.setUserId(dto.getUserId());
		employeeDetails.setFirstName(dto.getFirstName());
		employeeDetails.setLastName(dto.getLastName());
		employeeDetails.setEndDate("2030-05-25");
		employeeDetails.setStartDate("2019-05-11");
		AdvisorType advisorType=new AdvisorType();
		ArrayList<AdvisorType> advisorList=new ArrayList<AdvisorType>();
		advisorType.setAdvisorType(dto.getAdvisorType());
		advisorType.setStartDate("2019-05-11");
		advisorType.setEndDate("2030-05-20");
		advisorList.add(advisorType);
		employeeDetails.setAdvisorType(advisorList);
		
		List<HierarchyDetails> hierarchyList=new ArrayList<>();
		
		HierarchyDetails hierarchyDetails=new HierarchyDetails();
		List managerList=new ArrayList();
		if(null!=dto.getManager()&& !dto.getManager().isEmpty()) {
			
		hierarchyDetails.setSuperId(dto.getManager());
		hierarchyDetails.setStartDate("2019-05-18");
		hierarchyDetails.setEndDate("2030-05-20");
		managerList.add(hierarchyDetails);
		employeeDetails.setHierarchyDetails(hierarchyList);
		}
		List vpList=new ArrayList();
		if(null!=dto.getVP()&&dto.getVP().isEmpty()) {
			hierarchyDetails.setSuperId(dto.getVP());
			hierarchyDetails.setStartDate("2019-05-18");
			hierarchyDetails.setEndDate("2030-05-19");
			employeeDetails.setHierarchyDetails(hierarchyDetails);
		}
		
		
		employeeDetailsService.save(employeeDetails);*/
		
	@PutMapping(value="/update", produces="application/json")
	public  ResponseStatus updateEmpData(@RequestBody  EmployeeDetails emp) {
		
		return  employeeDetailsService.updateProfileData(emp);
		
	}
	@GetMapping(value="/user_list", produces="application/json")
	public ResponseEntity<String> findByUserList(@RequestParam("userId")String userId) {
		List<EmployeeDetails>userList=employeeDetailsService.findByUserId(userId);
	
		List<Map<String,Object>> alldoc=new ArrayList<>();
		
		userList.parallelStream().filter(f->f!=null).forEach(obj->{
			
			Map<String, Object> doc=new HashMap<>();
			
			doc.put("lastName", obj.getLastName());
			doc.put("firstName", obj.getFirstName());
			
			List<Map<String,Object>> advList=new ArrayList<>();
			
			obj.getAdvisorType().parallelStream().filter(f1->f1!=null )
			.forEach(adv->{
				
				Map<String, Object> addata=new HashMap<>();
				addata.put("advisorType", adv.getAdvisorType());
				advList.add(addata);
				
			});
			
			doc.put("advisorTypeDetails", advList);
			
			alldoc.add(doc);
		});
		
		try {
			
			
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(alldoc),null,HttpStatus.CREATED);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
			
			return new ResponseEntity<String>(e.getOriginalMessage(),null,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

	}
	@GetMapping(value="/user",produces="application/json")
	public ResponseEntity<String> findById(@RequestParam("userId")String userId) throws JsonProcessingException
	{
		List<EmployeeDetails> useList=employeeDetailsService.findByUserId(userId);
		List<Map<String, Object>> emplist=new ArrayList<>();
		useList.parallelStream().filter(emp->emp!=null).forEach(empdetails->{
			Map<String,Object> addemp=new HashMap<>();
			addemp.put("firstName", empdetails.getFirstName());
			addemp.put("lastName", empdetails.getLastName());
			
			List<Map<String,Object>> advisorlist=new ArrayList<>();
			
			empdetails.getAdvisorType().parallelStream().filter(advisor->advisor!=null).forEach(advisor->{
			Map<String,Object> addAdvisor=new HashMap<>();
			addAdvisor.put("advisorTyp", advisor.getAdvisorType());
			addAdvisor.put("userId", advisor.getUserId());
			advisorlist.add(addAdvisor);
			});
			List<Map<String,Object>> hierechydata=new ArrayList<>();
			empdetails.getHierarchyDetails().parallelStream().filter(hierarchy->hierarchy!=null).forEach(hierarchydetails->{
				Map<String,Object> hierarchyAdd=new HashMap<>();
				hierarchyAdd.put("SuperId",hierarchydetails.getSuperId() );
				hierarchyAdd.put("userId",hierarchydetails.getUserId());
				hierechydata.add(hierarchyAdd);
				
			});
			addemp.put("advisorDetails", advisorlist);
			addemp.put("hierechy", hierechydata);
			
			emplist.add(addemp);
		
		});
		return new ResponseEntity<>(new ObjectMapper().writeValueAsString(emplist),null,HttpStatus.OK);
	
	}
	
	}

