package com.cts.eas.ipm.connector.azureservicebusconnector.inputs;

import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.dtos.CommonInputs;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.dtos.Consumer;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.dtos.Producer;

public class ServiceBusConnectorInputs {	
	
	private Producer producer;
	
	private CommonInputs commonInputs; 
	
	private Consumer consumer;

	public Producer getProducer() {
		return producer;
	}
	
	public Consumer getConsumer() {
		return consumer;
	}

	public CommonInputs getCommonInputs() {
		return commonInputs;
	}
	
	

}
