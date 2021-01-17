package com.code.challenge.enrollee.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(schema = "enrolleesdb", name = "enrollees")
public class Enrollee extends Applicant {
	@ApiModelProperty(notes = "unique ID of enrollee", example = "7aaee0e2-6884-4fd7-ba63-21d76723dce2")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Generated(GenerationTime.ALWAYS)
	@Column(name = "enrolleeid", nullable = true, insertable = false, updatable = false)
	protected UUID id;
	
	@NotNull(message = "activationStatus is mandatory")
	@Column(name = "activated", nullable = false)
	private boolean activationStatus;
	
	@ApiModelProperty(example = "248-250-4517")
	@Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "For phoneNumber, please enter phone number like so \"248-250-4517\" (with hyphens and no other characters)")
	@Column(name = "phonenumber", nullable = true)
	private String phoneNumber;
	
	public Enrollee() {
	}
	public Enrollee(UUID id) {
		this.id = id;
	}
	public Enrollee(UUID id, String name, LocalDate birthDate, boolean activationStatus, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.activationStatus = activationStatus;
		this.phoneNumber = phoneNumber;
	}
	
	//getters
	public UUID getId() {
		return id;
	}
	public boolean isActivationStatus() {
		return activationStatus;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	//setters
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setActivationStatus(boolean activationStatus) {
		this.activationStatus = activationStatus;
	}
}
