package com.cts.eas.ipm.connector.camelRoute;

import java.util.Objects;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

import com.cts.eas.ipm.connector.constant.Constants;
import com.cts.eas.ipm.connector.input.FTPInput;
import com.cts.eas.ipm.connector.outboundConnector.CoreOutboundConnector;

import io.camunda.connector.api.outbound.OutboundConnectorContext;

public class FTPConnectorImpl implements CoreOutboundConnector{

	@Override
	public Object executeContext(OutboundConnectorContext connectorContext)  {
		
		try (CamelContext context = new DefaultCamelContext();
				ProducerTemplate producer = context.createProducerTemplate()) {
			var input = connectorContext.getVariablesAsType(FTPInput.class);
			// Validate connector input
			connectorContext.validate(input);
			
			if (input.getOperationMode().equalsIgnoreCase(Constants.PRODUCER_CONSTANT)) {
				context.addRoutes(new FTPProducerRoute(input.getHost(), input.getUserName(), input.getPassword(),
						input.getFilePath(), input.getDirectoryName(), input.getProtocol(), input.getOperationMode()));
				context.start();
				Exchange ex = null;
				producer.start();
				Object obj = producer.requestBody(Constants.FTP_PRODUCER_DIRECT, ex);
				
				if (Objects.nonNull(obj)) {
					return Constants.FTP_PRODUCE_SUCCESS;
				} else {
					return Constants.FTP_PRODUCE_FAILED;
				}
			} else {
				// Creating camel context to invoke it
				context.addRoutes(new FTPConsumerRoute(input.getHost(), input.getUserName(), input.getPassword(),
						input.getFilePath(), input.getDirectoryName(), input.getProtocol(), input.getOperationMode()));
				context.start();
				Exchange ex = null;
				producer.start();
				Object obj = producer.requestBody(Constants.FTP_CONSUMER_DIRECT, ex);
				if (Objects.nonNull(obj)) {
					return Constants.FTP_CONSUME_SUCCESS;
				} else {
					return Constants.FTP_PRODUCE_FAILED;
				}
			}
		} catch (Exception e) {
			return Constants.FTP_OPS_FAILED_ERROR + e.getMessage();
		}
	}
}
