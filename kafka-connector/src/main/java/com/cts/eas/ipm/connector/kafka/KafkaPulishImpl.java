package com.cts.eas.ipm.connector.kafka;

import java.util.Objects;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.kafka.KafkaComponent;
import org.apache.camel.component.kafka.KafkaConfiguration;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.eas.ipm.connector.constant.Constants;
import com.cts.eas.ipm.connector.input.KafkaPublishInput;
import com.cts.eas.ipm.connector.outboundConnector.CoreOutboundConnector;

import io.camunda.connector.api.outbound.OutboundConnectorContext;

public class KafkaPulishImpl implements CoreOutboundConnector{
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaPulishImpl.class);

	@Override
	public Object executeContext(OutboundConnectorContext connectorContext) {
		
		try (CamelContext context = new DefaultCamelContext();
				ProducerTemplate producer = context.createProducerTemplate();
				KafkaComponent comp = new KafkaComponent()) {
			logger.info("executing kafka publish");
			KafkaPublishInput connectorInput = connectorContext.getVariablesAsType(KafkaPublishInput.class);
			//Validate connector input
			connectorContext.validate(connectorInput);
			
			comp.setConfiguration(new KafkaConfiguration());
			comp.getConfiguration().setBreakOnFirstError(true);
			context.addComponent("kafka", comp);
			
			context.addRoutes(new KafkaRoute(connectorInput.getMessage(), connectorInput.getTopicName(), connectorInput.getHost()));

			context.start();
			
			Exchange ex= null;
			
			producer.start();
			Object obj = producer.requestBody(Constants.KAFKA_PUBLISH_ROUTE, ex);
			
			if(Objects.nonNull(obj)) {
				return Constants.KAFKA_PUBLISH_SUCCESS;
			}
			else {
				return Constants.KAFKA_PUBLISH_FAILED;
			}
		}
		catch (Exception e) {
			logger.info("kafka message publish failed with error:"+e.getMessage());
			return Constants.KAFKA_PUBLISH_FAILED_ERROR+e.getMessage();
		}
	}
}
