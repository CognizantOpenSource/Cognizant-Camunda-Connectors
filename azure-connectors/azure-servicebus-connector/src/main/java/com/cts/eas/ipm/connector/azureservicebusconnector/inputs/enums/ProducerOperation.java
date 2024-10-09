package com.cts.eas.ipm.connector.azureservicebusconnector.inputs.enums;

public enum ProducerOperation {
    sendMessages("sendMessages"),
    scheduleMessages("scheduleMessages");

    private final String producerOperationType;

    ProducerOperation(String producerOperationType) {
        this.producerOperationType = producerOperationType;
    }

    public String getProducerOperationType() {
        return producerOperationType;
    }
}
