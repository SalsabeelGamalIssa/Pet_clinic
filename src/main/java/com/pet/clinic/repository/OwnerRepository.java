package com.pet.clinic.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pet.clinic.entity.Owner;

public interface OwnerRepository extends  CrudRepository<Owner, Integer>, JpaSpecificationExecutor<Owner> {

	
	
	
	
}