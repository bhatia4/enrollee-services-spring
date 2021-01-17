package com.code.challenge.enrollee.dao;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.code.challenge.enrollee.model.Dependent;

/**
 * 
 * @author Kunal Bhatia
 *
 */
@Repository
public interface DependentsRepository extends CrudRepository<Dependent, UUID> {
	//custom repository method to find Dependent by ID and enrolleeid
	Dependent findByIdAndEnrolleeid(UUID id, UUID enrolleeid);
}
