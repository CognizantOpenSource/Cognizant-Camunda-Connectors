package com.cts.eas.ipm.connector.awss3connector.inputs;


public class ConnectorInput {

	 private AuthenticationRequestData authentication;
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
