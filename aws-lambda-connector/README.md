To use AWS Lambda Camel connector in your project, please follow below steps:

1.	Use the connector template **aws-lambda-operations-via-camel.json** from element-templates folder inside aws-lambda-connector
2.	Publish the connector in Zeebe engine
3.	Use the template on required service task, provide values for following fields :
		**AWS Account credentials Details:**
		- 	Access Key - Provide an access key of AWS Lambda
		- 	Secret Key - Provide a secret key of AWS Lambda
		- 	Region     - Specify the AWS Lambda region
	**Lambda Operation Configuration Details:**
		- 	**Operation Type** - Select AWS Lambad Operation (**ListFunctions**, **invokeFunction**) from Dropdown
		*In case of **invokeFunction** operation type,*
			- **Function Name** - Specify the Lambda function Name
			- **Payload** - Specify Object Key value
	**ResultVariable**: initialize with process variable name to capture response from AWSLAMBDA connector
4.	After configuring above parameters in the service task it can be used to fetch the result 	of desired AWS LAMBDA Operations (ListFunctions, InvokeFunction) via Camel Route
