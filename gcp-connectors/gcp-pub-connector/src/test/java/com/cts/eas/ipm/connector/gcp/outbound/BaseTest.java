package com.cts.eas.ipm.connector.gcp.outbound;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.readString;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public abstract class BaseTest{

	protected static final String SUCCESS_REQUEST_PUB = "src/test/resources/requests/gcp-publish.json";

	protected static Stream<String> doSuccessGcpPublishTest() throws IOException {
		return BaseTest.loadTestCasesFromResourceFile(SUCCESS_REQUEST_PUB);
	}


	protected static Stream<String> loadTestCasesFromResourceFile(final String fileWithTestCasesUri)
			throws IOException {
		return Stream.of(readString(new File(fileWithTestCasesUri).toPath(), UTF_8));
	}
}
