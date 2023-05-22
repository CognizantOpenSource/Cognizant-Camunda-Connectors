package com.cts.eas.ipm.connector.outboundConnector;

import io.camunda.connector.api.outbound.OutboundConnectorContext;

public interface CoreOutboundConnector {	
	public Object executeContext(OutboundConnectorContext context);
}
