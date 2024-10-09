package com.cts.eas.ipm.connector.awstextract.outbound;

import com.cts.eas.ipm.connector.awstextract.input.AWSTextractConnectorInput;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.textract.TextractClient;
import software.amazon.awssdk.services.textract.model.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class AnalyzeIdFunction {

    public Object analyzeId(TextractClient textractClient, AWSTextractConnectorInput input)

    {

        try {
            InputStream sourceStream = new FileInputStream(new File(input.getInData().getSourceDocument()));
            SdkBytes sourceBytes = SdkBytes.fromInputStream(sourceStream);

            // Get the input Document object as bytes
            Document myDoc = Document.builder()
                    .bytes(sourceBytes)
                    .build();


            AnalyzeIdRequest  analyzeIdRequest = AnalyzeIdRequest.builder()
                    .documentPages(myDoc)
                    .build();
            Map<String, String> map = new HashMap<String, String>();

           AnalyzeIdResponse analyzeIdResponse = textractClient.analyzeID(analyzeIdRequest);

            analyzeIdResponse.identityDocuments().stream().forEach(
                    identityDocument->{
                        identityDocument.identityDocumentFields().stream().forEach(
                                identityDocumentFields->{
                                    map.put(identityDocumentFields.type().text(), identityDocumentFields.valueDetection().text());

                                });});
            System.out.println(AnalyzeIdFunction.class.getName() + "Output " + map.toString());

            return map;
        } catch (Exception e) {

            Map<Object,Object> error = new HashMap<>();
            error.put("error",e.getMessage());
            System.err.println(e.getMessage());
            return error;
        }



}
}
