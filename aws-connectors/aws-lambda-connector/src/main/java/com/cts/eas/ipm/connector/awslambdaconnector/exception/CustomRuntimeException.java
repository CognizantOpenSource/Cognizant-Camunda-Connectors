package com.cts.eas.ipm.connector.awslambdaconnector.exception;

public class CustomRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CustomRuntimeException() {
		super();
	}

	public CustomRuntimeException(Exception e) {
		super(e);
	}

	public CustomRuntimeException(String message) {
		super(message);
	}

	public CustomRuntimeException(String message, Exception e) {
		super(message, e);
	}

}
