package com.cts.eas.ipm.connector.awslambdaconnector.inputs;

public class AWSLambdaConnectorOutput {

	private Object payload;

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public AWSLambdaConnectorOutput(Object payload) {
		super();
		this.payload = payload;
	}

}
