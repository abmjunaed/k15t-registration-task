package com.k15t.pat.server.api;

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
import com.k15t.pat.server.model.ApiGenericResponse;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messages;

	/**
	 * To handle wrong input values
	 */
	@Override
	protected ResponseEntity<Object> handleBindException(final BindException ex, final HttpHeaders headers,
			final HttpStatus status, final WebRequest request) {
		logger.error("400 Status Code: " + ex);
		final BindingResult result = ex.getBindingResult();
		final ApiGenericResponse bodyOfResponse = new ApiGenericResponse(result.getAllErrors(),
				"Invalid" + result.getObjectName());
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ EmailAlreadyExistsException.class })
	public ResponseEntity<Object> handleEmailAlreadyExist(final EmailAlreadyExistsException ex,
			final WebRequest request) {
		logger.error("409 Status Code: " + ex);
		final ApiGenericResponse bodyOfResponse = new ApiGenericResponse(
				messages.getMessage("registration.email.exists", null, request.getLocale()), "EmailAlreadyExist");
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request) {
		logger.error("500 Status Code: " + ex);
		final ApiGenericResponse bodyOfResponse = new ApiGenericResponse(
				messages.getMessage("message.error", null, request.getLocale()), "InternalError");
		return new ResponseEntity<>(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
