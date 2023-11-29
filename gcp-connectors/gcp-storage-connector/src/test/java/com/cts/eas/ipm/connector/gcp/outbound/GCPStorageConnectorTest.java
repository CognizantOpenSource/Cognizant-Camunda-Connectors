package com.cts.eas.ipm.connector.gcp.outbound;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.camunda.connector.test.outbound.OutboundConnectorContextBuilder;
import io.camunda.connector.test.outbound.OutboundConnectorContextBuilder.TestConnectorContext;

@ExtendWith(MockitoExtension.class)
class GCPStorageConnectorTest extends BaseTest {

	@InjectMocks
	GCPStorageConnector gcpStorageConnector;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	private static final Logger LOGGER = LoggerFactory.getLogger(GCPStorageConnectorTest.class);
	@ParameterizedTest
	@MethodSource(value = { "doSuccessGcpListBucketsTest" })
	void doSuccessGcpListBucketsTest(String input) {
		TestConnectorContext outboundContext = OutboundConnectorContextBuilder.create().variables(input).build();

		Object result =gcpStorageConnector.executeContext(outboundContext);
		LOGGER.info("result     >>>"+ result);
		assertNotNull(result);

	}

	@ParameterizedTest
	@MethodSource(value = { "doSuccessGcpListObjectsTest" })
	void doSuccessGcpListObjectsTest(String input) {
		TestConnectorContext outboundContext = OutboundConnectorContextBuilder.create().variables(input).build();

		Object result = gcpStorageConnector.executeContext(outboundContext);
		LOGGER.info("result     >>>"+ result);
		assertNotNull(result);

	}

	@ParameterizedTest
	@MethodSource(value = { "doSuccessGcpGetObjectTest" })
	void doSuccessGcpGetObjectTest(String input) {
		TestConnectorContext outboundContext = OutboundConnectorContextBuilder.create().variables(input).build();

		Object result =gcpStorageConnector.executeContext(outboundContext);
		LOGGER.info("result     >>>"+ result);
		assertNotNull(result);

	}

}
