package com.cts.eas.ipm.connector.azureblobstorageconnector;

import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import io.camunda.connector.test.outbound.OutboundConnectorContextBuilder;
import io.camunda.connector.test.outbound.OutboundConnectorContextBuilder.TestConnectorContext;

@TestMethodOrder(OrderAnnotation.class)
class AzureBlobStorageConnectorTest extends BaseTest {

	private AzureBlobStorageConnectorFunction azureBlobStorageConnectorFunction;

	@Override
	public boolean isUseAdviceWith() {
		return true;
	}

	@Override
	public String isMockEndpointsAndSkip() {
		return "*";
	}
	
	@BeforeEach
	void init() {
		azureBlobStorageConnectorFunction = new AzureBlobStorageConnectorFunction(context);
	}

	@ParameterizedTest
	@MethodSource(value = { "doSuccessAzureBlobStorageProducerListBlobContainersTest"})	
	void doSuccessAzureBlobStorageProducerListBlobContainersTest(String input) throws Exception {
	
		TestConnectorContext outboundContext = OutboundConnectorContextBuilder.create().variables(input).build();
				
		azureBlobStorageConnectorFunction.executeContext(outboundContext);
		
		MockEndpoint.assertIsSatisfied(context);

	}
	
	
	@ParameterizedTest
	@MethodSource(value = {"doSuccessAzureBlobStorageProducerListBlobsTest" })	
	void doSuccessAzureBlobStorageProducerListBlobsTest(String input) throws Exception {
	
		TestConnectorContext outboundContext = OutboundConnectorContextBuilder.create().variables(input).build();
				
		azureBlobStorageConnectorFunction.executeContext(outboundContext);
		
		MockEndpoint.assertIsSatisfied(context);

	}
	

	@ParameterizedTest
	@MethodSource(value = {"doSuccessAzureBlobStorageProducerUploadBlockBlobTest" })	
	void doSuccessAzureBlobStorageProducerUploadBlockBlobTest(String input) throws Exception {
					
		TestConnectorContext outboundContext = OutboundConnectorContextBuilder.create().variables(input).build();
		
		azureBlobStorageConnectorFunction.executeContext(outboundContext);
		
		MockEndpoint.assertIsSatisfied(context);

	}
	
	
	
}