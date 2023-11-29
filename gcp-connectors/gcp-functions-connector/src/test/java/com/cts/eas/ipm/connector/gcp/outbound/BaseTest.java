package com.cts.eas.ipm.connector.gcp.outbound;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.readString;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public abstract class BaseTest{

	protected static final String SUCCESS_REQUEST_LISTFUNCTIONS = "src/test/resources/requests/gcp-listFunctions.json";

	protected static Stream<String> doSuccessGcpListFunctionsTest() throws IOException {
		return BaseTest.loadTestCasesFromResourceFile(SUCCESS_REQUEST_LISTFUNCTIONS);
	}
	

	protected static final String SUCCESS_REQUEST_CALLFUNCTION= "src/test/resources/requests/gcp-callFunction.json";

	protected static Stream<String> doSuccessGcpCallFunctionTest() throws IOException {
		return BaseTest.loadTestCasesFromResourceFile(SUCCESS_REQUEST_CALLFUNCTION);
	}


	protected static Stream<String> loadTestCasesFromResourceFile(final String fileWithTestCasesUri)
			throws IOException {
		return Stream.of(readString(new File(fileWithTestCasesUri).toPath(), UTF_8));
	}
}
