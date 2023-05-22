package com.cts.eas.ipm.connector.awslambdaconnector.inputs;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.camunda.connector.api.annotation.Secret;

public class ConnectorInput {

	@Valid
	@NotNull
	@Secret
	private AWSLambdaConnectorInput inData;

	@Valid
	@NotNull
	@Secret
	private AuthenticationRequestData authentication ;

	public AWSLambdaConnectorInput getInData() {
		return inData;
	}

	public void setInData(AWSLambdaConnectorInput inData) {
		this.inData = inData;
	}

	public AuthenticationRequestData getAuthentication() {
		return authentication;
	}

	public void setAuthentication(AuthenticationRequestData authentication) {
		this.authentication = authentication;
	}
}
