package com.k15t.pat.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.k15t.pat.server.exception.EmailAlreadyExistsException;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messages;

	// 400
	@Override
	protected ResponseEntity<Object> handleBindException(final BindException ex, final HttpHeaders headers,
			final HttpStatus status, final WebRequest request) {
		logger.error("400 Status Code", ex);
		final BindingResult result = ex.getBindingResult();
		final GenericResponse bodyOfResponse = new GenericResponse(result.getAllErrors(),
				"Invalid" + result.getObjectName());
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	// 409
	@ExceptionHandler({ EmailAlreadyExistsException.class })
	public ResponseEntity<Object> handleUserAlreadyExist(final RuntimeException ex, final WebRequest request) {
		logger.error("409 Status Code", ex);
		final GenericResponse bodyOfResponse = new GenericResponse(
				messages.getMessage("message.regError", null, request.getLocale()), "Email already exists");
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request) {
		logger.error("500 Status Code", ex);
		final GenericResponse bodyOfResponse = new GenericResponse(
				messages.getMessage("message.error", null, request.getLocale()), "InternalError");
		return new ResponseEntity<>(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	// error handle for @Valid
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//		Map<String, Object> body = new LinkedHashMap<>();
//		body.put("timestamp", new Date());
//		body.put("status", status.value());
//
//		// Get all errors
//		Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
//				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
//		errors.putAll(ex.getBindingResult().getGlobalErrors().stream()
//				.collect(Collectors.toMap(ObjectError::getObjectName, ObjectError::getDefaultMessage)));
//		body.put("errors", errors);
//
//		return new ResponseEntity<>(errors, status);
//
//	}
//
//	@ExceptionHandler
//	@ResponseBody
//	public ResponseEntity<Object> handleException(Exception e) {
//		if (e instanceof EmailAlreadyExistsException) {
//			EmailAlreadyExistsException emailEx = (EmailAlreadyExistsException) e;
//			Map<String, Object> body = new LinkedHashMap<>();
//			body.put("status", HttpStatus.BAD_REQUEST.value());
//			Map<String, String> errors = new HashMap<>();
//			errors.put("email", emailEx.getMessage());
//			body.put("errors", errors);
//
//			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//		}
//		Map<String, Object> body = new LinkedHashMap<>();
//		Map<String, String> errors = new HashMap<>();
//		errors.put("Unexpected Exception", e.getMessage());
//		body.put("errors", errors);
//
//		return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}
