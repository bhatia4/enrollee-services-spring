package com.code.challenge.enrollee;

import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.code.challenge.enrollee.services.EnrolleeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import com.code.challenge.enrollee.model.Dependent;
import com.code.challenge.enrollee.model.Enrollee;


@Api(tags = "Enrollees", value = "EnrolleeService")
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 405, message = "Method Not Allowed"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})

@RestController
public class EnrolleeServicesController {
	@Autowired
	EnrolleeService enrolleeServices;
	
	@ApiOperation(value="Add a new enrollee")
	@PostMapping(value = "${enrollees.api.path}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Enrollee insertNewEnrollee(@Valid @RequestBody Enrollee requestEnrollee) {
		return enrolleeServices.insertEnrollee( new Enrollee(null, requestEnrollee.getName(), requestEnrollee.getBirthDate(), 
												requestEnrollee.isActivationStatus(), requestEnrollee.getPhoneNumber()) );
	}

	@ApiOperation(value="Modify an existing enrollee")
	@PutMapping(value = "${enrollees.api.path}/{enrolleeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Enrollee updateExistingEnrollee(@ApiParam(value="Enrollee ID. Must be of type UUID") @PathVariable UUID enrolleeId, 
									@Valid @RequestBody Enrollee requestEnrollee) {
		return enrolleeServices.updateEnrollee( new Enrollee(enrolleeId, requestEnrollee.getName(), requestEnrollee.getBirthDate(), 
												requestEnrollee.isActivationStatus(), requestEnrollee.getPhoneNumber()) );
	}
	
	@ApiOperation(value="Remove an enrollee entirely")
	@DeleteMapping(value = "${enrollees.api.path}/{enrolleeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Enrollee removeExistingEnrollee(@ApiParam(value="Enrollee ID. Must be of type UUID") @PathVariable UUID enrolleeId) {
		return enrolleeServices.removeEnrollee(new Enrollee(enrolleeId));
	}
	
	@ApiOperation(value="Add dependents to an enrollee")
	@PostMapping(value = "${enrollees.api.path}/{enrolleeId}/${dependent.url.suffix}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Dependent insertNewDependentForExistingEnrollee(@ApiParam(value="Enrollee ID. Must be of type UUID") @PathVariable UUID enrolleeId,
			@Valid @RequestBody Dependent requestDependent) {
		return enrolleeServices.addDependent( new Dependent(null, enrolleeId, requestDependent.getName(), requestDependent.getBirthDate()) );
	}
	
	@ApiOperation(value="Modify existing dependents")
	@PutMapping(value = "${enrollees.api.path}/{enrolleeId}/${dependent.url.suffix}/{dependentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Dependent updateExistingDependentForExistingEnrollee(@ApiParam(value="Enrollee ID. Must be of type UUID") @PathVariable UUID enrolleeId,
															@ApiParam(value="Dependent ID. Must be of type UUID") @PathVariable UUID dependentId,
															@Valid @RequestBody Dependent requestDependent) {
		return enrolleeServices.updateDependent( new Dependent(dependentId, enrolleeId, requestDependent.getName(), requestDependent.getBirthDate()) );
	}
	
	@ApiOperation(value="Remove dependents from an enrollee")
	@DeleteMapping(value = "${enrollees.api.path}/{enrolleeId}/${dependent.url.suffix}/{dependentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Dependent removeExistingDependentForExistingEnrollee(@ApiParam(value="Enrollee ID. Must be of type UUID") @PathVariable UUID enrolleeId,
															@ApiParam(value="Dependent ID. Must be of type UUID") @PathVariable UUID dependentId) {
		return enrolleeServices.removeDependent( new Dependent(dependentId, enrolleeId) );
	}
}
