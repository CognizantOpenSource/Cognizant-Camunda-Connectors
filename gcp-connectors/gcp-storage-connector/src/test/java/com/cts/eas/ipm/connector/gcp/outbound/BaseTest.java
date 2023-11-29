package com.cts.eas.ipm.connector.gcp.outbound;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.readString;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public abstract class BaseTest{

	protected static final String SUCCESS_REQUEST_LISTBUCKETS = "src/test/resources/requests/gcp-listBuckets.json";

	protected static Stream<String> doSuccessGcpListBucketsTest() throws IOException {
		return BaseTest.loadTestCasesFromResourceFile(SUCCESS_REQUEST_LISTBUCKETS);
	}
	

	protected static final String SUCCESS_REQUEST_LISTOBJECTS = "src/test/resources/requests/gcp-listObjects.json";

	protected static Stream<String> doSuccessGcpListObjectsTest() throws IOException {
		return BaseTest.loadTestCasesFromResourceFile(SUCCESS_REQUEST_LISTOBJECTS);
	}

	protected static final String SUCCESS_REQUEST_GETOBJECT = "src/test/resources/requests/gcp-getObject.json";

	protected static Stream<String> doSuccessGcpGetObjectTest() throws IOException {
		return BaseTest.loadTestCasesFromResourceFile(SUCCESS_REQUEST_GETOBJECT);
	}

	protected static Stream<String> loadTestCasesFromResourceFile(final String fileWithTestCasesUri)
			throws IOException {
		return Stream.of(readString(new File(fileWithTestCasesUri).toPath(), UTF_8));
	}
}
