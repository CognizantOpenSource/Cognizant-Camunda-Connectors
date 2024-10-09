package com.cts.eas.ipm.connector.azureservicebusconnector.outbound;

import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.ServiceBusRequest;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.enums.Operation;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.models.ProducerInputs;
import com.cts.eas.ipm.connector.outbound.CoreOutboundConnector;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

import static com.cts.eas.ipm.connector.azureservicebusconnector.inputs.enums.Operation.PRODUCER;

public class AzureServiceBusConnectorFunction implements CoreOutboundConnector {

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureServiceBusConnectorFunction.class);
    private static final String ROUTEID = "routeId";
    private static final String ROUTETO = "direct:start";

    private final CamelContext camelContext;

    public AzureServiceBusConnectorFunction() {

        super();
        this.camelContext = new DefaultCamelContext();

    }

    public AzureServiceBusConnectorFunction(CamelContext camelContext) {

        super();
        this.camelContext = camelContext;

    }

    public static String getRouteConstant(Operation operation) {
        return ROUTETO + operation.getName();
    }

    public static String setRouteId(Operation operation) {
        return operation.getName() + ROUTEID;
    }

    public Object executeContext(OutboundConnectorContext context) {

        Object result = null;

        var input = context.bindVariables(ServiceBusRequest.class);

        try {

            camelContext.start();

            result = produceMessages(camelContext, input);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return result;
    }

    private Object produceMessages(CamelContext camelContext, ServiceBusRequest serviceBusRequest) throws Exception {
        CompletableFuture<Object> response = null;

        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            Endpoint endpoint = serviceBusRequest.getAuthentication().getEndpoint(serviceBusRequest, camelContext);
            camelContext.addRoutes(new EndpointRouteBuilder() {

                @Override
                public void configure() throws Exception {

                    from(getRouteConstant(PRODUCER))
                            .routeId(setRouteId(PRODUCER))
                            .to(endpoint);

                }
            });

            if (serviceBusRequest.getInData() instanceof ProducerInputs producerInputs) {
                response = producerTemplate.asyncRequestBody(
                        getRouteConstant(PRODUCER),
                        producerInputs.getPayload());
            }
            return response != null ? response.join() : null;

        }

    }

}
