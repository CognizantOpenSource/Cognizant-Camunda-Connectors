## SUMMARY
This article will explain how to invoke GCP Function((1st gen Cloud Function)  in a SaaS environment using the GCP Functions connector via the Java framework.
##### **PREREQUISITE**
To use a GCP Functions connector, you need to have a Service AccountKey. 
- **SERVICE ACCOUNT KEY** -Provided by Google Cloud Platform.It was produced at the same moment the service account was created and is in the format of a json file.
  Ex: C:\path\filename.json
#### **SETTING UP CONNECTOR IN THE WORKFLOW**
1. Load the connector template Json available in [location](element-templates/gcp-functions-template.json) into Camunda 8 (SAAS/Self-Managed)
2. To use GCP Connector in your process, Choose a GCP Function connector template for service task.Please refer to the screenshot for further reference.         
  <img width="621" alt="1" src="https://github.com/CognizantOpenSource/Cognizant-Camunda-Connectors/assets/123737340/4afbd562-0991-4bf7-8b7e-ba73954df463">

#### **LIST FUNCTION**
 This activity list all the GCP Functions which are available for the supplied GCP credentials.
##### **CONNECTOR REQUEST**
 1. Set the Service Account key,Location in the **GCP Authentication** section.
 2. Set the Project Id in the **Google Cloud Functions** section.
 3. In the **Google Cloud Functions** section, set the operation type to **List Function**.
Please refer to the screenshot for further reference.
<img width="636" alt="2" src="https://github.com/CognizantOpenSource/Cognizant-Camunda-Connectors/assets/123737340/3d001c5b-ee9b-45dc-93b0-c5c6728e41da">



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

<img width="602" alt="3" src="https://github.com/CognizantOpenSource/Cognizant-Camunda-Connectors/assets/123737340/0542d065-9073-4809-8d52-81e4f21b71a4">


##### **CONNECTOR RESPONSE**
In **Output Mapping** section

4. Use **Result Variable** to store the response in a process variable.
