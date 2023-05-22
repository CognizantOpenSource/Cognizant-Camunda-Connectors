The project contains root pom.xml, which needs to be executed to build the project

Upon execution of root pom.xml it compiles and packages individual modules of the connector along with outbound-connector module which refers to all the connector modules

To deploy the framework in runtime environment, simply add the dependency of outbound-connector artifact in the Zeebe Client and initialize the bean com.cts.eas.ipm.connector.outboundConnector.CustomConnector

It is Recommended that ZeebeClient be built using Springboot to use Camunda outbound connectors SDK version > 0.3.0