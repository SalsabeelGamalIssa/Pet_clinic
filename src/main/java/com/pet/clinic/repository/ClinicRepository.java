package com.pet.clinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.pet.clinic.entity.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Integer>, JpaSpecificationExecutor<Clinic> {

	
	

	
	@Query(value ="select * from Clinic c where c.clinic_address  = ?1" ,nativeQuery = true)
	List<Clinic> findClinicByAddress(@PathVariable String clinicAdress);
	
	
	@Query(value ="select * from Clinic c where c.clinic_address  = ?1 or c.clinic_phone = ?2" ,nativeQuery = true)
	List<Clinic> findClinicByPhoneORAddress(@PathVariable String clinicAdress,@PathVariable String clinicPhone);
	
	
	
}