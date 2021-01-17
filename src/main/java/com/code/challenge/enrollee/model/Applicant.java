package com.code.challenge.enrollee.model;

import java.time.LocalDate;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModelProperty;

public abstract class Applicant {
	@ApiModelProperty(notes = "unique ID of enrollee", example = "7aaee0e2-6884-4fd7-ba63-21d76723dce2")
	protected UUID id;
	
	@ApiModelProperty(notes = "enrollee full name", example = "John Smith", required = true)
	@NotBlank(message = "name is mandatory")
	protected String name;
	
	@ApiModelProperty(notes = "date format is YYYY-MM-DD where YYYY is 4 digit year, MM is 2 digit month number (02 or 12) & DD is 2 digit day", example = "2020-09-10", required = true) 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "birthDate is mandatory")
	protected LocalDate birthDate;

	//getters
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
}
