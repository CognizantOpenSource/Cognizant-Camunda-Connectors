package com.cts.eas.ipm.connector.azureservicebusconnector.inputs.dtos;

import org.apache.camel.component.azure.servicebus.ServiceBusProducerOperationDefinition;

public class Producer {

	private ServiceBusProducerOperationDefinition producerOperationDefinition ;
	
	private String payload ;

	public ServiceBusProducerOperationDefinition getProducerOperationDefinition() {
		return producerOperationDefinition;
	}

	public String getPayload() {
		return payload;
	}
	
}
