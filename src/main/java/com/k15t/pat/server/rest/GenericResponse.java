package com.k15t.pat.server.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import io.swagger.annotations.ApiModelProperty;

public class GenericResponse {
	@ApiModelProperty(notes = "If the request is successful, it containe \"message\": \"success\"."
			+ " If there is error, it looks like this e.g. \"message\": \"Account already exists with this email\"."
			+ "  If there is field error, it contains the erorr message in JSON format. "
			+ "The format looks like this: \"message\": \"[{\"field\":\"fieldName\",\"defaultMessage\":\"the error message\"},"
			+ "{\"field\":\"fieldName\",\"defaultMessage\":\"the error message\"}]\"")
    private String message;

	@ApiModelProperty(notes = "If there is no error, the format is \"error\": null. "
			+ "Otherwise, Key-value to indicate the error happened e.g. -> \"error\": \"InvalidUser\"")
    private String error;

    public GenericResponse(final String message) {
        super();
        this.message = message;
    }

    public GenericResponse(final String message, final String error) {
        super();
        this.message = message;
        this.error = error;
    }

    public GenericResponse(List<ObjectError> allErrors, String error) {
        this.error = error;
        String temp = allErrors.stream().map(e -> {
            if (e instanceof FieldError) {
                return "{\"field\":\"" + ((FieldError) e).getField() + "\",\"defaultMessage\":\"" + e.getDefaultMessage() + "\"}";
            } else {
                return "{\"object\":\"" + e.getObjectName() + "\",\"defaultMessage\":\"" + e.getDefaultMessage() + "\"}";
            }
        }).collect(Collectors.joining(","));
        this.message = "[" + temp + "]";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(final String error) {
        this.error = error;
    }

}
