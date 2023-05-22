package com.cts.eas.ipm.connector.awslambdaconnector;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.aws2.lambda.Lambda2Component;
import org.apache.camel.component.aws2.lambda.Lambda2Operations;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.eas.ipm.connector.awslambdaconnector.exception.CustomRuntimeException;
import com.cts.eas.ipm.connector.awslambdaconnector.exception.CustomUnsupportedOperationException;
import com.cts.eas.ipm.connector.awslambdaconnector.inputs.AWSLambdaConnectorInput;
import com.cts.eas.ipm.connector.awslambdaconnector.inputs.AWSLambdaConnectorOutput;
import com.cts.eas.ipm.connector.awslambdaconnector.inputs.AuthenticationRequestData;
import com.cts.eas.ipm.connector.awslambdaconnector.inputs.ConnectorInput;
import com.cts.eas.ipm.connector.outboundConnector.CoreOutboundConnector;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import io.camunda.connector.api.outbound.OutboundConnectorContext;
import software.amazon.awssdk.services.lambda.model.FunctionConfiguration;
import software.amazon.awssdk.services.lambda.model.ListFunctionsResponse;

public class AWSLambdaConnector implements CoreOutboundConnector {
	private static final Logger LOGGER = LoggerFactory.getLogger(AWSLambdaConnector.class);
	private static final Gson gson = new Gson();
	private static final String INITIATE_VALUE = "direct:initiateAWSLambdaCall";

	@Override
	public Object executeContext(OutboundConnectorContext context) {
		try {
			Object result = null;
			var input = context.getVariablesAsType(ConnectorInput.class);
			context.validate(input);
			context.replaceSecrets(input);

			CamelContext camelContext = buildContext(input.getAuthentication());
			switch (Lambda2Operations.valueOf(input.getInData().getOperationType())) {
			case listFunctions:
				result = listFunctions(camelContext, input.getInData());
				break;
			case invokeFunction:
				result = invokeFunction(camelContext, input.getInData());
				break;
			default:
				throw new CustomUnsupportedOperationException("Unsupported Operation");
			}
			camelContext.close();
			camelContext.stop();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}

	private Object invokeFunction(CamelContext camelContext, AWSLambdaConnectorInput input) {
		ProducerTemplate template = addRoutesToContext.andThen(startContext).apply(
				"aws2-lambda://" + input.getFunctionName() + "?operation=" + input.getOperationType(), camelContext);
		template.start();
		Message message = template.send(INITIATE_VALUE, ExchangePattern.InOut, (Exchange exchange) -> {
			exchange.getIn().setBody(gson.toJson(input.getPayload()));
		}).getMessage();
		template.stop();
		String response = (String) message.getBody();
		LOGGER.info("Result : {}", response);
		return new AWSLambdaConnectorOutput(response);
	}

	private Object listFunctions(CamelContext camelContext, AWSLambdaConnectorInput input) {
		ProducerTemplate template = addRoutesToContext.andThen(startContext)
				.apply("aws2-lambda://?operation=" + input.getOperationType(), camelContext);
		template.start();
		Message message = template.send(INITIATE_VALUE, ExchangePattern.InOut, (Exchange exchange) -> {
		}).getMessage();
		template.stop();
		ListFunctionsResponse response = (ListFunctionsResponse) message.getBody();
		return response.functions().stream().map(FunctionConfiguration::functionName)
				.collect(Collectors.toUnmodifiableList());

	}

	private CamelContext buildContext(AuthenticationRequestData input) {
		CamelContext camelContext = new DefaultCamelContext();
		Lambda2Component lambda = camelContext.getComponent("aws2-lambda", Lambda2Component.class);

		lambda.getConfiguration().setAccessKey(input.getAccessKey());
		lambda.getConfiguration().setSecretKey(input.getSecretKey());
		lambda.getConfiguration().setRegion(input.getRegion());
		lambda.getConfiguration().setUseDefaultCredentialsProvider(false);
		return camelContext;
	}

	protected BiFunction<String, CamelContext, CamelContext> addRoutesToContext = (toAddress, context) -> {
		try {
			context.addRoutes(new RouteBuilder() {
				@Override
				public void configure() throws Exception {
					onException(Exception.class).handled(true).process(new Processor() {
						@Override
						public void process(Exchange exchange) throws Exception {
							Exception exception = (Exception) exchange.getProperty(Exchange.EXCEPTION_CAUGHT);
							LOGGER.error(exception.getMessage());
						}
					}).log("Error").end();

					from(INITIATE_VALUE).to(toAddress);
				}
			});
			return context;
		} catch (Exception e) {
			throw new CustomRuntimeException("Unable build camel context. Please refer trace for more information", e);
		}
	};

	protected Function<CamelContext, ProducerTemplate> startContext = context -> {
		context.start();
		return context.createProducerTemplate();
	};

}