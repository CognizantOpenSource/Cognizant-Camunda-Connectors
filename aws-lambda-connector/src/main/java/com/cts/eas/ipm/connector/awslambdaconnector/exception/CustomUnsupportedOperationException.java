package com.cts.eas.ipm.connector.awslambdaconnector.exception;

public class CustomUnsupportedOperationException extends Exception {
	private static final long serialVersionUID = 1L;

	public CustomUnsupportedOperationException() {
		super();
	}

	public CustomUnsupportedOperationException(Exception e) {
		super(e);
	}

	public CustomUnsupportedOperationException(String message) {
		super(message);
	}

	public CustomUnsupportedOperationException(String message, Exception e) {
		super(message, e);
	}
}
