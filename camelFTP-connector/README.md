## SUMMARY
This article will explain how to invoke FTPconnector in a Camunda SaaS environment via the Camel framework.FTP connector provides the ability to publish a file to S/FTP server and to download the file from the S/FTP Server.

##### **PREREQUISITE**
S/FTP Server should be setup, up and running to use.

#### **SETTING UP CONNECTOR IN THE WORKFLOW**
1) Load the connector template Json available in Git repo
   (ftp-connector\element-templates\ftpconnector.json) into Camunda 8 (SAAS/Self-Managed).
3) Apply the connector template on a service task which can be used to push the file onto S/FTP server or
download from the S/FTP in workflow.
4) Fill following template details, below are the placeholders for the s/ftp connectors.
   a) username and password: S/FTP file server username and the password.
   b)  directoryName: Specifies the directory path in the S/FTP server.
   c)  filepath: Specified the location where the file is present for uploading to the server or specifies
        the location where the file must be downloaded from the server based on the requirement.
   d)   protocol: “ftp” or ”sftp” depending on the requirement.
   e)  operationMode: “producer” or “consumer” based on the requirement.

##  FTP CONNECTOR  SAMPLE SCREENSHOTS  

<img width="566" alt="FTP_1" src="https://github.com/CognizantCodeHub/IPR000820_CamundaCustomConnectors/assets/123737340/bb5fb551-aef6-4536-99ea-fece877e9a1f">

<img width="589" alt="FTP_2" src="https://github.com/CognizantCodeHub/IPR000820_CamundaCustomConnectors/assets/123737340/6820e0d3-1eef-457a-b790-683ee1bc7e2e">


To use camel ftp connector in your project follow below steps

1.	Use the connector template ftp_connectorTemplate.json from element-templates folder inside camelFTP-connector
2.	Publish the connector in Zeebe engine
3.	Use the template on required service task, provide values for following fields
	a.	host (host and port number)
	b.	userName, password(required to access the FTP server)
	c.	directoryName,filePath– The path from where you want to upload the data to FTP/SFTP
	d.	message – can be added as manual or assign value from process variable 
	e.	protocol– ftp/sftp based on the path
	f. 	operationMode - Producer(load the file to FTP/SFTP server)/Consumer(download the file from the FTP/SFTP server to local or any cloud where there is access)
4.	After configuring above parameters in the service task it can be used to trigger publish on given topic
