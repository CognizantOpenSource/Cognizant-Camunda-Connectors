package com.cts.eas.ipm.connector.azureservicebusconnector.inputs.enums;

public enum ConsumerOperation {

    peekMessages("PEEK_LOCK"),
    receiveMessages("RECEIVE_AND_DELETE");

    private final String consumerOperationType;

    private ConsumerOperation(String consumerOperationType) {
        this.consumerOperationType = consumerOperationType;
    }

    public String getConsumerOperationType() {
        return consumerOperationType;
    }
}
