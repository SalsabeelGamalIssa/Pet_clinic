package com.pet.clinic.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import net.minidev.json.annotate.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pet database table.
 * 
 */
@Entity
@NamedQuery(name="Pet.findAll", query="SELECT p FROM Pet p")
public class Pet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Column(name="pet_id")
	private int petId;

	private String gender;

	@Temporal(TemporalType.DATE)
	@Column(name="pet_birth_date")
	private Date petBirthDate;

	@Column(name="pet_kind")
	private String petKind;

	@Column(name="pet_name")
	private String petName;

	@Column(name="pet_photo")
	private String petPhoto;

	@Column(name="pet_weight")
	private int petWeight;

	//bi-directional many-to-one association to Owner
	@JsonIgnore
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;

	//bi-directional many-to-one association to Visit
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy="pet")
	private List<Visit> visits;

	public Pet() {
	}

	public int getPetId() {
		return this.petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getPetBirthDate() {
		return this.petBirthDate;
	}

	public void setPetBirthDate(Date petBirthDate) {
		this.petBirthDate = petBirthDate;
	}

	public String getPetKind() {
		return this.petKind;
	}

	public void setPetKind(String petKind) {
		this.petKind = petKind;
	}

	public String getPetName() {
		return this.petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetPhoto() {
		return this.petPhoto;
	}

	public void setPetPhoto(String petPhoto) {
		this.petPhoto = petPhoto;
	}

	public int getPetWeight() {
		return this.petWeight;
	}

	public void setPetWeight(int petWeight) {
		this.petWeight = petWeight;
	}

	@JsonIgnore
	@JsonBackReference
	public Owner getOwner() {
		return this.owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
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
		visit.setPet(this);

		return visit;
	}

	public Visit removeVisit(Visit visit) {
		getVisits().remove(visit);
		visit.setPet(null);

		return visit;
	}

}