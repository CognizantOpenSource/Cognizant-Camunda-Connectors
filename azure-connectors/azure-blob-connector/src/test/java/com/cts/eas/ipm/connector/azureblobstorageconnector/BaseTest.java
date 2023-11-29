package com.cts.eas.ipm.connector.azureblobstorageconnector;

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

	protected static final String SUCCESS_REQUEST_PRODUCER_LISTBLOBCONTAINERS_CASE_PATH =
		      "src/test/resources/requests/azureBlobStorage-producer-listblobcontainers-connector-success-test-case.json";

	protected static final String SUCCESS_REQUEST_PRODUCER_LISTBLOBS_CASE_PATH =
		      "src/test/resources/requests/azureBlobStorage-producer-listblobs-connector-success-test-case.json";
	
	protected static final String SUCCESS_REQUEST_PRODUCER_GETBLOB_CASE_PATH =
		      "src/test/resources/requests/azureBlobStorage-producer-getblob-connector-success-test-case.json";
	
	protected static final String SUCCESS_REQUEST_PRODUCER_UPLOADBLOCKBLOB_CASE_PATH =
		      "src/test/resources/requests/azureBlobStorage-producer-uploadBlockBlob-connector-success-test-case.json";
	
	protected static Stream<String> doSuccessAzureBlobStorageProducerListBlobContainersTest() throws IOException {
		return BaseTest.loadTestCasesFromResourceFile(SUCCESS_REQUEST_PRODUCER_LISTBLOBCONTAINERS_CASE_PATH);
	}
	
	protected static Stream<String> doSuccessAzureBlobStorageProducerListBlobsTest() throws IOException {
		return BaseTest.loadTestCasesFromResourceFile(SUCCESS_REQUEST_PRODUCER_LISTBLOBS_CASE_PATH);
	}
	
	protected static Stream<String> doSuccessAzureBlobStorageProducerUploadBlockBlobTest() throws IOException {		
		return BaseTest.loadTestCasesFromResourceFile(SUCCESS_REQUEST_PRODUCER_UPLOADBLOCKBLOB_CASE_PATH);
	}
	
	protected static Stream<String> doSuccessAzureBlobStorageProducerGetBlobTest() throws IOException {
		return BaseTest.loadTestCasesFromResourceFile(SUCCESS_REQUEST_PRODUCER_GETBLOB_CASE_PATH);
	}
	
	protected static Stream<String> loadTestCasesFromResourceFile(final String fileWithTestCasesUri)
			throws IOException {
		return Stream.of(readString(new File(fileWithTestCasesUri).toPath(), UTF_8));				
	}
}
