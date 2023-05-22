To use kafka connector in your project follow below steps

1.	Use the connector template kafka-connector.json from element-templates folder inside kafka-connector
2.	Publish the connector in Zeebe engine
3.	Use the template on required service task, provide values for following fields
	a.	host (host and port number where kafka broker is running)
	b.	topicName (topic name configured in kafka)
	c.	connectorId – its already initialized within template to use KafkaPulishImpl class
	d.	message – can be added as manual or assign value from process variable 
e.	resultVariable – initialize with process variable name to capture response from kafka connector
4.	After configuring above parameters in the service task it can be used to trigger kafka publish on given topic

