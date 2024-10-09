package com.cts.eas.ipm.connector.inbound.util;

public class ConnectorInboundInput {
	
	private String projectId;
	private String topicName;
	private String subscriptionId;
	private String serviceAccountKey;
	private String pollingWaitTime;
	
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
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getServiceAccountKey() {
		return serviceAccountKey;
	}
	public void setServiceAccountKey(String serviceAccountKey) {
		this.serviceAccountKey = serviceAccountKey;
	}
	public String getPollingWaitTime() {
		return pollingWaitTime;
	}
	public void setPollingWaitTime(String pollingWaitTime) {
		this.pollingWaitTime = pollingWaitTime;
	}
	
	

}
