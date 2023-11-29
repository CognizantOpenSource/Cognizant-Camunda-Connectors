package com.cts.eas.ipm.connector.outbound;

import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.eas.ipm.connector.exceptions.ProviderNotFoundException;
import com.cts.eas.ipm.connector.inputs.ConnectorInput;

import io.camunda.connector.api.annotation.OutboundConnector;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.api.outbound.OutboundConnectorFunction;

@OutboundConnector(name = "CustomConnector", inputVariables = { "connectorId", "inData", "authentication", "message",
		"topicName", "host", "port", "userName", "password", "directoryName", "filePath", "protocol", "operationMode"},
		type = "outbound-connector")
public class CustomConnector implements OutboundConnectorFunction {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomConnector.class);

	@Override
	public Object execute(OutboundConnectorContext context) throws Exception {
		Object obj = null;
		try{
		LOGGER.debug("Input Variables1 -> {} " , context.getVariables());				
		obj = getProvider(context.bindVariables(ConnectorInput.class))
				.get().executeContext(context);		
		}	
		catch(Exception e){
			System.out.println("EXP:"+e);
		}
		System.out.println("obj:"+obj);
return obj;		
		
	}
	
	static Provider<CoreOutboundConnector> getProvider(ConnectorInput input) throws ProviderNotFoundException{		
		return	ServiceLoader.load(CoreOutboundConnector.class)
				 .stream()
				 .filter(it -> it.type().getSimpleName().equals(input.getConnectorId()))
				 .findAny().orElseThrow(ProviderNotFoundException::new);				 	
	}

}
