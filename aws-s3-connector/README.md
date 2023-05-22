To use AWS S3 Camel connector in your project follow below steps:

1.	Use the connector template aws-s3-via-camel-template.json from element-templates folder 	inside aws-s3-connector
2.	Publish the connector in Zeebe engine
3.	Use the template on required service task, provide values for following fields :
	a.	AWS Account credentials Details:
		•	Access Key - Provide an access key of AWS S3
		•	Secret Key - Provide a secret key of AWS S3
		•	Region     - Specify the AWS S3 region
	b.	S3 Operation Configuration Details:
		•	Operation Type - Select AWS S3 Operation (ListObjects,ListBuckets,GetObject) from 			Dropdown
		•	Bucket Name    - Specify the AWS S3 Bucket
		•	Key - In case of “GetObject” operation type, specify Object Key value
	c.	resultVariable – initialize with process variable name to capture response from AWSS3 		connector
4.	After configuring above parameters in the service task it can be used to fetch the result 	of desired AWS S3 Operations (ListObjects, ListBuckets, GetObject) via Camel Route
