## SUMMARY
This article will explain how to invoke GCP Pub in a SaaS environment using the GCP Pub connector via the Java framework.

##### **PREREQUISITE**

To use a GCP Pub connector, you need to have a Service AccountKey. 
- **SERVICE ACCOUNT KEY** -Provided by Google Cloud Platform.It was produced at the same moment the service account was created and is in the format of a json file.
  Ex: C:\path\filename.json
#### **SETTING UP CONNECTOR IN THE WORKFLOW**
  1. Load the connector template Json available in [location](element-templates/gcp-pub-template.json) into Camunda 8 (SAAS/Self-Managed)
  2. To use GCP Pub Connector in your process, Choose a gcp pub connector template for service task.Please refer to the screenshot for further reference.           

![gcp-pub-task](https://github.com/CognizantCodeHub/IPR000820_CamundaCustomConnectors/assets/127398086/ec1458be-946c-453d-9d94-11eaf41f2cce)

##### **CONNECTOR REQUEST**
1. Set the Service Account key in the **GCP Authentication** section.
2. Set the Project Id,Topic Id,Message in the **Google Pub** section.
   
   Please refer to the screenshot for further reference.

![gcp-pub-connector](https://github.com/CognizantCodeHub/IPR000820_CamundaCustomConnectors/assets/127398086/235997e5-2cc1-430c-845a-05d5c6a44cdc)

##### **CONNECTOR RESPONSE**
In **Output Mapping** section

4. Use **Result Variable** to store the response in a process variable.
