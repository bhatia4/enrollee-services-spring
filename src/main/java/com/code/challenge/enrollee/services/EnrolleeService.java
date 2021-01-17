package com.code.challenge.enrollee.services;

import com.code.challenge.enrollee.model.Dependent;
import com.code.challenge.enrollee.model.Enrollee;

public interface EnrolleeService {
	//enrollee service methods
	public Enrollee insertEnrollee(Enrollee enrollee);
	public Enrollee updateEnrollee(Enrollee enrollee);
	public Enrollee removeEnrollee(Enrollee enrollee);
	
	//dependent service methods
	public Dependent addDependent(Dependent dependent);
	public Dependent updateDependent(Dependent dependent);
	public Dependent removeDependent(Dependent dependent);
}
