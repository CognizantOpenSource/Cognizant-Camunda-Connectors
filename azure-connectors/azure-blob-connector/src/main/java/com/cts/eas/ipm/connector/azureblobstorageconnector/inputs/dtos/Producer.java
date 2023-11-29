package com.cts.eas.ipm.connector.azureblobstorageconnector.inputs.dtos;

import org.apache.camel.component.azure.storage.blob.BlobOperationsDefinition;

public class Producer extends CommonInputs{

	private BlobOperationsDefinition blobOperationsDefinition;
	
	private String blobName;
	
	private String payload;

	public BlobOperationsDefinition getBlobOperationsDefinition() {
		return blobOperationsDefinition;
	}
	
	public String getBlobName() {
		return blobName;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
	
}
