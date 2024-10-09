package com.cts.eas.ipm.connector.azureservicebusconnector.inbound;

import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.ServiceBusRequest;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.ServiceBusResponse;
import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.models.ConsumerInputs;
import com.cts.eas.ipm.connector.suppliers.ObjectMapperSupplier;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.camunda.connector.api.annotation.InboundConnector;
import io.camunda.connector.api.inbound.InboundConnectorContext;
import io.camunda.connector.api.inbound.InboundConnectorExecutable;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Endpoint;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@InboundConnector(
        name = "CustomAzureServiceBusInboundConnector",
        type = "inbound-azureServiceBus-connector"
)
public class AzureServiceBusConsumerExecutable implements InboundConnectorExecutable {
    private static final Logger LOGGER = LoggerFactory.getLogger(AzureServiceBusConsumerExecutable.class);
    private final CamelContext camelContext;
    private final ObjectMapper objectMapper = ObjectMapperSupplier.getMapperInstance();

    public AzureServiceBusConsumerExecutable() {
        super();
        this.camelContext = new DefaultCamelContext();
    }

    public AzureServiceBusConsumerExecutable(CamelContext camelContext) {
        super();
        this.camelContext = camelContext;
    }

    @Override
    public void activate(InboundConnectorContext context) throws Exception {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("properties:\n{}", objectMapper.writeValueAsString(context.getProperties()));
        }
        var input = context.bindProperties(ServiceBusRequest.class);
        camelContext.start();
        consumeMessages(camelContext, context, input);
    }

    @Override
    public void deactivate() {
        camelContext.stop();
    }

    private void consumeMessages(CamelContext camelContext, InboundConnectorContext inboundConnectorContext,
                                 ServiceBusRequest serviceBusRequest) throws Exception {

        try (ConsumerTemplate consumerTemplate = camelContext.createConsumerTemplate()) {
            Endpoint endpoint = serviceBusRequest.getAuthentication().getEndpoint(serviceBusRequest, camelContext);

            camelContext.addRoutes(new EndpointRouteBuilder() {
                @Override
                public void configure() {
                    from(endpoint)
                            .routeId("AzureServiceBus_Route")
                            .log("Message: ${body}")
                            .bean(() -> ServiceBusResponse.withInboundConnectorContext(inboundConnectorContext),
                                    "correlateMessage(${body})");

                }
            });
            if (serviceBusRequest.getInData() instanceof ConsumerInputs consumerInputs) {
                consumerTemplate.start();
                consumerTemplate.receiveBody(endpoint,
                        TimeUnit.SECONDS.toMillis(consumerInputs.getPollingWaitTime()),
                        String.class);
            }
        }

    }


}