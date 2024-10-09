## SUMMARY
This article will explain how to invoke drools in a SaaS environment using the drools connector via the Java framework.

##### **PREREQUISITE**

1. drl files should be placed in drools-connector resource folder.
2. configure all drl files in DroolConfig class.

#### **SETTING UP CONNECTOR IN THE WORKFLOW**
  1. Load the connector template Json into Camunda 8 (SAAS/Self-Managed) project. The template is available in GIT folder drools-connector\element-templates\drools-template.json
  2. To use Drools Connector in your process, Choose a drools connector template for start event.          


##### **CONNECTOR REQUEST**

   Please refer to the screenshot for further reference.


<img width="834" alt="drools-start-event" src="https://github.com/user-attachments/assets/7481d0cf-c7d9-4a16-9000-ff449345dcb4">

##### **CONNECTOR RESPONSE**
In **Output Mapping** section

3. Use **Result Variable** to store the response in a process variable.
