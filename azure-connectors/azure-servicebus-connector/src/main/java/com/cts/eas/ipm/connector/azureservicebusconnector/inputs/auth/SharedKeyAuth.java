package com.cts.eas.ipm.connector.azureservicebusconnector.inputs.auth;

import com.azure.core.credential.TokenCredential;
import com.azure.messaging.servicebus.implementation.ServiceBusSharedKeyCredential;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.ServiceBusRequest;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.models.ConsumerInputs;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.models.ProducerInputs;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.builder.endpoint.StaticEndpointBuilders;
import org.apache.camel.component.azure.servicebus.CredentialType;

import java.time.Duration;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.azureServicebus;

public final class SharedKeyAuth extends Authentication {

    private TokenCredential tokenCredential;

    private String policyName;
    private String sharedAccessKey;
    private Duration tokenValidity;
    private String fullyQualifiedNamespace;

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getSharedAccessKey() {
        return sharedAccessKey;
    }

    public void setSharedAccessKey(String sharedAccessKey) {
        this.sharedAccessKey = sharedAccessKey;
    }

    public Duration getTokenValidity() {
        return tokenValidity;
    }

    public void setTokenValidity(Duration tokenValidity) {
        this.tokenValidity = tokenValidity;
    }

    @Override
    public Endpoint getEndpoint(ServiceBusRequest serviceBusRequest, CamelContext camelContext) {
        if (this.getTokenValidity().isZero() || this.getTokenValidity().isNegative()) {
            tokenCredential = new ServiceBusSharedKeyCredential(policyName, sharedAccessKey);
        } else {
            tokenCredential = new ServiceBusSharedKeyCredential(policyName, sharedAccessKey, tokenValidity);
        }

        if (serviceBusRequest.getInData() instanceof ConsumerInputs consumerInputs) {
            return StaticEndpointBuilders.azureServicebus(consumerInputs.getQueueName())
                    .tokenCredential(tokenCredential).fullyQualifiedNamespace(this.getFullyQualifiedNamespace())
                    .serviceBusReceiveMode(consumerInputs.getConsumerOperationDefinition().getConsumerOperationType())
                    .credentialType(CredentialType.TOKEN_CREDENTIAL)
                    .resolve(camelContext);
        } else if (serviceBusRequest.getInData() instanceof ProducerInputs producerInputs) {

            return azureServicebus(producerInputs.getQueueName())
                    .producerOperation(producerInputs.getProducerOperationDefinition().getProducerOperationType())
                    .serviceBusType(producerInputs.getServiceBusType())
                    .tokenCredential(tokenCredential).fullyQualifiedNamespace(this.getFullyQualifiedNamespace())
                    .resolve(camelContext);

        }
        throw new UnsupportedOperationException("Please recheck the inputs");

    }

    public String getFullyQualifiedNamespace() {
        return fullyQualifiedNamespace;
    }

    public void setFullyQualifiedNamespace(String fullyQualifiedNamespace) {
        this.fullyQualifiedNamespace = fullyQualifiedNamespace;
    }
}