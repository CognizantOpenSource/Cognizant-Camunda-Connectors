package com.cts.eas.ipm.connector.awss3connector.inputs;

import org.apache.camel.component.aws2.s3.AWS2S3Operations;

public class AWSS3ConnectorInput {

	private AWS2S3Operations awsS3Operation;

	private String bucketName;

	private String key;

	public AWS2S3Operations getAwsS3Operation() {
		return awsS3Operation;
	}

	public void setAwsS3Operation(AWS2S3Operations awsS3Operation) {
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
