package com.cts.eas.ipm.connector.azureblobstorageconnector.builder;

import org.apache.camel.builder.endpoint.EndpointRouteBuilder;

import com.azure.storage.blob.models.BlockListType;
import com.cts.eas.ipm.connector.azureblobstorageconnector.AzureBlobStorageConnectorFunction;
import com.cts.eas.ipm.connector.azureblobstorageconnector.exceptions.AzureConnectorException;
import com.cts.eas.ipm.connector.azureblobstorageconnector.inputs.AzureBlobStorageConnectorInput;
import com.cts.eas.ipm.connector.azureblobstorageconnector.inputs.dtos.Operation;

public class CustomEndpointRouteBuilder extends EndpointRouteBuilder{
	
	final AzureBlobStorageConnectorInput connectorInput;
	
	final String path;
	
	private CustomEndpointRouteBuilder(AzureBlobStorageConnectorInput connectorInput, String path){
		this.connectorInput = connectorInput;
		this.path = path;
	}
	
	public static CustomEndpointRouteBuilder build(AzureBlobStorageConnectorInput connectorInput, String path) {
		return new CustomEndpointRouteBuilder(connectorInput, path);
	}
	
	@Override
	public void configure() throws AzureConnectorException {		
		from(AzureBlobStorageConnectorFunction.getRouteConstant(Operation.PRODUCER))
		.routeId(AzureBlobStorageConnectorFunction.setRouteId(Operation.PRODUCER,
				connectorInput.getInData().getProducer().getBlobOperationsDefinition().name()))
		.to(azureStorageBlob(path).blockListType(BlockListType.ALL)
				.credentialType(connectorInput.getAuthentication().getCredentialType())
				.operation(connectorInput.getInData().getProducer().getBlobOperationsDefinition())
				.blobName(connectorInput.getInData().getProducer().getBlobName())
				.accessKey(connectorInput.getAuthentication().getAccessKey()));
	}
}
