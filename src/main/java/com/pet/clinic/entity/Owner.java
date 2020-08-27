package com.pet.clinic.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import net.minidev.json.annotate.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the owner database table.
 * 
 */
@Entity
@NamedQuery(name="Owner.findAll", query="SELECT o FROM Owner o")
public class Owner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Column(name="owner_id")
	private int ownerId;

	@Size(max = 45)
	@Column(name="owner_address")
	private String ownerAddress;
	
	@Size(max = 45)
	@Column(name="owner_email")
	private String ownerEmail;

	@Size(max = 1)
	@Column(name="owner_gender")
	private String ownerGender;

	@Size(max = 45)
	@Column(name="owner_name")
	private String ownerName;

	@Size(max = 45)
	@Column(name="owner_photo")
	private String ownerPhoto;

	//bi-directional many-to-one association to Pet
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy="owner")
	private List<Pet> pets;

	public Owner() {
	}

	public int getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerAddress() {
		return this.ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public String getOwnerEmail() {
		return this.ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getOwnerGender() {
		return this.ownerGender;
	}

	public void setOwnerGender(String ownerGender) {
		this.ownerGender = ownerGender;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerPhoto() {
		return this.ownerPhoto;
	}

	public void setOwnerPhoto(String ownerPhoto) {
		this.ownerPhoto = ownerPhoto;
	}

	@JsonIgnore
	@JsonManagedReference
	public List<Pet> getPets() {
		return this.pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public Pet addPet(Pet pet) {
		getPets().add(pet);
		pet.setOwner(this);

		return pet;
	}

	public Pet removePet(Pet pet) {
		getPets().remove(pet);
		pet.setOwner(null);

		return pet;
	}

}