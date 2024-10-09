package com.cts.eas.ipm.connector.inbound;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.eas.ipm.connector.inbound.util.ConnectorInboundInput;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;

import io.camunda.connector.api.annotation.InboundConnector;
import io.camunda.connector.api.inbound.InboundConnectorContext;
import io.camunda.connector.api.inbound.InboundConnectorExecutable;


@InboundConnector(
		name = "CustomGcpSubscribeInboundConnector",
		type = "inbound-gcpsub-connector:1"
)
public class GCPSubscriberExecutable implements InboundConnectorExecutable<InboundConnectorContext>{
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(GCPSubscriberExecutable.class);
	 private InboundConnectorContext context;
	 

	@Override
	public void activate(InboundConnectorContext connectorContext) throws Exception {
		// TODO Auto-generated method stub
		 this.context = connectorContext;
		 

		try{
		LOGGER.debug(" Inbound Input Variables -> {} " , context.getProperties());	
		
		 var input = context.bindProperties(ConnectorInboundInput.class);
		
		 subscribe(input, context);
	       // consumeMessages(camelContext, context, input);	
		}	
		catch(Exception e){
			
			LOGGER.info("GCPSubscriberExecutable   activate Exception >>>>>>>>>>>>     "+e.getMessage());
			connectorContext.correlateWithResult("Failed"+"==>"+e.getMessage());
		}
		
	}
	
	private  void subscribe(ConnectorInboundInput input,InboundConnectorContext context)throws Exception  {
		
		Subscriber subscriber =null ;

		ProjectSubscriptionName subscriptionName = ProjectSubscriptionName.of(input.getProjectId(),
				input.getSubscriptionId());
		 
		Map<String,String> response=new HashMap<String,String>();
		try {
			GoogleCredentials credentials;
			String credentialsPath = input.getServiceAccountKey();
			LOGGER.info(" GCPSubscriberExecutable    START");
			
			credentials = GoogleCredentials.fromStream( new FileInputStream(credentialsPath));
			// Instantiate an asynchronous message receiver.
			MessageReceiver receiver = (PubsubMessage message, AckReplyConsumer consumer) -> {
				// Handle incoming message, then ack the received message.
				response.put(message.getMessageId(), message.getData().toStringUtf8());
				consumer.ack();
			};
			subscriber = Subscriber.newBuilder(subscriptionName, receiver).setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build();
			subscriber.startAsync().awaitRunning();
			Thread.sleep(Integer.parseInt(input.getPollingWaitTime()));
		//	LOGGER.info(" GCPSubscriberExecutable     Thread sleep : "+ Integer.parseInt(input.getPollingWaitTime()) +" :Completed");
			context.correlateWithResult(response);
			LOGGER.debug(" GCPSubscriberExecutable Inbound out Variables -> {} " , response);
			LOGGER.info(" GCPSubscriberExecutable    END");
		} 
		finally {
			if(null!=subscriber)
			subscriber.stopAsync();
		}
		
	}
	

	@Override
	public void deactivate() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
