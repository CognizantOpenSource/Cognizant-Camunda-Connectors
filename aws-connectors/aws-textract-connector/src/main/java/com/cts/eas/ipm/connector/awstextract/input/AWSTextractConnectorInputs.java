package com.cts.eas.ipm.connector.awstextract.input;

import java.util.Arrays;

public class AWSTextractConnectorInputs {
  

	private String operation;


	private String sourceDocument;

	public String getSourceDocument() {
		return sourceDocument;
	}

	public void setSourceDocument(String sourceDocument) {
		this.sourceDocument = sourceDocument;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "AWSTextractConnectorInputs{" +
				"operation='" + operation + '\'' +
				", sourceDocument=" + sourceDocument +
				'}';
	}
}
