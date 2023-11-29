package com.cts.eas.ipm.connector.azureservicebusconnector.outbound;

import java.util.concurrent.CompletableFuture;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.AzureServiceBusConnectorInput;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.dtos.Operation;
import com.cts.eas.ipm.connector.outbound.CoreOutboundConnector;

import io.camunda.connector.api.outbound.OutboundConnectorContext;

public class AzureServiceBusConnectorFunction implements CoreOutboundConnector {

	private static final Logger LOGGER = LoggerFactory.getLogger(AzureServiceBusConnectorFunction.class);
	private static final String ROUTEID = "routeId";
	private static final String ROUTETO = "direct:start";	

	private final CamelContext camelContext;

	public AzureServiceBusConnectorFunction() {

		super();		
		this.camelContext = new DefaultCamelContext();

	}

	public AzureServiceBusConnectorFunction(CamelContext camelContext) {

		super();		
		this.camelContext = camelContext;

	}

	public Object executeContext(OutboundConnectorContext context) {

		Object result = null;
		
		var input = context.bindVariables(AzureServiceBusConnectorInput.class);
		
		try {

			camelContext.start();

			result = produceMessages(camelContext, input);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	private Object produceMessages(CamelContext camelContext, AzureServiceBusConnectorInput connectorInput) throws Exception {

		try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {

			camelContext.addRoutes(new EndpointRouteBuilder() {

				@Override
				public void configure() throws Exception {

					from(getRouteConstant(Operation.PRODUCER))
							.routeId(setRouteId(Operation.PRODUCER))
							.to(azureServicebus(connectorInput.getInData().getCommonInputs().getQueueName())
									.producerOperation(
											connectorInput.getInData().getProducer().getProducerOperationDefinition())
									.serviceBusType(connectorInput.getInData().getCommonInputs().getServiceBusType())
									.connectionString(connectorInput.getAuthentication().getConnectionString()));

				}
			});

			
			CompletableFuture<Object> response = producerTemplate.asyncRequestBody(
					getRouteConstant(Operation.PRODUCER),
					connectorInput.getInData().getProducer().getPayload());

			return response.join();

		}

	}

	public static String getRouteConstant(Operation operation) {
		return ROUTETO + operation.getOperationValue();
	}

	public static String setRouteId(Operation operation) {
		return operation.getOperationValue() + ROUTEID;
	}	

}
