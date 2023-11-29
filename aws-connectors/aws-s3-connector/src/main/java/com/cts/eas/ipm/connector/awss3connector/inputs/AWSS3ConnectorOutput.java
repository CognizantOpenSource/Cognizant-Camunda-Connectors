package com.cts.eas.ipm.connector.awss3connector.inputs;

public class AWSS3ConnectorOutput {

	private String payload;

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public AWSS3ConnectorOutput(String payload) {
		super();
		this.payload = payload;
	}

}
