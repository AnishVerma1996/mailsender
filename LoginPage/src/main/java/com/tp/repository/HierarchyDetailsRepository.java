package com.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.Entity.HierarchyDetails;
@Repository
public interface HierarchyDetailsRepository extends JpaRepository<HierarchyDetails, Integer> {

}
