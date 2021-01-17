package com.code.challenge.enrollee.dao;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.code.challenge.enrollee.model.Enrollee;

@Repository
public interface EnrolleesRepository extends CrudRepository<Enrollee, UUID> {
}
