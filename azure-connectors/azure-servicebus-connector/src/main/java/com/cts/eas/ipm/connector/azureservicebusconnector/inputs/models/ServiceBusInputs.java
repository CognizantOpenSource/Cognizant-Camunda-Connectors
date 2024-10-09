package com.cts.eas.ipm.connector.azureservicebusconnector.inputs.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.camel.component.azure.servicebus.ServiceBusType;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ConsumerInputs.class, name = "consumer"),
        @JsonSubTypes.Type(value = ProducerInputs.class, name = "producer")

})
public sealed abstract class ServiceBusInputs permits ConsumerInputs, ProducerInputs {
    private String queueName;
    private ServiceBusType serviceBusType;

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public ServiceBusType getServiceBusType() {
        return serviceBusType;
    }

    public void setServiceBusType(ServiceBusType serviceBusType) {
        this.serviceBusType = serviceBusType;
    }
}
