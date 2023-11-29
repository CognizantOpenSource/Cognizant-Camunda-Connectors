package com.cts.eas.ipm.connector.awslambdaconnector;

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
	
	protected static final String SUCCESS_REQUEST_LISTFUNCTIONS_CASE_PATH =
		      "src/test/resources/requests/awslambda-listfunctions-connector-success-test-case.json";
	
	protected static Stream<String> doSuccessAWSLambdaListFunctionsTest() throws IOException {
		return BaseTest.loadTestCasesFromResourceFile(SUCCESS_REQUEST_LISTFUNCTIONS_CASE_PATH);
	}
		
	protected static final String SUCCESS_REQUEST_INVOKEFUNCTION_CASE_PATH =
		      "src/test/resources/requests/awslambda-invokefunction-connector-success-test-case.json";
	
	protected static Stream<String> doSuccessAWSLambdaInvokeFunctionTest() throws IOException {
		return BaseTest.loadTestCasesFromResourceFile(SUCCESS_REQUEST_INVOKEFUNCTION_CASE_PATH);
	}
	
	protected static Stream<String> loadTestCasesFromResourceFile(final String fileWithTestCasesUri)
			throws IOException {
		return Stream.of(readString(new File(fileWithTestCasesUri).toPath(), UTF_8));				
	}
}
