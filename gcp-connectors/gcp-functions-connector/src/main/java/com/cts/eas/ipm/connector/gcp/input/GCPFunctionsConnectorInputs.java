package com.cts.eas.ipm.connector.gcp.input;

public class GCPFunctionsConnectorInputs {
  

	private String serviceAccountKey;
	private String location;
	private String gcpFunctionsOperation;
	private String functionName;
	private String projectId;
	public String getServiceAccountKey() {
		return serviceAccountKey;
	}
	public void setServiceAccountKey(String serviceAccountKey) {
		this.serviceAccountKey = serviceAccountKey;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGcpFunctionsOperation() {
		return gcpFunctionsOperation;
	}
	public void setGcpFunctionsOperation(String gcpFunctionsOperation) {
		this.gcpFunctionsOperation = gcpFunctionsOperation;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	
}
