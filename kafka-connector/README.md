## SUMMARY
This article will explain how to invoke Kafkaconnector in a Camunda SaaS environment via the Camel framework.Kafka connector provides the ability to publish a message onto the Kafka broker for a specified topic.

##### **PREREQUISITE**
1. Kafka broker should be setup, up and running to use.
2. Topic should be setup on Kafka where message needs to be published.

#### **SETTING UP CONNECTOR IN THE WORKFLOW**
1) Load the connector template Json available in Git repo (kafka-connector\element-templates\kafka-connector.json) into Camunda 8 (SAAS/Self-Managed)
2) Apply the connector template on a service task which can be used to publish the message onto Kafka in workflow.
3) Fill following template details.
   a) Message: It is a placeholder for Kafka message that needs to be published and can be passed as a process variable or static Kafka message depending on requirement.
   b) topic name: it should be the exact topic name created in Kafka.
   c) host and port: It is a placeholder for Kafka host and port name, it should follow format host:port.
   d) Kafka connector response can be captured in the process variable which can be defined under custom properties
   
#### **KAFKA CONNECTOR SAMPLE SCREENSHOTS**





<img width="610" alt="kafka_1" src="https://github.com/CognizantCodeHub/IPR000820_CamundaCustomConnectors/assets/123737340/7bc36903-3924-4bdb-8f4f-846f9efadd43">


<img width="544" alt="kafka_2" src="https://github.com/CognizantCodeHub/IPR000820_CamundaCustomConnectors/assets/123737340/91b3d125-30c8-4984-882d-0da102f189c1">



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

