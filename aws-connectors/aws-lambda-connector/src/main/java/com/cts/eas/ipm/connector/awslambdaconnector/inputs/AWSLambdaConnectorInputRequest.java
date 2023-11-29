package com.cts.eas.ipm.connector.awslambdaconnector.inputs;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.camunda.connector.api.annotation.Secret;

public class AWSLambdaConnectorInputRequest {

	@Valid
	@NotNull
	@Secret
	private AWSLambdaConnectorInputs inData;

	@Valid
	@NotNull
	@Secret
	private AuthenticationRequestData authentication ;

	public AWSLambdaConnectorInputs getInData() {
		return inData;
	}

	public void setInData(AWSLambdaConnectorInputs inData) {
		this.inData = inData;
	}

	public AuthenticationRequestData getAuthentication() {
		return authentication;
	}

	public void setAuthentication(AuthenticationRequestData authentication) {
		this.authentication = authentication;
	}
}
