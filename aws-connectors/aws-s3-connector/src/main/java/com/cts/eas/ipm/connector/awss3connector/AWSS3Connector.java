package com.cts.eas.ipm.connector.awss3connector;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.apache.camel.component.aws2.s3.AWS2S3Constants;
import org.apache.camel.component.aws2.s3.AWS2S3Operations;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.eas.ipm.connector.awss3connector.inputs.ConnectorInput;
import com.cts.eas.ipm.connector.awss3connector.inputs.GetObjectOutput;
import com.cts.eas.ipm.connector.outbound.CoreOutboundConnector;

import io.camunda.connector.api.outbound.OutboundConnectorContext;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

public class AWSS3Connector implements CoreOutboundConnector {

	private static final Logger LOGGER = LoggerFactory.getLogger(AWSS3Connector.class);
	private static final String ROUTEID = "routeId";
	private static final String ROUTETO = "direct:start";

	private final CamelContext camelContext;

	public static String getRouteConstant(AWS2S3Operations operation) {
		return ROUTETO + operation.toString();
	}

	public static String setRouteId(AWS2S3Operations operation) {
		return operation.toString() + ROUTEID;
	}

	public AWSS3Connector() {
		super();
		this.camelContext = new DefaultCamelContext();
	}

	public AWSS3Connector(CamelContext camelContext) {
		super();
		this.camelContext = camelContext;
	}

	@Override
	public Object executeContext(OutboundConnectorContext context) {
		try {
			Object result = null;
			var input = context.bindVariables(ConnectorInput.class);
			camelContext.start();

			try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
				camelContext.addRoutes(new EndpointRouteBuilder() {
					@Override
					public void configure() throws Exception {
						from(getRouteConstant(input.getInData().getAwsS3Operation()))
								.routeId(setRouteId(input.getInData().getAwsS3Operation()))
								.to(aws2S3(input.getInData().getBucketName() != null ? input.getInData().getBucketName()
										: "").accessKey(input.getAuthentication().getAccessKey())
										.secretKey(input.getAuthentication().getSecretKey())
										.region(input.getAuthentication().getRegion())
										.useDefaultCredentialsProvider(false)
										.operation(input.getInData().getAwsS3Operation()));
					}
				});

				switch (input.getInData().getAwsS3Operation()) {
				case listObjects:
					result = listObjects(producerTemplate, input);
					break;
				case listBuckets:
					result = listBuckets(producerTemplate, input);
					break;
				case getObject:
					result = getObject(producerTemplate, input);
					break;
				default:
					throw new UnsupportedOperationException("Unsupported Operation");
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed";
		}

	}

	// listObjects AWS S3 Operation
	private Object listObjects(ProducerTemplate producerTemplate, ConnectorInput input) {
		Message message = producerTemplate
				.send(getRouteConstant(input.getInData().getAwsS3Operation()), (Exchange exchange) -> {
					// No Implementation
				}).getMessage();
		Object response = message.getBody();
		String result = String.valueOf(response);
		LOGGER.info("List Objects operation Result: {}", result);
		return result;
	}

	// listBuckets AWS S3 Operation
	private Object listBuckets(ProducerTemplate producerTemplate, ConnectorInput input) {
		Message message = producerTemplate
				.send(getRouteConstant(input.getInData().getAwsS3Operation()), (Exchange exchange) -> {
					// No Implementation
				}).getMessage();
		Object response = message.getBody();
		String result = String.valueOf(response);
		LOGGER.info("listBuckets Operation Result: {}", result);
		return result;
	}

	// getObject -only Object Reference AWS S3 Operation
	private Object getObject(ProducerTemplate producerTemplate, ConnectorInput input) {
		Message message = producerTemplate
				.send(getRouteConstant(input.getInData().getAwsS3Operation()), (Exchange exchange) -> {
					exchange.getIn().setHeader(AWS2S3Constants.KEY, input.getInData().getKey());
				}).getMessage();
		ResponseInputStream<GetObjectResponse> res1 = (ResponseInputStream) message.getBody();
		GetObjectOutput response = new GetObjectOutput(input.getInData().getKey(), res1.response().contentType(),
				res1.response().eTag(), res1.response().lastModified());
		String result = String.valueOf(response);
		LOGGER.info("getObject operation Result: {}", result);
		return result;

	}

}
