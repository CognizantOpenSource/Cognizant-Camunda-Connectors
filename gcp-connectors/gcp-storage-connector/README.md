## SUMMARY
This article will explain how to invoke GCP Storage in a SaaS environment using the GCP Storage connector via the Java framework.

##### **PREREQUISITE**

To use a GCP Storage connector, you need to have a Service AccountKey. 
- **SERVICE ACCOUNT KEY** -Provided by Google Cloud Platform.It was produced at the same moment the service account was created and is in the format of a json file.
  Ex: C:\path\filename.json

#### **SETTING UP CONNECTOR IN THE WORKFLOW**
  1. Load the connector template Json available in [location](element-templates/gcp-storage-template.json) into Camunda 8 (SAAS/Self-Managed)
  2. To use GCP Connector in your process, Choose a gcp connector template for service task.Please refer to the screenshot for further reference.         
<img width="678" alt="1" src="https://github.com/CognizantOpenSource/Cognizant-Camunda-Connectors/assets/123737340/f128522e-45c7-49e4-b3ab-76787dc2cb82">


#### **LIST OBJECTS**
 This activity lists all the GCP Storage Objects of the bucket which are available for the supplied GCP credentials.

##### **CONNECTOR REQUEST**
1. Set the Service Account key in the **GCP Authentication** section. 
2. Set the Project Id,Bucket Name in the **Google Cloud Storage** section.
3. In the **Google Cloud Storage** section, set the operation type to **listObjects**.
Please refer to the screenshot for further reference.
  
<img width="614" alt="2" src="https://github.com/CognizantOpenSource/Cognizant-Camunda-Connectors/assets/123737340/02743d56-1e3a-4f84-af1d-dd5ff5b2d41f">



##### **CONNECTOR RESPONSE**
In **Output Mapping** section

4. Use **Result Variable** to store the response in a process variable.

#### **LIST BUCKETS**
This activity list all the GCP Storage Buckets which are available for the supplied GCP credentials.

##### **CONNECTOR REQUEST**
1. Set the Service Account key  in the **GCP Authentication** section.
2. Set the Project Id in the **Google Cloud Storage** section.
3. In the **Google Cloud Storage** section, set the operation type to **listBuckets**.
Please refer to the screenshot for further reference.
<img width="632" alt="3" src="https://github.com/CognizantOpenSource/Cognizant-Camunda-Connectors/assets/123737340/60ae2523-3915-4955-aebf-939e154e92a9">


##### **CONNECTOR RESPONSE**
In **Output Mapping** section

4. Use **Result Variable** to store the response in a process variable.
#### **GET OBJECT**
This activity get the GCP Object details which are available for the supplied GCP credentials.
1. Set the Service Account key in the **GCP Authentication** section.
2. In the **Google Cloud Storage** section, set the operation type to **getObject**.
3. Set the Project Id,Bucket Name,Object Name in the **Google Cloud Storage** section.
Please refer to the screenshot for further reference.
<img width="665" alt="4" src="https://github.com/CognizantOpenSource/Cognizant-Camunda-Connectors/assets/123737340/7eecf4f7-72d5-43ca-a83e-d137dd9de743">


##### **CONNECTOR RESPONSE**
In **Output Mapping** section

4. Use **Result Variable** to store the response in a process variable.
To use GCP Storage connector in your project follow below steps:
