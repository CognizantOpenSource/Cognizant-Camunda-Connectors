package com.cts.eas.ipm.connector.awstextract.input;

import com.cts.eas.ipm.connector.inputs.ConnectorInput;

public class AWSTextractConnectorInput extends ConnectorInput {
	private AuthenticationRequestData authentication;
	private AWSTextractConnectorInputs inData;

	public AWSTextractConnectorInputs getInData() {
		return inData;
	}

	public void setInData(AWSTextractConnectorInputs inData) {
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
		return "AWSTextractConnectorInput{" +
				"authentication=" + authentication +
				", inData=" + inData +
				'}';
	}
}
