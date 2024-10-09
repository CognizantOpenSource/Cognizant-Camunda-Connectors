package com.cts.eas.ipm.connector.azureservicebusconnector.inputs.models;

import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.enums.ConsumerOperation;


public final class ConsumerInputs extends ServiceBusInputs {
    private ConsumerOperation consumerOperationDefinition;
    private Long pollingWaitTime;
    private String activationCondition;

    public ConsumerOperation getConsumerOperationDefinition() {
        return consumerOperationDefinition;
    }

    public void setConsumerOperationDefinition(ConsumerOperation consumerOperationDefinition) {
        this.consumerOperationDefinition = consumerOperationDefinition;
    }

    public Long getPollingWaitTime() {
        return pollingWaitTime;
    }

    public void setPollingWaitTime(Long pollingWaitTime) {
        this.pollingWaitTime = pollingWaitTime;
    }

    public String getActivationCondition() {
        return activationCondition;
    }

    public void setActivationCondition(String activationCondition) {
        this.activationCondition = activationCondition;
    }
}
