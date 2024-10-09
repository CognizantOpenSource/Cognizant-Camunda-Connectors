package com.cts.eas.ipm.connector.awstextract.outbound;

import com.cts.eas.ipm.connector.awstextract.input.AWSTextractConnectorInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.textract.TextractClient;
import software.amazon.awssdk.services.textract.model.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class AnalyzeDocumentFunction {

    public Object analyzeDocument(TextractClient textractClient, AWSTextractConnectorInput input) {

        try {
            InputStream sourceStream = new FileInputStream(new File(input.getInData().getSourceDocument()));
            SdkBytes sourceBytes = SdkBytes.fromInputStream(sourceStream);

            // Get the input Document object as bytes
            Document myDoc = Document.builder()
                    .bytes(sourceBytes)
                    .build();

            List<FeatureType> featureTypes = new ArrayList<FeatureType>();

            featureTypes.add(FeatureType.FORMS);

            featureTypes.add(FeatureType.TABLES);

            AnalyzeDocumentRequest analyzeDocumentRequest = AnalyzeDocumentRequest.builder()
                    .featureTypes(featureTypes)
                    .document(myDoc)
                    .build();

            AnalyzeDocumentResponse analyzeDocument = textractClient.analyzeDocument(analyzeDocumentRequest);

            AtomicReference<String> analyzeDocumentContents = new AtomicReference<>("<html><body><table border='1'><tr><td colspan='2'>KEY VALUES</td></tr>");

            Map<Object, Object> res = new HashMap();
            Map<Object, Object> keyValueMap = new HashMap();

            analyzeDocument.blocks().stream().filter(s -> s.blockType().toString().equalsIgnoreCase("KEY_VALUE_SET") && s.entityTypesAsStrings().contains("KEY")).forEach(s1 -> {
                StringBuilder keyBuilder = new StringBuilder();
                StringBuilder valueBuilder = new StringBuilder();
                for (Relationship relationship : s1.relationships()) {

                    if (relationship.type().toString().equalsIgnoreCase("VALUE")) {
                        List<String> valueIds = relationship.ids();
                        for (String key : valueIds) {
                            List<Relationship> valueRelationShips = analyzeDocument.blocks().stream().filter(b -> b.id().equalsIgnoreCase(key)).findAny().get().relationships();
                            for (Relationship valueRelationShip : valueRelationShips) {
                                for (String valueRelationShipKey : valueRelationShip.ids()) {
                                    valueBuilder.append(analyzeDocument.blocks().stream().filter(b -> b.id().equalsIgnoreCase(valueRelationShipKey)).findAny().get().text());
                                }
                            }
                        }

                    }
                    if (relationship.type().toString().equalsIgnoreCase("CHILD")) {
                        List<String> valueIds = relationship.ids();
                        for (String key : valueIds) {
                            keyBuilder.append(analyzeDocument.blocks().stream().filter(b -> b.id().equalsIgnoreCase(key)).findAny().get().text());
                        }
                    }


                    keyValueMap.put(keyBuilder, valueBuilder);
                }
            });
            res.put("KEY_VALUE", keyValueMap);
            //QUERYANSWERS
          /*  Map<String, List> queryAnswerMap = new HashMap<>();

            analyzeDocument.blocks().stream().filter(s -> s.blockType().toString().equalsIgnoreCase("QUERY")).forEach(
                    s1 -> {
                        if (queryAnswerMap.get(s1.query().text()) == null) {
                            queryAnswerMap.put(s1.query().text(), s1.relationships());
                        } else {
                            queryAnswerMap.get(s1.query().text()).addAll(s1.relationships());
                        }
                    }
            );
            Map<Object, Object> questionAnswerMap = new HashMap<>();
            for (String queryQuestion : queryAnswerMap.keySet()) {
                System.out.println("queryQuestion=======================" + queryQuestion);

                List<Relationship> queryAnswerList = queryAnswerMap.get(queryQuestion);

                for (Relationship relationship : queryAnswerList) {
                    if (relationship.type().toString().equalsIgnoreCase("ANSWER")) {
                        for (String id : relationship.ids()) {

                            questionAnswerMap.put(queryQuestion, analyzeDocument.blocks().stream().filter(s -> s.id().equalsIgnoreCase(id)).findAny().get().text());
                        }
                    }
                }

            }
            res.put("QUESTION_ANWSER", questionAnswerMap);*/
            return res;
        } catch (Exception e) {
            Map<Object, Object> error = new HashMap<>();
            error.put("error", e.getMessage());
            System.err.println(e.getMessage());
            return error;
        }


    }
}
