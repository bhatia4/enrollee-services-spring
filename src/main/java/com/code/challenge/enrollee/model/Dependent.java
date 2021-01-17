package com.code.challenge.enrollee.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(schema = "enrolleesdb", name = "dependents")
public class Dependent extends Applicant {
	@ApiModelProperty(notes = "unique ID of enrollee", example = "7aaee0e2-6884-4fd7-ba63-21d76723dce2")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Generated(GenerationTime.ALWAYS)
	@Column(name = "dependentid", nullable = true, insertable = false, updatable = false)
	protected UUID id;

	@Column(name = "enrolleeid", nullable = false, insertable = true, updatable = true)
	protected UUID enrolleeid;
	
	public Dependent() {
	}
	public Dependent(UUID id, UUID enrolleeid) {
		this.id = id;
		this.enrolleeid = enrolleeid;
	}
	public Dependent(UUID id, UUID enrolleeid, String name, LocalDate birthDate) {
		this.id = id;
		this.enrolleeid = enrolleeid;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	//getters
	public UUID getId() {
		return id;
	}
	public UUID getEnrolleeid() {
		return enrolleeid;
	}
}
