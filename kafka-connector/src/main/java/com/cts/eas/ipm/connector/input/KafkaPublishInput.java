package com.cts.eas.ipm.connector.input;

import javax.validation.constraints.NotNull;

import com.cts.eas.ipm.connector.inputs.ConnectorInput;


public class KafkaPublishInput  extends ConnectorInput{
	
	private String message;
	@NotNull
	private String topicName;
	@NotNull
	private String host;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
}
