package com.cts.eas.ipm.connector.awslambdaconnector.inputs;

//import javax.validation.constraints.NotEmpty;


//import io.camunda.connector.api.annotation.Secret;

public class AuthenticationRequestData  {

//	@NotEmpty
	private String accessKey;

//	@NotEmpty
	private String secretKey;

	private String region;

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
}
