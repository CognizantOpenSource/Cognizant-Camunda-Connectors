package com.cts.eas.ipm.connector.azureservicebusconnector.outbound;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.azureServicebus;

import org.apache.camel.Endpoint;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.builder.endpoint.dsl.ServiceBusEndpointBuilderFactory.ServiceBusEndpointProducerBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.cts.eas.ipm.connector.azureservicebusconnector.BaseTest;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.AzureServiceBusConnectorInput;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.dtos.Operation;
import com.cts.eas.ipm.connector.azureservicebusconnector.outbound.AzureServiceBusConnectorFunction;

import io.camunda.connector.test.outbound.OutboundConnectorContextBuilder;
import io.camunda.connector.test.outbound.OutboundConnectorContextBuilder.TestConnectorContext;

@TestMethodOrder(OrderAnnotation.class)
class AzureServiceBusConnectorTest extends BaseTest {

	private AzureServiceBusConnectorFunction serviceBusConnector;

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
		serviceBusConnector = new AzureServiceBusConnectorFunction(context);
	}

	@ParameterizedTest
	@MethodSource("doSuccessAzureServiceBusProducerTest")
	@Order(value = 1)
	void doSuccessAzureServiceBusProducerTest(String input) throws Exception {

		TestConnectorContext outboundContext = new OutboundConnectorContextBuilder().variables(input).build();

		serviceBusConnector.executeContext(outboundContext);
						
		MockEndpoint.assertIsSatisfied(context);

	}

}