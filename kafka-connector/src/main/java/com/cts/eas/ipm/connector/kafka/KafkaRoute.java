package com.cts.eas.ipm.connector.kafka;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;

public class KafkaRoute extends RouteBuilder{
	
	private String message;
	private String topicName;
	private String host;
	
	public KafkaRoute(String message, String topicName, String host) {
		this.message = message;
		this.topicName = topicName;
		this.host = host;
	}
	
	@Override
	public void configure() throws Exception {
		from("direct:kafka_publish")
		.setBody(constant(message))
		.setHeader(KafkaConstants.KEY, constant("Camel"))
		.to(new StringBuilder().append("kafka:")
				.append(topicName)
				.append("?brokers=")
				.append(host).toString())
				.stop();
	}
	
	
}
