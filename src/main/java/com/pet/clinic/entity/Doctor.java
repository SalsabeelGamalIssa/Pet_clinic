package com.pet.clinic.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import net.minidev.json.annotate.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the doctor database table.
 * 
 */
@Entity
@NamedQuery(name="Doctor.findAll", query="SELECT d FROM Doctor d")
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Column(name="doctor_id")
	private int doctorId;
	
	 @Size(max = 45)
	@Column(name="doctor_bio")
	private String doctorBio;

	 @Size(max = 45)
	@Column(name="doctor_name")
	private String doctorName;

	 @Size(max = 45)
	@Column(name="doctor_phone")
	private String doctorPhone;

	 @Size(max = 45)
	@Column(name="doctor_photo")
	private String doctorPhoto;

	//bi-directional many-to-one association to Clinic
	@JsonIgnore
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="clinic_id")
	private Clinic clinic;

	//bi-directional many-to-one association to Visit
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy="doctor")
	private List<Visit> visits;

	public Doctor() {
	}

	public int getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorBio() {
		return this.doctorBio;
	}

	public void setDoctorBio(String doctorBio) {
		this.doctorBio = doctorBio;
	}

	public String getDoctorName() {
		return this.doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorPhone() {
		return this.doctorPhone;
	}

	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}

	public String getDoctorPhoto() {
		return this.doctorPhoto;
	}

	public void setDoctorPhoto(String doctorPhoto) {
		this.doctorPhoto = doctorPhoto;
	}
	@JsonBackReference
	public Clinic getClinic() {
		return this.clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
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
		visit.setDoctor(this);

		return visit;
	}

	public Visit removeVisit(Visit visit) {
		getVisits().remove(visit);
		visit.setDoctor(null);

		return visit;
	}

}