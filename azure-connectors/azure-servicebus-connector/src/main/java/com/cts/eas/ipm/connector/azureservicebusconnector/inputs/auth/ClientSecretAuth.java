package com.cts.eas.ipm.connector.azureservicebusconnector.inputs.auth;

import com.azure.core.credential.TokenCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.ServiceBusRequest;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.models.ConsumerInputs;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.models.ProducerInputs;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.builder.endpoint.StaticEndpointBuilders;
import org.apache.camel.component.azure.servicebus.CredentialType;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.azureServicebus;

public final class ClientSecretAuth extends Authentication {

    private TokenCredential tokenCredential;
    private String clientId;
    private String tenantId;
    private String clientSecretId;
    private String fullyQualifiedNamespace;

    public TokenCredential getTokenCredential() {
        return tokenCredential;
    }

    public void setTokenCredential(TokenCredential tokenCredential) {
        this.tokenCredential = tokenCredential;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getClientSecretId() {
        return clientSecretId;
    }

    public void setClientSecretId(String clientSecretId) {
        this.clientSecretId = clientSecretId;
    }

    @Override
    public Endpoint getEndpoint(ServiceBusRequest serviceBusRequest, CamelContext camelContext) {

        tokenCredential = new ClientSecretCredentialBuilder()
                .clientSecret(getClientSecretId())
                .clientId(getClientId())
                .tenantId(getTenantId())
                .build();
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