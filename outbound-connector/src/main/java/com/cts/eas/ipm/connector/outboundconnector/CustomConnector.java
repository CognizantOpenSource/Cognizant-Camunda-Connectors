package com.cts.eas.ipm.connector.outboundconnector;

import java.util.ServiceLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.eas.ipm.connector.outboundConnector.CoreOutboundConnector;
import com.cts.eas.ipm.connector.outboundConnector.inputs.ConnectorInput;
import com.cts.eas.ipm.connector.outboundconnector.response.ConnectorResponse;

import io.camunda.connector.api.annotation.OutboundConnector;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.api.outbound.OutboundConnectorFunction;

@OutboundConnector(name = "CustomConnector", inputVariables = { "connectorId", "inData", "authentication", "message",
		"topicName", "host" }, type = "outbound-connector")
public class CustomConnector implements OutboundConnectorFunction {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomConnector.class);

	@Override
	public Object execute(OutboundConnectorContext context) throws Exception {
		LOGGER.info(context.getVariables());
		var result = ConnectorResponse.initialize();
		var input = context.getVariablesAsType(ConnectorInput.class);
		ServiceLoader.load(CoreOutboundConnector.class)
					 .stream()
					 .filter(it -> it.type().getSimpleName().equals(input.getConnectorId())).findAny()
					 .ifPresent(connector -> {
						 ConnectorResponse.build(result, connector.get().executeContext(context));
					 });

		LOGGER.info("Result: {}", ConnectorResponse.send(result));
		return ConnectorResponse.send(result);
	}

}
