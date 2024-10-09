## SUMMARY
This article will explain how to invoke GCP Sub in a SaaS environment using the GCP Sub connector via the Java framework.

##### **PREREQUISITE**

To use a GCP Sub connector, you need to have a Service AccountKey. 
- **SERVICE ACCOUNT KEY** -Provided by Google Cloud Platform.It was produced at the same moment the service account was created and is in the format of a json file.
  Ex: C:\path\filename.json
#### **SETTING UP CONNECTOR IN THE WORKFLOW**
  1. Load the connector template Json available in [location](element-templates/gcp-sub-start-event-connector.json) into Camunda 8 (SAAS/Self-Managed)
  2. To use GCP Sub Connector in your process, Choose a gcp sub  connector template for start event.Please refer to the screenshot for further reference.           

<img width="241" alt="gcp-start-event" src="https://github.com/user-attachments/assets/fb29e4a9-03be-4fe7-92ac-de556efd0550">

##### **CONNECTOR REQUEST**
1. Set the Service Account key in the **GCP Authentication** section.
2. Set the Project Id,Subscription Id,Polling Wait Time, in the **Google Sub** section.
   
Please refer to the screenshot for further reference.

<img width="622" alt="gcp-start-template" src="https://github.com/user-attachments/assets/5d6664b6-95f8-476c-bfe4-8f1820b05d18">
<br /> 
<br /> 

<img width="328" alt="GCP-subscriber-BPMN" src="https://github.com/user-attachments/assets/f67322dc-e11f-4b83-9dc5-dd5d6b5956a4">

##### **CONNECTOR RESPONSE**
In **Output Mapping** section

3. Use **Result Variable** to store the response in a process variable.
