package com.cts.eas.ipm.connector.awslambdaconnector.inputs;

import org.apache.camel.component.aws2.lambda.Lambda2Operations;

public class AWSLambdaConnectorInputs {

	private Lambda2Operations operationType;

	private String functionName ;

	private Object payload ;

	public Lambda2Operations getOperationType() {
		return operationType;
	}

	public void setOperationType(Lambda2Operations operationType) {
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
