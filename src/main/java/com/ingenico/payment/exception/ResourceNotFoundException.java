package com.ingenico.payment.exception;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -1611271807322176794L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String message, Throwable ex) {
		super(message, ex);
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(Throwable ex) {
		super(ex);
	}

}
