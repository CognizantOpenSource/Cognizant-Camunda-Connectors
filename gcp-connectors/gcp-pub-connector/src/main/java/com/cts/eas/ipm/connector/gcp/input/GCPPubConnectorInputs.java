package com.cts.eas.ipm.connector.gcp.input;

public class GCPPubConnectorInputs {
 
	
	private String projectId;
	private String topicName;
	private String message;
	private String serviceAccountKey;
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getServiceAccountKey() {
		return serviceAccountKey;
	}
	public void setServiceAccountKey(String serviceAccountKey) {
		this.serviceAccountKey = serviceAccountKey;
	}
	
}
