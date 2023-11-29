## SUMMARY
This article will explain how to invoke GCP Storage in a SaaS environment using the GCP Storage connector via the Java framework.

##### **PREREQUISITE**

To use a GCP Storage connector, you need to have a Service AccountKey. 
- **SERVICE ACCOUNT KEY** -Provided by Google Cloud Platform.It was produced at the same moment the service account was created and is in the format of a json file.
  Ex: C:\path\filename.json

#### **SETTING UP CONNECTOR IN THE WORKFLOW**
  1. Load the connector template Json available in [location](element-templates/gcp-storage-template.json) into Camunda 8 (SAAS/Self-Managed)
  2. To use GCP Connector in your process, Choose a gcp connector template for service task.Please refer to the screenshot for further reference.         
  ![gco-storage-config](https://github.com/CognizantCodeHub/IPR000820_CamundaCustomConnectors/assets/127398086/79a2a75d-1b67-428b-8ace-726099dcad35)

#### **LIST OBJECTS**
 This activity lists all the GCP Storage Objects of the bucket which are available for the supplied GCP credentials.

##### **CONNECTOR REQUEST**
1. Set the Service Account key in the **GCP Authentication** section. 
2. Set the Project Id,Bucket Name in the **Google Cloud Storage** section.
3. In the **Google Cloud Storage** section, set the operation type to **listObjects**.
Please refer to the screenshot for further reference.
  
![gcp-storage-listObject](https://github.com/CognizantCodeHub/IPR000820_CamundaCustomConnectors/assets/127398086/6349894e-3df1-48dd-901f-2d3a5dabc7ce)


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
![gcp-list-bucket](https://github.com/CognizantCodeHub/IPR000820_CamundaCustomConnectors/assets/127398086/0b89694e-e53a-4259-ab28-01b90e5f2741)

##### **CONNECTOR RESPONSE**
In **Output Mapping** section

4. Use **Result Variable** to store the response in a process variable.
#### **GET OBJECT**
This activity get the GCP Object details which are available for the supplied GCP credentials.
1. Set the Service Account key in the **GCP Authentication** section.
2. In the **Google Cloud Storage** section, set the operation type to **getObject**.
3. Set the Project Id,Bucket Name,Object Name in the **Google Cloud Storage** section.
Please refer to the screenshot for further reference.
![gcp-storage-getObject](https://github.com/CognizantCodeHub/IPR000820_CamundaCustomConnectors/assets/127398086/b3e31343-5e45-431a-b772-1b5c55eae9b2)

##### **CONNECTOR RESPONSE**
In **Output Mapping** section

4. Use **Result Variable** to store the response in a process variable.
To use GCP Storage connector in your project follow below steps:
