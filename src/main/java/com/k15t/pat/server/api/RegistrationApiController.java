package com.k15t.pat.server.api;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.k15t.pat.server.exception.EmailAlreadyExistsException;
import com.k15t.pat.server.model.ApiGenericResponse;
import com.k15t.pat.server.model.UserDTO;
import com.k15t.pat.server.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationApiController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService service;

	@PostMapping(consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE }, produces = { "application/json" })
	@ResponseStatus(HttpStatus.CREATED)
	// swagger documentation
	@ApiOperation(value = "Register an user", response = ApiGenericResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "success"),
			@ApiResponse(code = 400, message = "Bad request", response = ApiGenericResponse.class),
			@ApiResponse(code = 409, message = "EmailAlreadyExist"),
			@ApiResponse(code = 500, message = "InternalError") })
	public ApiGenericResponse addUser(@Valid UserDTO userData) throws EmailAlreadyExistsException {
		log.debug("Registering user account with information: {}", userData);
		service.register(userData);
		return new ApiGenericResponse("success");
	}
}
