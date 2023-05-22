package com.cts.eas.ipm.connector.awss3connector;

import java.io.IOException;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.aws2.s3.AWS2S3Component;
import org.apache.camel.component.aws2.s3.AWS2S3Constants;
import org.apache.camel.component.aws2.s3.AWS2S3Operations;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.eas.ipm.connector.outboundConnector.CoreOutboundConnector;
import com.cts.eas.ipm.connector.awss3connector.inputs.AuthenticationRequestData;
import com.cts.eas.ipm.connector.awss3connector.inputs.ConnectorInput;
import com.cts.eas.ipm.connector.awss3connector.inputs.GetObjectOutput;
import com.google.gson.Gson;

import io.camunda.connector.api.outbound.OutboundConnectorContext;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

public class AWSS3Connector implements CoreOutboundConnector {

	private static final Logger LOGGER = LoggerFactory.getLogger(AWSS3Connector.class);
	private static final String CAMEL_ROUTE_DIRECT_AWS2S3 = "direct:aws2s3";

	@Override
	public Object executeContext(OutboundConnectorContext context) {
		var connectorInput = context.getVariablesAsType(ConnectorInput.class);
		context.replaceSecrets(connectorInput);
		return executeConnector(connectorInput);
	}

	private Object executeConnector(ConnectorInput input) {

		// creating camel context to invoke AWS S3
		try {
			CamelContext camelContext = buildContext(input.getAuthentication());
			String aws2s3 = "aws2-s3://" + input.getInData().getBucketName() + "?operation="
					+ input.getInData().getAwsS3Operation();
			camelContext.addRoutes(new RouteBuilder() {

				@Override
				public void configure() throws Exception {
					onException(Exception.class).handled(true).process(new Processor() {
						@Override
						public void process(Exchange exchange) throws Exception {
							Exception exception = (Exception) exchange.getProperty(Exchange.EXCEPTION_CAUGHT);
							LOGGER.error(exception.getMessage());
						}
					}).setBody(constant("error"));

					from(CAMEL_ROUTE_DIRECT_AWS2S3).to(aws2s3);
				}
			});
			camelContext.start();
			Object result = null;
			switch (AWS2S3Operations.valueOf(input.getInData().getAwsS3Operation())) {
			case listObjects:
				result = listObjects(camelContext);
				break;
			case listBuckets:
				result = listBuckets(camelContext);
				break;
			case getObject:
				result = getObject(camelContext, input);
				break;
			default:
				throw new UnsupportedOperationException("Unsupported Operation");
			}
			camelContext.stop();
			camelContext.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed";
		}

	}

	// listObjects AWS S3 Operation
	private Object listObjects(CamelContext camelContext) throws IOException {
		ProducerTemplate template = camelContext.createProducerTemplate();
		Message message = template.send(CAMEL_ROUTE_DIRECT_AWS2S3, ExchangePattern.InOut, (Exchange exchange) -> {
			// No Implementation
		}).getMessage();
		Object response = message.getBody();
		String result = new Gson().toJson(response);
		LOGGER.info("List Objects operation Result: {}", result);
		template.stop();
		template.close();
		return result;
	}

	// listBuckets AWS S3 Operation
	private Object listBuckets(CamelContext camelContext) throws IOException {
		ProducerTemplate template = camelContext.createProducerTemplate();
		Message message = template.send(CAMEL_ROUTE_DIRECT_AWS2S3, ExchangePattern.InOut, (Exchange exchange) -> {
			// No Implementation
		}).getMessage();
		Object response = message.getBody();
		String result = new Gson().toJson(response);
		LOGGER.info("listBuckets Operation Result: {}", result);
		template.stop();
		template.close();
		return result;
	}

	// getObject -only Object Reference AWS S3 Operation
	private Object getObject(CamelContext camelContext, ConnectorInput input) throws IOException {
		ProducerTemplate template = camelContext.createProducerTemplate();
		Message message = template.send(CAMEL_ROUTE_DIRECT_AWS2S3, ExchangePattern.InOut, (Exchange exchange) -> {
			
			exchange.getIn().setHeader(AWS2S3Constants.KEY, input.getInData().getKey());
			
		}).getMessage();
		ResponseInputStream<GetObjectResponse> res1 = (ResponseInputStream) message.getBody();
		GetObjectOutput response = new GetObjectOutput(input.getInData().getKey(), res1.response().contentType(),
				res1.response().eTag(), res1.response().lastModified());
		String result = new Gson().toJson(response);
		LOGGER.info("getObject operation Result: {}", result);
		template.stop();
		template.close();
		return result;

	}

	// AWS S3 Configuration build
	private CamelContext buildContext(AuthenticationRequestData input) {

		CamelContext camelContext = new DefaultCamelContext();
		AWS2S3Component s3 = camelContext.getComponent("aws2-s3", AWS2S3Component.class);

		s3.getConfiguration().setAccessKey(input.getAccessKey());
		s3.getConfiguration().setSecretKey(input.getSecretKey());
		s3.getConfiguration().setRegion(input.getRegion());
		s3.getConfiguration().setUseDefaultCredentialsProvider(false);
		return camelContext;
	}
}
