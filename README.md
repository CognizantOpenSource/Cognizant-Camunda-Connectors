## SUMMARY


##### **List of connectors**
This project contains following set of Camunda outbound connectors which can be deployed as single application.

1) aws-connectors
     I) aws-lambda-connector
    II) aws-s3-connector
2) azure-connectors
    I) azure-blob-connector
   II) azure-servicebus-connector
3) gcp-connectors
     I) gcp-functions-connector
    II) gcp-pub-connector
   III) gcp-storage-connector	
4) kafka-connector
5) camelFTP-connector

##### **Note: please refer to Readme file for each of the above connector modules to gain detailed understanding of each connector setup.**

#### **SETTING UP THE CONNECTOR APPLICATION**
This project contains root pom.xml, which needs to be executed in order to build and include sub-modules
Upon execution of root pom.xml it compiles and packages individual sub-modules of the connector along with outbound-connector module which refers to all the connector modules

In order to deploy this project in runtime environment, follow below steps

1) Create a Zeebe client and configure it to connect to the desired SaaS/Self-Managed cluster
2) Add following dependency 
  ###### **groupId: com.cts.eas.ipm.connector**
  ###### **artifactId: outbound-connector**
  ###### **version: 1.0.0**
 
