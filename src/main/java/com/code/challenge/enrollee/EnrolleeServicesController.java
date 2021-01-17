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
	private static final String VALIDATION_ERROR_FOR_NUMERIC_PARAMS = "Validation error(s): [minRoomCount, maxRoomCount] must be whole numbers; [minBathroom, maxBathroom, minPrice, maxPrice] must be whole numbers or decimals";
	private static final String VALIDATION_ERROR_FOR_UUID = "Validation error: id must be of type Universally Unique Identifier (UUID)";
	private static final String VALIDATION_ERROR_FOR_COUNTRY_STATE_CITY = "Validation error: no unique row using combination of cityName, stateCode, or countryCode. There may be multiple rows, so enter specific countyName and enter it exactly.";
	
	@Autowired
	EnrolleeService enrolleeServices;
	
	@ApiOperation(value="Add a new enrollee")
	@PostMapping(value = "${enrollees.api.path}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Enrollee insertNewEnrollee(@Valid @RequestBody Enrollee requestEnrollee) {
		return enrolleeServices.insertEnrollee(requestEnrollee);
	}

	@ApiOperation(value="Modify an existing enrollee")
	@PutMapping(value = "${enrollees.api.path}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Enrollee updateExistingEnrollee(@Valid @RequestBody Enrollee requestEnrollee) {
		return enrolleeServices.updateEnrollee(requestEnrollee);
	}
	
	@ApiOperation(value="Remove an enrollee entirely")
	@DeleteMapping(value = "${enrollees.api.path}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Enrollee removeExistingEnrollee(@Valid @RequestBody Enrollee requestEnrollee) {
		return enrolleeServices.removeEnrollee(requestEnrollee);
	}
	
	@ApiOperation(value="Add dependents to an enrollee")
	@PostMapping(value = "${enrollees.api.path}/{enrolleeId}/${dependent.url.suffix}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Dependent insertNewDependentForExistingEnrollee(/*@ApiParam(value="Enrollee ID. Must be of type UUID")*/ @PathVariable UUID enrolleeId,
			@Valid @RequestBody Dependent requestDependent) {
		return enrolleeServices.addDependent(requestDependent, new Enrollee(enrolleeId));
	}
	
	@ApiOperation(value="Remove dependents from an enrollee")
	@PutMapping(value = "${enrollees.api.path}/{enrolleeId}/${dependent.url.suffix}/{dependentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Enrollee updateExistingDependentForExistingEnrollee(/*@ApiParam(value="Enrollee ID. Must be of type UUID")*/ @PathVariable UUID enrolleeId,
			/*@ApiParam(value="Dependent ID. Must be of type UUID")*/ @PathVariable UUID dependentId) {
		return enrolleeServices.updateDependent(new Dependent(dependentId), new Enrollee(enrolleeId));
	}
	
	@ApiOperation(value="Modify existing dependents")
	@DeleteMapping(value = "${enrollees.api.path}/{enrolleeId}/${dependent.url.suffix}/{dependentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Enrollee removeExistingDependentForExistingEnrollee(/*@ApiParam(value="Enrollee ID. Must be of type UUID")*/ @PathVariable UUID enrolleeId,
			/*@ApiParam(value="Dependent ID. Must be of type UUID")*/ @PathVariable UUID dependentId) {
		return enrolleeServices.removeDependent(new Dependent(dependentId), new Enrollee(enrolleeId));
	}
}
