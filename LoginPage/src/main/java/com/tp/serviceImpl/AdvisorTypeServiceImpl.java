package com.tp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.Entity.AdvisorType;
import com.tp.service.AdvisorTypeService;

@Service
public class AdvisorTypeServiceImpl implements AdvisorTypeService {
	@Autowired
	private AdvisorTypeService advisorTypeService;

	@Override
	public AdvisorType save(AdvisorType advisorType) {
		return advisorTypeService.save(advisorType);
	}
	

}
