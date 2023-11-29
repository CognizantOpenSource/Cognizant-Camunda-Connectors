## SUMMARY
This article will explain how to invoke GCP Function((1st gen Cloud Function)  in a SaaS environment using the GCP Functions connector via the Java framework.
##### **PREREQUISITE**
To use a GCP Functions connector, you need to have a Service AccountKey. 
- **SERVICE ACCOUNT KEY** -Provided by Google Cloud Platform.It was produced at the same moment the service account was created and is in the format of a json file.
  Ex: C:\path\filename.json
#### **SETTING UP CONNECTOR IN THE WORKFLOW**
1. Load the connector template Json available in [location](element-templates/gcp-functions-template.json) into Camunda 8 (SAAS/Self-Managed)
2. To use GCP Connector in your process, Choose a GCP Function connector template for service task.Please refer to the screenshot for further reference.         
  ![gcp-functions-servicetask](https://github.com/CognizantCodeHub/IPR000820_CamundaCustomConnectors/assets/127398086/7d49807e-6e56-4351-a3de-89f46ee250a1)
#### **LIST FUNCTION**
 This activity list all the GCP Functions which are available for the supplied GCP credentials.
##### **CONNECTOR REQUEST**
 1. Set the Service Account key,Location in the **GCP Authentication** section.
 2. Set the Project Id in the **Google Cloud Functions** section.
 3. In the **Google Cloud Functions** section, set the operation type to **List Function**.
Please refer to the screenshot for further reference.
![gcp-list-functions](https://github.com/CognizantCodeHub/IPR000820_CamundaCustomConnectors/assets/127398086/4d75418a-0a44-4da8-a09c-b81b050091f4)


##### **CONNECTOR RESPONSE**
In **Output Mapping** section

4. Use **Result Variable** to store the response in a process variable.
   
#### **CALL FUNCTION**
This activity invoke the GCP Functions which are available for the supplied GCP credentials.
##### **CONNECTOR REQUEST**
1. Set the Service Account key,Location in the **GCP Authentication** section.
2. In the **Google Cloud Functions** section, set the operation type to **Call Function**.
3. Set the Project Id,Functions Name in the **Google Cloud Functions** section.
Please refer to the screenshot for further reference.

![gcp-functions-call](https://github.com/CognizantCodeHub/IPR000820_CamundaCustomConnectors/assets/127398086/86753f65-0054-45ab-83a5-9fdaac8bf958)

##### **CONNECTOR RESPONSE**
In **Output Mapping** section

4. Use **Result Variable** to store the response in a process variable.
