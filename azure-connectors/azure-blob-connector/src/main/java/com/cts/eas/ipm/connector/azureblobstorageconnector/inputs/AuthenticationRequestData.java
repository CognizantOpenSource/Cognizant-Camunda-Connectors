package com.cts.eas.ipm.connector.azureblobstorageconnector.inputs;

import org.apache.camel.component.azure.storage.blob.CredentialType;

public class AuthenticationRequestData {

	private String accessKey;
	
	private CredentialType credentialType;
	
	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public CredentialType getCredentialType() {
		return credentialType;
	}

	public void setCredentialType(CredentialType credentialType) {
		this.credentialType = credentialType;
	}

	
	
}
