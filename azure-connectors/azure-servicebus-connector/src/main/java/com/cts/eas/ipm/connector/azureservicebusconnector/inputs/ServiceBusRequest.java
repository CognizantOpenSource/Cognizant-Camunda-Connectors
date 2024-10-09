package com.cts.eas.ipm.connector.azureservicebusconnector.inputs;


import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.auth.Authentication;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.models.ServiceBusInputs;

public class ServiceBusRequest {

    private ServiceBusInputs inData;
    private Authentication authentication;

    public ServiceBusInputs getInData() {
        return inData;
    }

    public void setInData(ServiceBusInputs inData) {
        this.inData = inData;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }
}