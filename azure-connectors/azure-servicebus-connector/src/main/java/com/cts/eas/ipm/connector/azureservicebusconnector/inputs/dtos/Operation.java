package com.cts.eas.ipm.connector.azureservicebusconnector.inputs.dtos;

public enum Operation {

	PRODUCER("Producer"),
	CONSUMER("Consumer");

	private final String operationValue;

	Operation(String operationValue) {
		this.operationValue = operationValue ;
	}

	public static Operation valueOf(Operation operation) {
		return operation ;
	}

	public String getOperationValue() {
		return operationValue;
	}
}
