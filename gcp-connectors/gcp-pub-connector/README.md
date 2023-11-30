## SUMMARY
This article will explain how to invoke GCP Pub in a SaaS environment using the GCP Pub connector via the Java framework.

##### **PREREQUISITE**

To use a GCP Pub connector, you need to have a Service AccountKey. 
- **SERVICE ACCOUNT KEY** -Provided by Google Cloud Platform.It was produced at the same moment the service account was created and is in the format of a json file.
  Ex: C:\path\filename.json
#### **SETTING UP CONNECTOR IN THE WORKFLOW**
  1. Load the connector template Json available in [location](element-templates/gcp-pub-template.json) into Camunda 8 (SAAS/Self-Managed)
  2. To use GCP Pub Connector in your process, Choose a gcp pub connector template for service task.Please refer to the screenshot for further reference.           

<img width="471" alt="1" src="https://github.com/CognizantOpenSource/Cognizant-Camunda-Connectors/assets/123737340/df529b32-372d-48be-9d16-e73ab51fc52a">


##### **CONNECTOR REQUEST**
1. Set the Service Account key in the **GCP Authentication** section.
2. Set the Project Id,Topic Id,Message in the **Google Pub** section.
   
   Please refer to the screenshot for further reference.

<img width="657" alt="2" src="https://github.com/CognizantOpenSource/Cognizant-Camunda-Connectors/assets/123737340/91a58ca6-f2cd-41b8-862e-7f12fdc47e70">


##### **CONNECTOR RESPONSE**
In **Output Mapping** section

4. Use **Result Variable** to store the response in a process variable.
