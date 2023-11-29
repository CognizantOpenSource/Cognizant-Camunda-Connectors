package com.cts.eas.ipm.connector.awslambdaconnector;

import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.cts.eas.ipm.connector.awslambdaconnector.AWSLambdaConnector;

import io.camunda.connector.test.outbound.OutboundConnectorContextBuilder;
import io.camunda.connector.test.outbound.OutboundConnectorContextBuilder.TestConnectorContext;


@TestMethodOrder(OrderAnnotation.class)
class AWSLambdaConnectorTest extends BaseTest {

	private AWSLambdaConnector awsLambdaConnector ;

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
		awsLambdaConnector = new AWSLambdaConnector(context);
	}

	@ParameterizedTest
	@MethodSource(value = { "doSuccessAWSLambdaListFunctionsTest"})	
	void doSuccessAWSLambdaListFunctionsTest(String input) throws Exception {

		TestConnectorContext outboundContext = OutboundConnectorContextBuilder.create().variables(input).build();
				
		awsLambdaConnector.executeContext(outboundContext);
		
		MockEndpoint.assertIsSatisfied(context);

	}
	
	@ParameterizedTest
	@MethodSource(value = { "doSuccessAWSLambdaInvokeFunctionTest"})	
	void doSuccessAWSLambdaInvokeFunctionTest(String input) throws Exception {
	
		TestConnectorContext outboundContext = OutboundConnectorContextBuilder.create().variables(input).build();
				
		awsLambdaConnector.executeContext(outboundContext);
		
		MockEndpoint.assertIsSatisfied(context);

	}
	
}