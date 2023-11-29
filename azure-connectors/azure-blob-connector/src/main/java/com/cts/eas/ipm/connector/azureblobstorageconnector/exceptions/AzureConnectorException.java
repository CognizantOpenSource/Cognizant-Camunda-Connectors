package com.cts.eas.ipm.connector.azureblobstorageconnector.exceptions;

public class AzureConnectorException extends Exception {

	private static final long serialVersionUID = 1L;

	public AzureConnectorException() {
		super();
	}

	public AzureConnectorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AzureConnectorException(String message, Throwable cause) {
		super(message, cause);
	}

	public AzureConnectorException(String message) {
		super(message);
	}

	public AzureConnectorException(Throwable cause) {
		super(cause);
	}

	
	
}
