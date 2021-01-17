package com.code.challenge.enrollee.model;

import java.time.LocalDate;
import java.util.UUID;

public class Dependent extends Applicant {
	public Dependent(UUID id) {
		this.id = id;
	}
	public Dependent(UUID id, String name, LocalDate birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
}
