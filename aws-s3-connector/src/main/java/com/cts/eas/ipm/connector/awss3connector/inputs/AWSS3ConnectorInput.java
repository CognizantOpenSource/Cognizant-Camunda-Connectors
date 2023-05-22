package com.cts.eas.ipm.connector.awss3connector.inputs;

public class AWSS3ConnectorInput {

	private String awsS3Operation;

	private String bucketName;

	private String key;

	public String getAwsS3Operation() {
		return awsS3Operation;
	}

	public void setAwsS3Operation(String awsS3Operation) {
		this.awsS3Operation = awsS3Operation;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
