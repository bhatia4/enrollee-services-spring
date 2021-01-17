package com.code.challenge.enrollee.services;

import com.code.challenge.enrollee.model.Dependent;
import com.code.challenge.enrollee.model.Enrollee;

public interface EnrolleeService {
	//enrollee service methods
	public Enrollee insertEnrollee(Enrollee enrollee);
	public Enrollee updateEnrollee(Enrollee enrollee);
	public Enrollee removeEnrollee(Enrollee enrollee);
	
	//dependent service methdos
	public Dependent addDependent(Dependent dependent, Enrollee enrollee);
	public Enrollee updateDependent(Dependent dependent, Enrollee enrollee);
	public Enrollee removeDependent(Dependent dependent, Enrollee enrollee);
}
