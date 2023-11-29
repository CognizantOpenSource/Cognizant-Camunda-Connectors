package com.cts.eas.ipm.connector.azureservicebusconnector.inputs.dtos;

import org.apache.camel.component.azure.servicebus.ServiceBusConsumerOperationDefinition;

public class Consumer {

	private ServiceBusConsumerOperationDefinition consumerOperationDefinition;
	
	private Integer peekNumMaxMessages ;
	
	private Long pollingWaitTime;
	
	private String activationCondition;

	public Integer getPeekNumMaxMessages() {
		return peekNumMaxMessages;
	}

	public Long getPollingWaitTime() {
		return pollingWaitTime;
	}

	public ServiceBusConsumerOperationDefinition getConsumerOperationDefinition() {
		return consumerOperationDefinition;
	}

	public String getActivationCondition() {
		return activationCondition;
	}

	public void setActivationCondition(String activationCondition) {
		this.activationCondition = activationCondition;
	}
	
}
