package com.pet.clinic.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import net.minidev.json.annotate.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the clinic database table.
 * 
 */
@Entity
@NamedQuery(name="Clinic.findAll", query="SELECT c FROM Clinic c")
public class Clinic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Column(name="clinic_id")
	private int clinicId;
	
	 @Size(max = 45)
	@Column(name="clinic_address")
	private String clinicAddress;
	
	 @Size(max = 45)
	@Column(name="clinic_name")
	private String clinicName;
	 
	 @Size(max = 45)
	@Column(name="clinic_phone")
	private String clinicPhone;

	private String clinic_URLs;
	 @Size(max = 45)
	@Column(name="clinic_working_det")
	private String clinicWorkingDet;



	//bi-directional many-to-one association to Doctor
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy="clinic")
	private List<Doctor> doctors;

	//bi-directional many-to-one association to Visit
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy="clinic")
	private List<Visit> visits;

	public Clinic() {
	}

	public int getClinicId() {
		return this.clinicId;
	}

	public void setClinicId(int clinicId) {
		this.clinicId = clinicId;
	}

	public String getClinicAddress() {
		return this.clinicAddress;
	}

	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	public String getClinicName() {
		return this.clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getClinicPhone() {
		return this.clinicPhone;
	}

	public void setClinicPhone(String clinicPhone) {
		this.clinicPhone = clinicPhone;
	}

	public String getClinic_URLs() {
		return this.clinic_URLs;
	}

	public void setClinic_URLs(String clinic_URLs) {
		this.clinic_URLs = clinic_URLs;
	}

	public String getClinicWorkingDet() {
		return this.clinicWorkingDet;
	}

	public void setClinicWorkingDet(String clinicWorkingDet) {
		this.clinicWorkingDet = clinicWorkingDet;
	}

	@JsonIgnore
	@JsonManagedReference
	public List<Doctor> getDoctors() {
		return this.doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Doctor addDoctor(Doctor doctor) {
		getDoctors().add(doctor);
		doctor.setClinic(this);

		return doctor;
	}

	public Doctor removeDoctor(Doctor doctor) {
		getDoctors().remove(doctor);
		doctor.setClinic(null);

		return doctor;
	}
	@JsonIgnore
	@JsonManagedReference
	public List<Visit> getVisits() {
		return this.visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}

	public Visit addVisit(Visit visit) {
		getVisits().add(visit);
		visit.setClinic(this);

		return visit;
	}

	public Visit removeVisit(Visit visit) {
		getVisits().remove(visit);
		visit.setClinic(null);

		return visit;
	}

}