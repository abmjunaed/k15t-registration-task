package com.k15t.pat.server.rest;

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

import com.k15t.pat.common.data.UserData;
import com.k15t.pat.server.exception.EmailAlreadyExistsException;
import com.k15t.pat.server.service.UserService;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationRestController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserService service;

	@PostMapping(consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public GenericResponse doRegistration(@Valid UserData userData) throws EmailAlreadyExistsException {
		log.debug("Registering user account with information: {}", userData);
		service.register(userData);
		log.debug("success");
		return new GenericResponse("success");
	}

//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//		Map<String, String> errors = new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach((error) -> {
//			String fieldName = ((FieldError) error).getField();
//			String errorMessage = error.getDefaultMessage();
//			errors.put(fieldName, errorMessage);
//		});
//		return errors;
//	}
}
