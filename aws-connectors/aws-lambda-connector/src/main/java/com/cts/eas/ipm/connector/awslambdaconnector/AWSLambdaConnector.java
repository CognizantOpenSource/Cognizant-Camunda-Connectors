package com.cts.eas.ipm.connector.awslambdaconnector;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.apache.camel.component.aws2.lambda.Lambda2Operations;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.eas.ipm.connector.awslambdaconnector.exception.CustomRuntimeException;
import com.cts.eas.ipm.connector.awslambdaconnector.exception.CustomUnsupportedOperationException;
import com.cts.eas.ipm.connector.awslambdaconnector.inputs.AWSLambdaConnectorInputRequest;
import com.cts.eas.ipm.connector.outbound.CoreOutboundConnector;
import com.cts.eas.ipm.connector.suppliers.ObjectMapperSupplier;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.camunda.connector.api.outbound.OutboundConnectorContext;
import software.amazon.awssdk.services.lambda.model.FunctionConfiguration;
import software.amazon.awssdk.services.lambda.model.ListFunctionsResponse;

public class AWSLambdaConnector implements CoreOutboundConnector {

	private static final Logger LOGGER = LoggerFactory.getLogger(AWSLambdaConnector.class);
	private static final String ROUTEID = "routeId";
	private static final String ROUTETO = "direct:start";
	private final ObjectMapper objectMapper;

	private final CamelContext camelContext;

	public static String getRouteConstant(Lambda2Operations operation) {
		return ROUTETO + operation.toString();
	}

	public static String setRouteId(Lambda2Operations operation) {
		return operation.toString() + ROUTEID;
	}

	public AWSLambdaConnector() {
		super();
		this.camelContext = new DefaultCamelContext();
		this.objectMapper = ObjectMapperSupplier.getMapperInstance();
	}

	public AWSLambdaConnector(CamelContext camelContext) {
		super();
		this.camelContext = camelContext;
		this.objectMapper = ObjectMapperSupplier.getMapperInstance();
	}

	@Override
	public Object executeContext(OutboundConnectorContext context) {
		try {
			Object result = null;
			var input = context.bindVariables(AWSLambdaConnectorInputRequest.class);
			camelContext.start();

			try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
				camelContext.addRoutes(new EndpointRouteBuilder() {
					@Override
					public void configure() throws Exception {
						from(getRouteConstant(input.getInData().getOperationType()))
								.routeId(setRouteId(input.getInData().getOperationType()))
								.to(aws2Lambda(input.getInData().getFunctionName() != null
										? input.getInData().getFunctionName()
										: "").accessKey(input.getAuthentication().getAccessKey())
										.secretKey(input.getAuthentication().getSecretKey())
										.region(input.getAuthentication().getRegion())
										.useDefaultCredentialsProvider(false)
										.operation(input.getInData().getOperationType()));
					}
				});

				switch (input.getInData().getOperationType()) {
				case listFunctions:
					result = listFunctions(producerTemplate, input);
					break;
				case invokeFunction:
					result = invokeFunction(producerTemplate, input);
					break;
				default:
					throw new CustomUnsupportedOperationException("Unsupported Operation");
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}

	private String invokeFunction(ProducerTemplate producerTemplate, AWSLambdaConnectorInputRequest input)
			throws CustomRuntimeException, JsonProcessingException {
		String response = producerTemplate.asyncRequestBody(getRouteConstant(input.getInData().getOperationType()),
				objectMapper.writeValueAsString(input.getInData().getPayload()), String.class).join();
		LOGGER.debug(response);
		return response;

	}

	private List<String> listFunctions(ProducerTemplate producerTemplate, AWSLambdaConnectorInputRequest input)
			throws CustomRuntimeException {
		ListFunctionsResponse response = producerTemplate.asyncRequestBody(
				getRouteConstant(input.getInData().getOperationType()), "", ListFunctionsResponse.class).join();
		response.functions().forEach(function -> LOGGER.debug(function.functionName()));
		return response.functions().stream().map(FunctionConfiguration::functionArn).toList();

	}

}