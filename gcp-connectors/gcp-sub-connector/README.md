## SUMMARY
This article will explain how to invoke GCP Sub in a SaaS environment using the GCP Sub connector via the Java framework.

##### **PREREQUISITE**

To use a GCP Sub connector, you need to have a Service AccountKey. 
- **SERVICE ACCOUNT KEY** -Provided by Google Cloud Platform.It was produced at the same moment the service account was created and is in the format of a json file.
  Ex: C:\path\filename.json
#### **SETTING UP CONNECTOR IN THE WORKFLOW**
  1. Load the connector template Json available in [location](element-templates/gcp-sub-start-event-connector.json) into Camunda 8 (SAAS/Self-Managed)
  2. To use GCP Sub Connector in your process, Choose a gcp sub  connector template for start event.Please refer to the screenshot for further reference.           
<img width="356" alt="gcp_1" src="https://github.com/user-attachments/assets/739a663c-e17d-4ad4-852b-3d644a831b23">

##### **CONNECTOR REQUEST**
1. Set the Service Account key in the **GCP Authentication** section.
2. Set the Project Id,Subscription Id,Polling Wait Time, in the **Google Sub** section.
   
Please refer to the screenshot for further reference.
<img width="742" alt="gcp_2" src="https://github.com/user-attachments/assets/7d73c09f-d555-4617-9f25-deb0650b95ee">

<br /> 
<br /> 

<img width="476" alt="gcp_3" src="https://github.com/user-attachments/assets/16d501f4-f315-4b58-b4cc-5b169415ad2c">

##### **CONNECTOR RESPONSE**
In **Output Mapping** section

3. Use **Result Variable** to store the response in a process variable.
