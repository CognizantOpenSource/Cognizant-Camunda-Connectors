package com.cts.eas.ipm.connector.gcp.outbound;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.eas.ipm.connector.gcp.input.GCPPubConnectorInput;
import com.cts.eas.ipm.connector.outbound.CoreOutboundConnector;
import com.google.api.core.ApiFuture;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;

import io.camunda.connector.api.outbound.OutboundConnectorContext;


public class GCPPubConnector implements CoreOutboundConnector {

	private static final Logger LOGGER = LoggerFactory.getLogger(GCPPubConnector.class);
	 @Override
	public Object executeContext(OutboundConnectorContext context) {
		 
		 var input = context.bindVariables(GCPPubConnectorInput.class);
		return executeConnector(input);
	}

	private Object executeConnector(GCPPubConnectorInput input) {
		Object result =null;
        try {
        	result =publish(input);
        }
       
		catch(Exception ex) {
			return ex.getMessage();
		}
        
        
		return result;

	}

	private static Object publish(GCPPubConnectorInput input) throws Exception   {

		TopicName topicName = TopicName.of(input.getInData().getProjectId(), input.getInData().getTopicName());
		Publisher publisher = null;

		String messageId = null;

		try {
			GoogleCredentials credentials;
			String credentialsPath = input.getInData().getServiceAccountKey();
			
			
			credentials = GoogleCredentials.fromStream( new FileInputStream(credentialsPath)); 
					
			
			// Create a publisher instance with default settings bound to the topic
			publisher = Publisher.newBuilder(topicName)
					.setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build();
			
			ByteString data = ByteString.copyFromUtf8(input.getInData().getMessage());
			PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();

			// Once published, returns a server-assigned message id (unique within the
			// topic)
			ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
			messageId = messageIdFuture.get();
			//return messageId;
		} 
		
		finally {
			if (null != publisher) {
				publisher.shutdown();
				publisher.awaitTermination(1, TimeUnit.MINUTES);
			}
			
		}

		return messageId;
	}
  
	

}
