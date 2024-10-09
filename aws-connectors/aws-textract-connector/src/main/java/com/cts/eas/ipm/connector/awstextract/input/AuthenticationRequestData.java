package com.cts.eas.ipm.connector.awstextract.input;

public class AuthenticationRequestData {
	private String accessKey;
	private String secretKey;
	private String region;

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(final String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(final String secretKey) {
		this.secretKey = secretKey;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "AuthenticationRequestData{" +
				"accessKey='" + accessKey + '\'' +
				", secretKey='" + secretKey + '\'' +
				", region='" + region + '\'' +
				'}';
	}
}