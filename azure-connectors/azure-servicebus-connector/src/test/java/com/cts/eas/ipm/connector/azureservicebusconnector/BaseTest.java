package com.cts.eas.ipm.connector.azureservicebusconnector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.readString;

public abstract class BaseTest extends CamelTestSupport {

    protected static final Gson gson = new GsonBuilder().create();

    protected static final String SUCCESS_REQUEST_PRODUCER_CASE_PATH =
            "src/test/resources/requests/azureServiceBus-producer-connector-success-test-case.json";
    private static final String AzureServiceBus_SharedKeyCredential_SuccessCase =
            "src/test/resources/requests/AzureServiceBus_SharedKeyCredential_SuccessCase.json";
    private static final String AzureServiceBus_ClientSecretCredential_SuccessCase =
            "src/test/resources/requests/AzureServiceBus_ClientSecretCredential_SuccessCase.json";

    private static final String AzureServiceBus_ConnectionString_SuccessCase =
            "src/test/resources/requests/AzureServiceBus_ConnectionStringAuth_SuccessCase.json";
    protected static Stream<String> doSuccessAzureServiceBusProducerTest() throws IOException {
        return BaseTest.loadTestCasesFromResourceFile(SUCCESS_REQUEST_PRODUCER_CASE_PATH);
    }

    protected static Stream<String> loadTestCasesFromResourceFile(final String fileWithTestCasesUri)
            throws IOException {
        return Stream.of(readString(new File(fileWithTestCasesUri).toPath(), UTF_8));
    }


    protected static String loadResourceBasedOnFilename(String fileName) {
        try {
            return readString(new File(fileName).toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static Stream<String> doAzureServiceBusSharedKeyCredentialSuccessCase() throws IOException {
        return BaseTest.loadTestCasesFromResourceFile(AzureServiceBus_SharedKeyCredential_SuccessCase);
    }

    protected static Stream<String> doAzureServiceBusConnectionStringSuccessCase() throws IOException {
        return BaseTest.loadTestCasesFromResourceFile(AzureServiceBus_ConnectionString_SuccessCase);
    }
    protected static Stream<String> doAzureServiceBusClientSecretCredentialSuccessCase() throws IOException {
        return BaseTest.loadTestCasesFromResourceFile(AzureServiceBus_ClientSecretCredential_SuccessCase);
    }

}
