package com.cts.eas.ipm.connector.azureservicebusconnector.inputs.auth;


import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.ServiceBusRequest;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.models.ConsumerInputs;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.models.ProducerInputs;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.builder.endpoint.StaticEndpointBuilders;
import org.apache.camel.component.azure.servicebus.CredentialType;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.azureServicebus;

public final class ConnectionStringAuth extends Authentication {
    private String connectionString;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    public Endpoint getEndpoint(ServiceBusRequest serviceBusRequest, CamelContext camelContext) {
        if (serviceBusRequest.getInData() instanceof ConsumerInputs consumerInputs) {
            return StaticEndpointBuilders.azureServicebus(consumerInputs.getQueueName())
                    .connectionString(this.getConnectionString())
                    .serviceBusReceiveMode(consumerInputs.getConsumerOperationDefinition().getConsumerOperationType())
                    .credentialType(CredentialType.CONNECTION_STRING)
                    .resolve(camelContext);
        } else if (serviceBusRequest.getInData() instanceof ProducerInputs producerInputs) {
            return azureServicebus(producerInputs.getQueueName())
                    .producerOperation(producerInputs.getProducerOperationDefinition().getProducerOperationType())
                    .serviceBusType(producerInputs.getServiceBusType())
                    .credentialType(CredentialType.CONNECTION_STRING)
                    .connectionString(this.connectionString)
                    .resolve(camelContext);
        }
        throw new UnsupportedOperationException("Please recheck the inputs");


    }
}