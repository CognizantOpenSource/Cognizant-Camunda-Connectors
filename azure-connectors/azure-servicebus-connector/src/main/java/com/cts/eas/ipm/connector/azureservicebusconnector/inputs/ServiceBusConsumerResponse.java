package com.cts.eas.ipm.connector.azureservicebusconnector.inputs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import io.camunda.connector.api.inbound.InboundConnectorContext;
import io.camunda.connector.api.inbound.InboundConnectorResult;

public class ServiceBusConsumerResponse {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceBusConsumerResponse.class);
	private String value;
	private InboundConnectorContext inboundConnectorContext;

	ServiceBusConsumerResponse(String value) {
		this.value = value;
	}

	ServiceBusConsumerResponse() {
		this.value = null;
	}

	public ServiceBusConsumerResponse(InboundConnectorContext inboundConnectorContext) {
		this.inboundConnectorContext = inboundConnectorContext;
	}

	public static ServiceBusConsumerResponse withResponse(String response) {
		return new ServiceBusConsumerResponse(response);
	}

	public void correlateMessage(String response) {

		LOGGER.debug("Response from consumer: {}", ServiceBusConsumerResponse.withResponse(response));
		InboundConnectorResult<?> correlate = this.inboundConnectorContext
				.correlate(ServiceBusConsumerResponse.withResponse(response));

		if (correlate.isActivated()) {
			LOGGER.debug("Inbound event correlated successfully: {}", correlate.getResponseData());
		} else {
			LOGGER.debug("Inbound event correlated but not activated: {}", correlate.getErrorData());
		}
	}

	public String getValue() {
		return value;
	}

}

