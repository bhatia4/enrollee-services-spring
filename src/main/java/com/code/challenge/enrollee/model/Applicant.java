package com.code.challenge.enrollee.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;

@MappedSuperclass
public abstract class Applicant {
	@ApiModelProperty(notes = "enrollee full name", example = "John Smith", required = true)
	@NotBlank(message = "name is mandatory")
	@Column(nullable = false)
	protected String name;
	
	@ApiModelProperty(notes = "date format is YYYY-MM-DD where YYYY is 4 digit year, MM is 2 digit month number (02 or 12) & DD is 2 digit day", example = "2020-09-10", required = true) 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "birthDate is mandatory")
	@Column(name = "birthdate", nullable = false)
	protected LocalDate birthDate;

	//getters
	public String getName() {
		return name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}	
}
