package com.cts.eas.ipm.connector.azureservicebusconnector.outbound;

import com.cts.eas.ipm.connector.azureservicebusconnector.BaseTest;
import io.camunda.connector.test.outbound.OutboundConnectorContextBuilder;
import io.camunda.connector.test.outbound.OutboundConnectorContextBuilder.TestConnectorContext;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@TestMethodOrder(OrderAnnotation.class)
class AzureServiceBusConnectorTest extends BaseTest {

    private AzureServiceBusConnectorFunction serviceBusConnector;

    @BeforeEach
    void init() {
        serviceBusConnector = new AzureServiceBusConnectorFunction(context);
    }

    @ParameterizedTest
    @MethodSource("doSuccessAzureServiceBusProducerTest")
    @Order(value = 1)
    void doSuccessAzureServiceBusProducerTest(String input) throws Exception {

        TestConnectorContext outboundContext = new OutboundConnectorContextBuilder().variables(input).build();

        serviceBusConnector.executeContext(outboundContext);

        MockEndpoint.assertIsSatisfied(context);

    }

}