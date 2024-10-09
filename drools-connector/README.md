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

<img width="950" alt="drools_1" src="https://github.com/user-attachments/assets/b6663c81-d29b-4b0f-8632-ecf8e4b5234b">

##### **CONNECTOR RESPONSE**
In **Output Mapping** section

3. Use **Result Variable** to store the response in a process variable.
