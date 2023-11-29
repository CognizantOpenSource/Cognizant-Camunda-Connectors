	package com.cts.eas.ipm.connector.gcp.outbound;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.eas.ipm.connector.gcp.input.GCPFunctionsConnectorInput;
import com.cts.eas.ipm.connector.outbound.CoreOutboundConnector;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.functions.v1.CallFunctionRequest;
import com.google.cloud.functions.v1.CallFunctionResponse;
import com.google.cloud.functions.v1.CloudFunction;
import com.google.cloud.functions.v1.CloudFunctionName;
import com.google.cloud.functions.v1.CloudFunctionsServiceClient;
import com.google.cloud.functions.v1.CloudFunctionsServiceSettings;
import com.google.cloud.functions.v1.ListFunctionsRequest;
import com.google.cloud.functions.v1.LocationName;

import io.camunda.connector.api.outbound.OutboundConnectorContext;

public class GCPFunctionsConnector implements CoreOutboundConnector {

	private static final Logger LOGGER = LoggerFactory.getLogger(GCPFunctionsConnector.class);
	
	enum GCPFunctionsOperations {
		listFunctions,
		callFunction
	}


	@Override
	public Object executeContext(OutboundConnectorContext context) {
		 var input = context.bindVariables(GCPFunctionsConnectorInput.class);
		return executeConnector(input);
	}

	private Object executeConnector(GCPFunctionsConnectorInput input) {

		Object result = null;

		
			switch (GCPFunctionsOperations.valueOf(input.getInData().getGcpFunctionsOperation())) {
			case listFunctions:
				result = listFunctions(input);
				break;
			case callFunction:
				result = callFunction(input);
				break;
			default:
				throw new UnsupportedOperationException("Unsupported Operation");
			}
		return result;

	}

	private static Object listFunctions(GCPFunctionsConnectorInput input)  {

		try  {
			  
			GoogleCredentials credentials;
			String credentialsPath = input.getInData().getServiceAccountKey();
			FileInputStream serviceAccountStream = new FileInputStream(credentialsPath);
			credentials = ServiceAccountCredentials.fromStream(serviceAccountStream);
			CloudFunctionsServiceSettings cloudFunctionsServiceSettings = CloudFunctionsServiceSettings.newBuilder()
					.setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build();
			try (CloudFunctionsServiceClient cloudFunctionsServiceClient = CloudFunctionsServiceClient
					.create(cloudFunctionsServiceSettings);) {
			ListFunctionsRequest request = ListFunctionsRequest.newBuilder()
					.setParent(LocationName.of(input.getInData().getProjectId(), input.getInData().getLocation()).toString())
					.setPageSize(883849137).setPageToken("pageToken873572522").build();

			List<String> listFunctions = new ArrayList<String>();

			for (CloudFunction element : cloudFunctionsServiceClient.listFunctions(request).iterateAll()) {
				
				listFunctions.add(element.getName());

			}
			return listFunctions;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			return "Failed"+"==>"+ex.getMessage();
		}

	}

	private static Object callFunction(GCPFunctionsConnectorInput input) {

		try {

			GoogleCredentials credentials;
			String credentialsPath = input.getInData().getServiceAccountKey();
			FileInputStream serviceAccountStream = new FileInputStream(credentialsPath);
			credentials = ServiceAccountCredentials.fromStream(serviceAccountStream);
			CloudFunctionsServiceSettings cloudFunctionsServiceSettings = CloudFunctionsServiceSettings.newBuilder()
					.setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build();
			try (CloudFunctionsServiceClient cloudFunctionsServiceClient = CloudFunctionsServiceClient
					.create(cloudFunctionsServiceSettings);) {
			
			CallFunctionRequest request = CallFunctionRequest.newBuilder()
					.setName(CloudFunctionName.of(input.getInData().getProjectId(), input.getInData().getLocation(), input.getInData().getFunctionName())
							.toString())
							.build();
			CallFunctionResponse response= cloudFunctionsServiceClient.callFunction(request);
			return response.getResult();
			
			 }

			

		} catch (Exception ex) {
			ex.printStackTrace();
			return "Failed"+"==>"+ex.getMessage();
		}
	}
}

