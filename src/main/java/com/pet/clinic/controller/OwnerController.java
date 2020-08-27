package com.pet.clinic.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.clinic.entity.Owner;
import com.pet.clinic.entity.Pet;
import com.pet.clinic.repository.OwnerRepository;


@RestController
@RequestMapping("/owners")
public class OwnerController  {
	@Autowired
	OwnerRepository ownerRepository;
	Owner owner;
	
	
	//List all owner’s pets by owner id.
	@GetMapping(value="/pets/{id}")
	public List<Pet> findPetsByID(@PathVariable Integer id)
	{
		System.out.println(id);
	 owner= ownerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	 
		 			System.out.println("=======>"+ owner.getOwnerName());
		 			
	        return  owner.getPets();
	       
		
		
	}

	@GetMapping(value="/all")
	public List<Owner> findPetsByID()
	{
	//	System.out.println(id);
	 
	        return  (List<Owner>) ownerRepository.findAll();
	       
		
		
	}
	
	
}
