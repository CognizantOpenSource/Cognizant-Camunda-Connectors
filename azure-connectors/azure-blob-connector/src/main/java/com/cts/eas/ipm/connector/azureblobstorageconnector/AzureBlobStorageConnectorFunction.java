package com.cts.eas.ipm.connector.azureblobstorageconnector;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azure.storage.blob.models.BlobContainerItem;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.blob.specialized.BlobInputStream;
import com.cts.eas.ipm.connector.azureblobstorageconnector.builder.CustomEndpointRouteBuilder;
import com.cts.eas.ipm.connector.azureblobstorageconnector.inputs.AzureBlobStorageConnectorInput;
import com.cts.eas.ipm.connector.azureblobstorageconnector.inputs.dtos.BlobResponse;
import com.cts.eas.ipm.connector.azureblobstorageconnector.inputs.dtos.Operation;
import com.cts.eas.ipm.connector.outbound.CoreOutboundConnector;

import io.camunda.connector.api.outbound.OutboundConnectorContext;


public class AzureBlobStorageConnectorFunction implements CoreOutboundConnector {

	private static final Logger LOGGER = LoggerFactory.getLogger(AzureBlobStorageConnectorFunction.class);
	private static final String ROUTEID = "routeId";
	private static final String ROUTETO = "direct:start";

	public static String getRouteConstant(Operation operation) {
		return ROUTETO + operation.getOperationValue();
	}

	public static String setRouteId(Operation operation, String... identifiers) {
		return operation.getOperationValue() + identifiers + ROUTEID;
	}

	private final CamelContext camelContext;

	public AzureBlobStorageConnectorFunction() {
		super();
		this.camelContext = new DefaultCamelContext();
	}

	public AzureBlobStorageConnectorFunction(CamelContext camelContext) {
		super();
		this.camelContext = camelContext;
	}

	public Object executeContext(OutboundConnectorContext context) {
		Object result = null;

		try {			
			var input = context.bindVariables(AzureBlobStorageConnectorInput.class);

			camelContext.start();

			result = produceMessages(camelContext, input);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return result;
	}

	private BlobResponse getBlob(CamelContext camelContext, AzureBlobStorageConnectorInput connectorInput)
			throws Exception {

		try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
			camelContext.addRoutes(CustomEndpointRouteBuilder.build(connectorInput,
					String.join("/", connectorInput.getInData().getProducer().getAccountName(),
							connectorInput.getInData().getProducer().getContainerName())));

			BlobInputStream blobInputStream = producerTemplate.asyncRequestBody(
					getRouteConstant(Operation.PRODUCER), "", BlobInputStream.class).join();

			String fileContent = new String(blobInputStream.readAllBytes(), StandardCharsets.UTF_8);
			LOGGER.debug("File Content: \n{}", fileContent);

			return BlobResponse.withResponse(fileContent, blobInputStream.getProperties());
		}
	}

	private BlobContainerItem[] getListOfBlobContainers(CamelContext camelContext,
			AzureBlobStorageConnectorInput connectorInput) throws Exception {

		try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
			camelContext.addRoutes(CustomEndpointRouteBuilder.build(connectorInput,
					connectorInput.getInData().getProducer().getAccountName()));

			BlobContainerItem[] containers = producerTemplate.asyncRequestBody(
					getRouteConstant(Operation.PRODUCER), "", BlobContainerItem[].class).join();

			Arrays.stream(containers).forEach(it -> 
				LOGGER.debug(it.getName())
			);

			return containers;
		}
	}

	private BlobItem[] getListOfBlobs(CamelContext camelContext, AzureBlobStorageConnectorInput connectorInput)
			throws Exception {

		try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
			camelContext.addRoutes(CustomEndpointRouteBuilder.build(connectorInput,
					String.join("/", connectorInput.getInData().getProducer().getAccountName(),
							connectorInput.getInData().getProducer().getContainerName())));

			BlobItem[] blobItems = producerTemplate
					.asyncRequestBody(getRouteConstant(Operation.PRODUCER), "", BlobItem[].class)
					.join();

			Arrays.stream(blobItems).forEach(it -> 
				LOGGER.debug(it.getName())
			);

			return blobItems;
		}
	}	

	private Object produceMessages(CamelContext camelContext, AzureBlobStorageConnectorInput connectorInput)
			throws Exception {
		switch (connectorInput.getInData().getProducer().getBlobOperationsDefinition()) {
		case listBlobContainers:
			return getListOfBlobContainers(camelContext, connectorInput);
		case listBlobs:
			return getListOfBlobs(camelContext, connectorInput);
		case getBlob:
			return getBlob(camelContext, connectorInput);
		case uploadBlockBlob:			
			return uploadBlockBlob(camelContext, connectorInput);
		default:
			throw new UnsupportedOperationException();
		}
	}

	private Object uploadBlockBlob(CamelContext camelContext,
			AzureBlobStorageConnectorInput connectorInput) throws Exception {

		try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {

			camelContext.addRoutes(CustomEndpointRouteBuilder.build(connectorInput,
					String.join("/", connectorInput.getInData().getProducer().getAccountName(),
							connectorInput.getInData().getProducer().getContainerName())));
			
			Object response = producerTemplate.asyncRequestBody(
					getRouteConstant(Operation.PRODUCER),					
							connectorInput.getInData().getProducer().getPayload()).join();
			
			LOGGER.debug("************** {}", response);

			return response;
		}
	}

}
