package com.cts.eas.ipm.connector.azureservicebusconnector;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.readString;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import org.apache.camel.test.junit5.CamelTestSupport;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class BaseTest extends CamelTestSupport {

	protected static final Gson gson = new GsonBuilder().create();

	protected static final String SUCCESS_REQUEST_PRODUCER_CASE_PATH =
		      "src/test/resources/requests/azureServiceBus-producer-connector-success-test-case.json";

	protected static final String SUCCESS_REQUEST_CONSUMER_CASE_PATH = 
			"src/test/resources/requests/azureServiceBus-consumer-connector-success-test-case.json";
	
	protected static Stream<String> doSuccessAzureServiceBusProducerTest() throws IOException {
		return BaseTest.loadTestCasesFromResourceFile(SUCCESS_REQUEST_PRODUCER_CASE_PATH);
	}
	
	protected static Stream<String> doSuccessAzureServiceBusConsumerTest() throws IOException {
		return BaseTest.loadTestCasesFromResourceFile(SUCCESS_REQUEST_CONSUMER_CASE_PATH);
	}
	
	protected static Stream<String> loadTestCasesFromResourceFile(final String fileWithTestCasesUri)
			throws IOException {
		return Stream.of(readString(new File(fileWithTestCasesUri).toPath(), UTF_8));				
	}
}
