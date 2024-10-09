## SUMMARY

AWS Textract Connector enables to connect BPM process to Amazon’s Textract Service that allows to perform document text detection operations. Currently, the AWS Textract Connector supports 3 types of retrieve operations: AnalyzeIdentityDocument,AnalyseDocument and AnalyseInvoice

##### **PREREQUISITE**
To use an AWS Textract Connector, need to have AWS Account Credentials, AWS Region, and local path of document file where connector is hosted. See the AWS S3 developer guide to learn more.
The component requires the following credentials to authenticate with the AWS services:
AWS ACCESS KEY - this is your Access Key ID when you created the AWS account.
AWS ACCESS SECRET - this is your Secret access key given to you during the key creation.

##### **SETTING UP CONNECTOR IN THE WORKFLOW**
1) Load the connector template Json available in Git repo (aws-textract-connector\element-templates\ AWS Textract Template.json) into Camunda 8 (SAAS/Self-Managed)
2) Apply the connector template on a service task which can be used to perform AWS Textract operations in the workflow.

##### **OPERATIONS**

###### **Analyze ID**
This API will read and extract data from identity documents such U.S. Driver’s license, and U.S. Passports making it easy for customer to automate and expedite their document processing. You can immediately start extracting implicit fields like name, address, as well as explicit fields like date of birth, date of issue, date of expiry, ID #, ID type, and much more in the form of key- value pairs.
1) In AWS Authentication Section, set the AWS Account Credentials – Access key, Secret key, and Region.
   ![AWSTextract1](https://github.com/user-attachments/assets/d3333282-80e0-4199-bf16-4c3394d3ddd9)

2) In AWS Section, enter the “analyzeId” operation type from the text box and enter the SourceDocument (local folder path where aws textract connector is hosted)  needs to be retrieved.
3) In Output Mapping Section, set the variable name in “Result Variable” field to store the response in a process variable.
![analyseidtextract](https://github.com/user-attachments/assets/20cdcd3b-8fd9-478a-9e48-71bad80bec50)

###### **Analyze Document**
This API will read and extract data from documents as key/value pairs
1) In AWS Authentication Section, set the AWS Account Credentials – Access key, Secret key, and Region.
   ![AWSTextract1](https://github.com/user-attachments/assets/44ec3df3-840b-4f92-ab5d-da01adb405cf)

2) In AWS Section, enter the “analyzeDocument” operation type from the text box and enter the SourceDocument (local folder path where aws textract connector is hosted)  needs to be retrieved.
3) In Output Mapping Section, set the variable name in “Result Variable” field to store the response in a process variable.
  ![analysedocumenttextract](https://github.com/user-attachments/assets/0803d3b0-6938-443c-b4eb-5ae6e5db57f3) 
######
 **Analyze Expense**
This API will read and extract data from invoices

1) In AWS Authentication Section, set the AWS Account Credentials – Access key, Secret key, and Region.
   ![AWSTextract1](https://github.com/user-attachments/assets/2cc9cc0e-0779-4a72-a5f0-1b7a4426c20d)

2) In AWS Section, enter the “analyzeExpenses” operation type from the textbox and enter the SourceDocument (local folder path where aws textract connector is hosted)  needs to be retrieved.
3) In Output Mapping Section, set the variable name in “Result Variable” field to store the response in a process variable.
   
![analyseexpensestextract](https://github.com/user-attachments/assets/7f0d34c5-263f-4568-b755-f635bdbeca49)
