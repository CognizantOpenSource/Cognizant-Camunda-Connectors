package com.cts.eas.ipm.connector.azureservicebusconnector.inputs;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.cts.eas.ipm.connector.inputs.ConnectorInput;

public class AzureServiceBusConnectorInput extends ConnectorInput{

	@Valid
	@NotNull	
	private ServiceBusConnectorInputs inData;

	@Valid
	@NotNull	
	private AuthenticationRequestData authentication ;

	public ServiceBusConnectorInputs getInData() {
		return inData;
	}

	public void setInData(ServiceBusConnectorInputs inData) {
		this.inData = inData;
	}

	public AuthenticationRequestData getAuthentication() {
		return authentication;
	}

	public void setAuthentication(AuthenticationRequestData authentication) {
		this.authentication = authentication;
	}

	@Override
	public String toString() {
		return "AzureConnectorInput [inData=" + inData + ", authentication=" + authentication + "]";
	}
	
	
}
