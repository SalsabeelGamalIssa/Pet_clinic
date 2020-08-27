package com.pet.clinic.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.clinic.entity.Clinic;
import com.pet.clinic.entity.Doctor;
import com.pet.clinic.repository.ClinicRepository;
import com.pet.clinic.repository.DoctorRepository;

@RestController
@RequestMapping("/clinics")
public class ClinicController {
	
	@Autowired
	ClinicRepository clinicRepo;
	
	//List all clinic’s doctors by clinic id. 
	
	@GetMapping(value="/doctors/{id}")
	public List<Doctor> findDoctorsByID(@PathVariable Integer id)
	{
		System.out.println(id);
	Clinic clinic= clinicRepo.findById(id).orElseThrow(() -> new EntityNotFoundException());
	 
		 			System.out.println("=======>"+ clinic.getClinicName());
		 			
	        return  clinic.getDoctors();
	       
		
		
	}
	
	
	//Search for clinics by address
	
	@GetMapping(value="/byaddress/{address}")
	public List<Clinic> findByAddress(@PathVariable String  address)
	{

		 			
	        return  clinicRepo.findClinicByAddress(address);
	       
		
	
	}
	
	@Autowired
	DoctorRepository dr;
	
	
	//method to assign a doctor to a clinic
	
@GetMapping(value="/assigndoctor/{doctorid}/{clinicid}")
public void assignDoctor(@PathVariable int doctorid,@PathVariable int clinicid)
{
	System.out.println(doctorid);
	
	 System.out.println("Test !!!!");
  Doctor tempDR=dr.findById(doctorid).orElseThrow(() -> new EntityNotFoundException());
  Clinic clinic=clinicRepo.findById(clinicid).orElseThrow(() -> new EntityNotFoundException());
  clinic.addDoctor(tempDR);
  clinicRepo.flush();
  System.out.println("Done !!!!");
}


//method to Deassign a doctor to a clinic


@GetMapping(value="/Deassigndoctor/{doctorid}/{clinicid}")
public void DeassignDoctor(@PathVariable int doctorid,@PathVariable int clinicid)
{
	System.out.println(doctorid);
	
	 System.out.println("Test !!!!");
  Doctor tempDR=dr.findById(doctorid).orElseThrow(() -> new EntityNotFoundException());
  Clinic clinic=clinicRepo.findById(clinicid).orElseThrow(() -> new EntityNotFoundException());
  clinic.removeDoctor(tempDR);
  clinicRepo.flush();
  System.out.println("Done !!!!");
}

}
