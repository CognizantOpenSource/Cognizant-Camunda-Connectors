package com.cts.eas.ipm.connector.drools.input;

import java.io.Serializable;

import com.cts.eas.ipm.connector.inputs.ConnectorInput;

public class DroolsConnectorInput extends ConnectorInput implements Serializable {

	private static final long serialVersionUID = 1L;

	private DroolsConnectorInputs inData;

	public DroolsConnectorInputs getInData() {
		return inData;
	}

	public void setInData(DroolsConnectorInputs inData) {
		this.inData = inData;
	}

}
