package com.cts.eas.ipm.connector.azureservicebusconnector.inputs;


import com.cts.eas.ipm.connector.suppliers.ObjectMapperSupplier;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.camunda.connector.api.inbound.CorrelationResult;
import io.camunda.connector.api.inbound.InboundConnectorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceBusResponse {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceBusResponse.class);
    private static final ServiceBusResponse serviceBusResponse = new ServiceBusResponse();
    private Object response;
    private InboundConnectorContext inboundConnectorContext;

    private ServiceBusResponse() {
    }

    public static ServiceBusResponse withResponse(Object response) {
        serviceBusResponse.response = response;
        return serviceBusResponse;
    }

    public static ServiceBusResponse withInboundConnectorContext(InboundConnectorContext inboundConnectorContext) {
        serviceBusResponse.inboundConnectorContext = inboundConnectorContext;
        return serviceBusResponse;
    }

    public void correlateMessage(String response) throws JsonProcessingException {
        ObjectMapper objectMapper = ObjectMapperSupplier.getCopy();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Response from consumer: {}", withResponse(response));
        }
        switch (this.inboundConnectorContext.correlateWithResult(ObjectMapperSupplier.convertToObj(objectMapper.writeValueAsString(withResponse(response))))) {
            case CorrelationResult.Success success -> {
                LOGGER.debug("Message correlated successfully: {}", success);
            }
            case CorrelationResult.Failure failure -> {
                LOGGER.debug("Message not correlated, reason: {}.", failure);
            }
        }
    }

    public Object getResponse() {
        return response;
    }
}