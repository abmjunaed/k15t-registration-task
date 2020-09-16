package com.k15t.pat.server.exception;

public class EmailAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmailAlreadyExistsException() {
		super();
	}

	public EmailAlreadyExistsException(String message) {
		super(message);
	}

	public EmailAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
