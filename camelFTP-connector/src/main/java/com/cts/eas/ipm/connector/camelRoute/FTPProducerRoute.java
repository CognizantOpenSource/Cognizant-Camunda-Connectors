package com.cts.eas.ipm.connector.camelRoute;

import org.apache.camel.builder.RouteBuilder;

import com.cts.eas.ipm.connector.constant.Constants;


public class FTPProducerRoute extends RouteBuilder {

	private String message;
	private String host;
	private String port;
	private String userName;

	private String password;
	private String directoryName;
	private String filePath;
	private String protocol;
	private String operationMode;

	public FTPProducerRoute(String host, String userName, String password, String filePath, String directoryName,
			String protocol, String operationMode) {
		this.host = host;
		this.userName = userName;
		this.password = password;
		this.filePath = filePath;
		this.directoryName = directoryName;
		this.protocol = protocol;
		this.operationMode = operationMode;
	}

	@Override
	public void configure() throws Exception {
	
		onException(Exception.class) .maximumRedeliveries(3); 
		from(Constants.FTP_PRODUCER_DIRECT)
		.process(ex ->{
			 log.info("Check point");         })
		.pollEnrich(filePath)
						.log("File Read from specific location and before push to FTP Server")
						.toD(protocol + Constants.PROTOCOL_CONSTRUCT
								+ directoryName + Constants.QUESTION_MARK_SYMBOL + Constants.USERNAME_CONSTANT+userName+ Constants.AMPERSAND_SYMBOL +Constants.PASSWORD_CONSTANT + password
								+ Constants.AMPERSAND_SYMBOL + Constants.BINARY_CONSTANT +Constants.FTP_PASSIVE)
						.log("File pushed to FTP Server")
						.process(ex ->{
				            log.info("Check point");
				         })
						.end().stop();
	}

}
