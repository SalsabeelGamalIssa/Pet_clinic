package com.pet.clinic.repository;

import com.pet.clinic.entity.Pet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface PetRepository extends JpaRepository<Pet, Integer>, JpaSpecificationExecutor<Pet> {

	
	   
    
	
	
	
	@Query("FROM Pet  WHERE owner_id = :id ")
	List<Pet>findOwnerPetsByID(@Param("id") int id);
	
	
}