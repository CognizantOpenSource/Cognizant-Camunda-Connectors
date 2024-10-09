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

<img width="413" alt="AWS_1" src="https://github.com/user-attachments/assets/4c3cef2a-9cb3-457a-9443-24834d410a50">

2) In AWS Section, enter the “analyzeId” operation type from the text box and enter the SourceDocument (local folder path where aws textract connector is hosted)  needs to be retrieved.
3) In Output Mapping Section, set the variable name in “Result Variable” field to store the response in a process variable.

<img width="339" alt="AWS_2" src="https://github.com/user-attachments/assets/e3b9a0d6-cad2-4270-bfc5-381419c0227a">

###### **Analyze Document**
This API will read and extract data from documents as key/value pairs
1) In AWS Authentication Section, set the AWS Account Credentials – Access key, Secret key, and Region.
<img width="407" alt="AWS_3" src="https://github.com/user-attachments/assets/6f136fe8-dd1f-41b2-b8ab-544d6d2a372f">

2) In AWS Section, enter the “analyzeDocument” operation type from the text box and enter the SourceDocument (local folder path where aws textract connector is hosted)  needs to be retrieved.
3) In Output Mapping Section, set the variable name in “Result Variable” field to store the response in a process variable.
<img width="356" alt="AWS_4" src="https://github.com/user-attachments/assets/298b55e4-64cd-43d0-8843-1f292bf3b26b">

######
 **Analyze Expense**
This API will read and extract data from invoices

1) In AWS Authentication Section, set the AWS Account Credentials – Access key, Secret key, and Region.
<img width="406" alt="AWS_5" src="https://github.com/user-attachments/assets/cab3d996-bf53-4064-ae0a-2cbc9e3a3c67">

2) In AWS Section, enter the “analyzeExpenses” operation type from the textbox and enter the SourceDocument (local folder path where aws textract connector is hosted)  needs to be retrieved.
3) In Output Mapping Section, set the variable name in “Result Variable” field to store the response in a process variable.
   
<img width="311" alt="AWS_6" src="https://github.com/user-attachments/assets/567a113e-131c-4bc4-bd4c-3c419d502e77">
