package com.code.challenge.enrollee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.code.challenge.enrollee.dao.DependentsRepository;
import com.code.challenge.enrollee.dao.EnrolleesRepository;
import com.code.challenge.enrollee.model.Dependent;
import com.code.challenge.enrollee.model.Enrollee;

@Service
public class EnrolleeServiceImpl implements EnrolleeService {

	@Autowired
	EnrolleesRepository enrolleesRepository;

	@Autowired
	DependentsRepository dependentsRepository;
	
	@Override
	public Enrollee insertEnrollee(Enrollee enrollee) {
		return enrolleesRepository.save(enrollee);
	}

	@Override
	public Enrollee updateEnrollee(Enrollee inputEnrollee) {
		Enrollee enrolleeToUpdate = null;
		if (inputEnrollee.getId()!=null && enrolleesRepository.existsById(inputEnrollee.getId())) { //if enrollee found using ID
			enrolleeToUpdate = enrolleesRepository.findById(inputEnrollee.getId()).get();
			enrolleeToUpdate.setName(inputEnrollee.getName());
			enrolleeToUpdate.setBirthDate(inputEnrollee.getBirthDate());
			enrolleeToUpdate.setActivationStatus(inputEnrollee.isActivationStatus());
			enrolleeToUpdate.setPhoneNumber(inputEnrollee.getPhoneNumber());
			
			enrolleesRepository.save(enrolleeToUpdate);
		}
		return enrolleeToUpdate;
	}

	@Override
	public Enrollee removeEnrollee(Enrollee inputEnrollee) {
		Enrollee enrolleetoDelete = null;
		if (inputEnrollee.getId()!=null && enrolleesRepository.existsById(inputEnrollee.getId())) { //if enrollee found using ID
			enrolleetoDelete = enrolleesRepository.findById(inputEnrollee.getId()).get();
			enrolleesRepository.deleteById(enrolleetoDelete.getId());
		}
		return enrolleetoDelete;
	}

	@Override
	public Dependent addDependent(Dependent dependent) {
		return dependentsRepository.save(dependent);
	}

	@Override
	public Dependent updateDependent(Dependent inputDependent) {
		Dependent dependentToUpdate = null;
		if ( (inputDependent.getId()!=null && dependentsRepository.existsById(inputDependent.getId())) //if dependent found using ID
				&& (inputDependent.getEnrolleeid()!=null && enrolleesRepository.existsById(inputDependent.getEnrolleeid())) ) { //AND if enrollee found using enrolleeID
			dependentToUpdate = dependentsRepository.findByIdAndEnrolleeid(inputDependent.getId(), inputDependent.getEnrolleeid());
			dependentToUpdate.setName(inputDependent.getName());
			dependentToUpdate.setBirthDate(inputDependent.getBirthDate());
			
			dependentsRepository.save(dependentToUpdate);
		}
		return dependentToUpdate;

	}

	@Override
	public Dependent removeDependent(Dependent inputDependent) {
		Dependent dependentToDelete = null;
		if ( (inputDependent.getId()!=null && dependentsRepository.existsById(inputDependent.getId())) //if dependent found using ID
				&& (inputDependent.getEnrolleeid()!=null && enrolleesRepository.existsById(inputDependent.getEnrolleeid())) ) { //AND if enrollee found using enrolleeID
			dependentToDelete = dependentsRepository.findByIdAndEnrolleeid(inputDependent.getId(), inputDependent.getEnrolleeid());
			dependentsRepository.deleteById(dependentToDelete.getId());
		}
		return dependentToDelete;
	}
}
