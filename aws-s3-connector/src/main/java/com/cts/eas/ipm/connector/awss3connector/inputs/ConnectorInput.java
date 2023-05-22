package com.cts.eas.ipm.connector.awss3connector.inputs;

import io.camunda.connector.api.annotation.Secret;

public class ConnectorInput {

	@Secret private AuthenticationRequestData authentication;
	private AWSS3ConnectorInput inData;
	
	public AuthenticationRequestData getAuthentication() {
	    return authentication;
	  }

	  public void setAuthentication(AuthenticationRequestData authentication) {
	    this.authentication = authentication;
	  }

	public AWSS3ConnectorInput getInData() {
		return inData;
	}

	public void setInData(AWSS3ConnectorInput inData) {
		this.inData = inData;
	}

}
