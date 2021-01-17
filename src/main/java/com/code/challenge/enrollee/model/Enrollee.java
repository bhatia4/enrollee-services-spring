package com.code.challenge.enrollee.model;

import java.time.LocalDate;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;

public class Enrollee extends Applicant {
	@NotNull(message = "activationStatus is mandatory")
	private boolean activationStatus;
	
	@ApiModelProperty(example = "248-250-4517")
	@Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "For phoneNumber, please enter phone number like so \"248-250-4517\" (with hyphens and no other characters)")
	private String phoneNumber;
	
//	@ApiModelProperty(notes = "Enrollees may have zero or more dependents") 
//	@Valid
//	private Set<Dependent> dependents;
	
	public Enrollee(UUID id) {
		this.id = id;
	}
	public Enrollee(UUID id, String name, LocalDate birthDate, boolean activationStatus) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.activationStatus = activationStatus;
	}
	
	//getters
	public boolean isActivationStatus() {
		return activationStatus;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
//	public Set<Dependent> getDependents() {
//		return dependents;
//	}

	//setters
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
