package com.cts.eas.ipm.connector.outboundconnector;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.cts.eas.ipm.connector.outbound.CustomConnector;

import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.test.outbound.OutboundConnectorContextBuilder;

class CustomConnectorTest extends BaseTest{

	@ParameterizedTest
	@MethodSource
	void doSuccessCustomConnectorTest(String input) throws Exception{
		
		OutboundConnectorContext outboundcontext = OutboundConnectorContextBuilder.create().variables(input).build();		
		CustomConnector customConnector = new CustomConnector();	
								
		Object result = customConnector.execute(outboundcontext);
		
		assertNotNull(result);

	}
	
}
