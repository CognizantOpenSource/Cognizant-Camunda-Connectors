package com.cts.eas.ipm.connector.azureblobstorageconnector.inputs;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.cts.eas.ipm.connector.inputs.ConnectorInput;

import io.camunda.connector.api.annotation.Secret;

public class AzureBlobStorageConnectorInput extends ConnectorInput{

	@Valid
	@NotNull
	@Secret
	private BlobStorageConnectorInputs inData;

	@Valid
	@NotNull
	@Secret
	private AuthenticationRequestData authentication ;

	public BlobStorageConnectorInputs getInData() {
		return inData;
	}

	public void setInData(BlobStorageConnectorInputs inData) {
		this.inData = inData;
	}

	public AuthenticationRequestData getAuthentication() {
		return authentication;
	}

	public void setAuthentication(AuthenticationRequestData authentication) {
		this.authentication = authentication;
	}

	
}
