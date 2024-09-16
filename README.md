## SUMMARY


##### **List of connectors**
This project contains following set of Camunda outbound connectors which can be deployed as single application.

1) aws-connectors
     I) aws-lambda-connector
    II) aws-s3-connector
   III) aws-textract-connector
3) azure-connectors
    I) azure-blob-connector
   II) azure-servicebus-connector(outbound)
  III) azure-servicebus-connector(Inbound)
4) gcp-connectors
     I) gcp-functions-connector
    II) gcp-storage-connector
   III) gcp-pub-connector
    IV) gcp-sub-connector	
5) kafka-connector
6) camelFTP-connector
7) drools-connector
8) pdf-generator-connector

##### **Note: please refer to Readme file for each of the above connector modules to gain detailed understanding of each connector setup.**

#### **SETTING UP THE CONNECTOR APPLICATION**
This project contains root pom.xml, which needs to be executed in order to build and include sub-modules
Upon execution of root pom.xml it compiles and packages individual sub-modules of the connector.
This project requires jdk21+.

In order to deploy this project in runtime environment follow below steps

1) Create a Zeebe client and configure it to connect to the desired SaaS/Self-Managed cluster
2) Add following dependency 
  ###### **groupId: com.cts.eas.ipm.connector**
  ###### **artifactId: cts-camunda-connectors**
  ###### **version: 3.0.0**
 
