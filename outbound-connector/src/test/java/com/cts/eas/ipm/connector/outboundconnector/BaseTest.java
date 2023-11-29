package com.cts.eas.ipm.connector.outboundconnector;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.readString;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.params.provider.Arguments;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class BaseTest extends CamelTestSupport {

	protected static final Gson gson = new GsonBuilder().create();

	protected static final String SUCCESS_REQUEST_CASE_PATH =
		      "src/test/resources/requests/custom-connector-success-test-case.json";
	
	protected static Stream<Object> doSuccessCustomConnectorTest() throws IOException {
		return BaseTest.loadTestCasesFromResourceFile(SUCCESS_REQUEST_CASE_PATH);
	}		

	protected static Stream<Object> loadTestCasesFromResourceFile(final String fileWithTestCasesUri)
			throws IOException {
		final String cases = readString(new File(fileWithTestCasesUri).toPath(), UTF_8);
		final Gson testingGson = new Gson();
		List<?> array = testingGson.fromJson(cases, ArrayList.class);
		return array.stream().map(testingGson::toJson).map(Arguments::of);
	}
}
