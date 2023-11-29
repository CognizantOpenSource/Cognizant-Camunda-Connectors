package com.cts.eas.ipm.connector.azureservicebusconnector.inputs.dtos;

import org.apache.camel.component.azure.servicebus.ServiceBusType;

public class CommonInputs {
	
	private String queueName;
	
	private ServiceBusType serviceBusType;

	public String getQueueName() {
		return queueName;
	}

	public ServiceBusType getServiceBusType() {
		return serviceBusType;
	}
	
}

