package com.cts.eas.ipm.connector.azureservicebusconnector.inputs.models;

import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.enums.ProducerOperation;

public final class ProducerInputs extends ServiceBusInputs {

    private ProducerOperation producerOperationDefinition;

    private String payload;

    public ProducerOperation getProducerOperationDefinition() {
        return producerOperationDefinition;
    }

    public void setProducerOperationDefinition(ProducerOperation producerOperationDefinition) {
        this.producerOperationDefinition = producerOperationDefinition;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
