package com.cts.eas.ipm.connector.gcp.input;

import com.cts.eas.ipm.connector.inputs.ConnectorInput;

public class GCPPubConnectorInput extends ConnectorInput {
	
	private GCPPubConnectorInputs inData;

	public GCPPubConnectorInputs getInData() {
		return inData;
	}

	public void setInData(GCPPubConnectorInputs inData) {
		this.inData = inData;
	}
}