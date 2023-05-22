package com.cts.eas.ipm.connector.camelRoute;

import org.apache.camel.builder.RouteBuilder;

import com.cts.eas.ipm.connector.constant.Constants;


public class FTPConsumerRoute extends RouteBuilder{

	private String message;
	private String host;
	private String port;
	private String userName;
	
	private String password;
	private String directoryName;
	private String filePath;
	private String protocol;
	private String operationMode;
	
	public FTPConsumerRoute(String message, String port, String host) {
		this.message = message;
		this.host = host;
		this.port = port;
	}
	
	public FTPConsumerRoute(String host,String userName,String password, String filePath,
			String directoryName,String protocol	,String operationMode) {
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
			from(Constants.FTP_CONSUMER_DIRECT)
			.delay(5000)
			 .pollEnrich(protocol + Constants.PROTOCOL_CONSTRUCT
						+ directoryName + Constants.QUESTION_MARK_SYMBOL + Constants.USERNAME_CONSTANT+userName+ Constants.AMPERSAND_SYMBOL +Constants.PASSWORD_CONSTANT + password
						+ Constants.AMPERSAND_SYMBOL + Constants.BINARY_CONSTANT+Constants.FTP_PASSIVE)
			 .process(ex ->{
	             String bodyStr = ex.getIn().getBody(String.class);
	             log.info("BodyValue::{}",bodyStr);
	          })

			.to(Constants.FILE_COMPONENT + filePath + Constants.QUESTION_MARK_SYMBOL
					+"fileName=copyof_${file:name}.xls")
			.end().stop();
		
			
	}
	
	
}
