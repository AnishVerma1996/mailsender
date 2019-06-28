package com.tp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.Entity.HierarchyDetails;
import com.tp.repository.HierarchyDetailsRepository;
import com.tp.service.HierarchyDetailsService;

@Service
public class HierarchyDetailsServiceImpl implements HierarchyDetailsService {
@Autowired
private HierarchyDetailsRepository  hierarchyDetailsRepository;
	@Override
	public HierarchyDetails save(HierarchyDetails hierarchyDetails) {
		return hierarchyDetailsRepository.save(hierarchyDetails);
	}

}
