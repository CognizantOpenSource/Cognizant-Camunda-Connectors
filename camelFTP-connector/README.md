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
