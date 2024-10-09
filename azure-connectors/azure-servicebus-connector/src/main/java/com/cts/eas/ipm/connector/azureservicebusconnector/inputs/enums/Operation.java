package com.cts.eas.ipm.connector.azureservicebusconnector.inputs.enums;

public enum Operation {
    PRODUCER("producer"),
    CONSUMER("consumer");

    private final String name;

    private Operation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
