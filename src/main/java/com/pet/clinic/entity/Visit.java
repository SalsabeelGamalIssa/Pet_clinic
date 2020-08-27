package com.pet.clinic.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import net.minidev.json.annotate.JsonIgnore;


/**
 * The persistent class for the visit database table.
 * 
 */
@Entity
@NamedQuery(name="Visit.findAll", query="SELECT v FROM Visit v")
public class Visit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Column(name="visit_id")
	private int visitId;

	@Temporal(TemporalType.DATE)
	@Column(name="visit_date")
	private Date visitDate;

	//bi-directional many-to-one association to Clinic
	@JsonIgnore
	@JsonBackReference
	@OneToMany(mappedBy="owner")
	@ManyToOne
	@JoinColumn(name="clinic_id")
	private Clinic clinic;

	//bi-directional many-to-one association to Doctor
	@JsonIgnore
	@JsonBackReference
	@OneToMany(mappedBy="owner")
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;

	//bi-directional many-to-one association to Pet
	@JsonIgnore
	@JsonBackReference
	@OneToMany(mappedBy="owner")
	@ManyToOne
	@JoinColumn(name="pet_id")
	private Pet pet;

	public Visit() {
	}

	public int getVisitId() {
		return this.visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Clinic getClinic() {
		return this.clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Pet getPet() {
		return this.pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

}