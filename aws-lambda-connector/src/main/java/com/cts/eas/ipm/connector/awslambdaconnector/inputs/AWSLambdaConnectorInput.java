package com.cts.eas.ipm.connector.awslambdaconnector.inputs;


public class AWSLambdaConnectorInput {

	private String operationType;

	private String functionName ;

	private Object payload ;

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}




}
