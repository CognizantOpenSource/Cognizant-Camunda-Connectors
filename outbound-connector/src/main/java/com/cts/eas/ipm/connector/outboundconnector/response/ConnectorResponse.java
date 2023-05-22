package com.cts.eas.ipm.connector.outboundconnector.response;

public class ConnectorResponse {
	
	private Object result;

	private ConnectorResponse() {
		super();
	}

	public static ConnectorResponse initialize() {
		return new ConnectorResponse();
	}

	public static ConnectorResponse build(ConnectorResponse response, Object result) {
		response.result = result;
		return response;
	}
	
	public static Object send(ConnectorResponse response) {
		return response.result;
	}
	
	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
}
