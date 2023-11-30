## SUMMARY

AWS S3 Connector enables to connect BPM process to Amazon’s Simple Storage Service that allows to perform retrieve operations. Currently, the AWS S3 Connector supports 3 types of retrieve operations: ListObjects, ListBuckets, GetObject.

##### **PREREQUISITE**
To use an AWS S3 Connector, need to have AWS Account Credentials, AWS Region, and Bucket Name. See the AWS S3 developer guide to learn more.
The component requires the following credentials to authenticate with the AWS services:
AWS ACCESS KEY - this is your Access Key ID when you created the AWS account.
AWS ACCESS SECRET - this is your Secret access key given to you during the key creation.

##### **SETTING UP CONNECTOR IN THE WORKFLOW**
1) Load the connector template Json available in Git repo (aws-s3-connector\element-templates\ aws-s3-via-camel-template.json) into Camunda 8 (SAAS/Self-Managed)
2) Apply the connector template on a service task which can be used to perform AWS S3 operations in the workflow.

##### **OPERATIONS**

###### **LIST OBJECTS**
The operation lists the objects in a specific bucket. Follow below steps to configure.
1) In AWS Authentication Section, set the AWS Account Credentials – Access key, Secret key, and Region.
2) In AWS Section, select the “listObjects” operation type from the dropdown and set the Bucket Name from which the list of Objects needs to be retrieved.
3) In Output Mapping Section, set the variable name in “Result Variable” field to store the response in a process variable.

###### **LIST BUCKETS**
The operation lists the buckets for this account in a specified region. Follow below steps to configure.
1) In AWS Authentication Section, set the AWS Account Credentials – Access key, Secret key, and Region.
2) In AWS Section, select the “listBuckets” operation type from the dropdown and set the Bucket Name.
3) In Output Mapping Section, set the variable name in “Result Variable” field to store the response in a process variable.
   
###### **GET OBJECT**
The operation retrieves a single object metadata from a specified bucket. Follow below steps to configure.
1) In AWS Authentication Section, set the AWS Account Credentials – Access key, Secret key, and Region.
2) In AWS Section, select the “listBuckets” operation type from the dropdown and set the Bucket Name.
3) In Output Mapping Section, set the variable name in “Result Variable” field to store the response in a process variable.

##### **SAMPLE SCREENSHOTS**
1) Choose a template for service task
<img width="541" alt="AWS_S3_1" src="https://github.com/CognizantOpenSource/Cognizant-Camunda-Connectors/assets/123737340/7436412b-0bc2-4311-a54c-65e05143659e">

2) Enter the Config details as shown below for AWS S3 List Objects
<img width="602" alt="AWS_S3_2" src="https://github.com/CognizantOpenSource/Cognizant-Camunda-Connectors/assets/123737340/f060d83e-b0be-4f6d-995d-c933b21fbc57">

3) Enter the Config details as shown below for AWS S3 List Buckets
<img width="568" alt="AWS_S3_3" src="https://github.com/CognizantOpenSource/Cognizant-Camunda-Connectors/assets/123737340/da0d9641-f245-4e5b-ab5e-f380439067e9">

4) Enter the Config details as shown below for AWS S3 Get Object
<img width="539" alt="AWS_S3_4" src="https://github.com/CognizantOpenSource/Cognizant-Camunda-Connectors/assets/123737340/4f0d4c9e-ea4e-498a-a818-bb3d41f23d00">



