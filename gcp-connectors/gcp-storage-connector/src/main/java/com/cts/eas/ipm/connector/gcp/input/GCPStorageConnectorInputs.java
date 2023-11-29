package com.cts.eas.ipm.connector.gcp.input;

public class GCPStorageConnectorInputs {
	private String bucketName;
	private String objectName;
	private String gcpStorageOperation;
	private String projectId;
	private String serviceAccountKey;
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public String getGcpStorageOperation() {
		return gcpStorageOperation;
	}
	public void setGcpStorageOperation(String gcpStorageOperation) {
		this.gcpStorageOperation = gcpStorageOperation;
	}
	public String getServiceAccountKey() {
		return serviceAccountKey;
	}
	public void setServiceAccountKey(String serviceAccountKey) {
		this.serviceAccountKey = serviceAccountKey;
	}
	
	

}
