package com.cts.eas.ipm.connector.gcp.outbound;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.eas.ipm.connector.gcp.input.GCPStorageConnectorInput;
import com.cts.eas.ipm.connector.outbound.CoreOutboundConnector;
import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import io.camunda.connector.api.outbound.OutboundConnectorContext;

public class GCPStorageConnector implements CoreOutboundConnector {

	private static final Logger logger = LoggerFactory.getLogger(GCPStorageConnector.class);

	enum GCPStorageOperations {

		listObjects, listBuckets, getObject,
	}

	@Override
	public Object executeContext(OutboundConnectorContext context) {
		var input = context.bindVariables(GCPStorageConnectorInput.class);
		return executeConnector(input);
	}

	private Object executeConnector(GCPStorageConnectorInput input) {

		Object result = null;

		switch (GCPStorageOperations.valueOf(input.getInData().getGcpStorageOperation())) {
		case listObjects:
			result = listObjects(input);
			break;
		case listBuckets:
			result = listBuckets(input);
			break;
		case getObject:
			result = getObjectMetadata(input);
			break;
		default:
			throw new UnsupportedOperationException("Unsupported Operation");
		}
		return result;

	}

	private Object getObjectMetadata(GCPStorageConnectorInput input) {
		// TODO Auto-generated method stub
		// input.getInData().getProjectId()
		try {
			GoogleCredentials credentials;
			String credentialsPath = input.getInData().getServiceAccountKey();
			FileInputStream serviceAccountStream = new FileInputStream(credentialsPath);
			credentials = ServiceAccountCredentials.fromStream(serviceAccountStream);

			Storage storage = StorageOptions.newBuilder().setProjectId(input.getInData().getProjectId())
					.setCredentials(credentials).build().getService();
			Blob blob = storage.get(input.getInData().getBucketName(), input.getInData().getObjectName(),
					Storage.BlobGetOption.fields(Storage.BlobField.values()));

			Map<String, Object> blobMap = new HashMap<String, Object>();
			blobMap.put("bucket", blob.getBucket());
			blobMap.put("name", blob.getName());
			blobMap.put("generation", blob.getGeneration());
			blobMap.put("size", blob.getSize());
			blobMap.put("content-type", blob.getContentType());
			blobMap.put("metadata", blob.getMetadata());
			return blobMap;
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Failed"+" "+ex.getMessage();
		}
	}

	private Object listBuckets(GCPStorageConnectorInput input) {

		try {
			GoogleCredentials credentials;
			String credentialsPath = input.getInData().getServiceAccountKey();
			FileInputStream serviceAccountStream = new FileInputStream(credentialsPath);
			credentials = ServiceAccountCredentials.fromStream(serviceAccountStream);

			Storage storage = StorageOptions.newBuilder().setProjectId(input.getInData().getProjectId())
					.setCredentials(credentials).build().getService();
			Page<Bucket> buckets = storage.list();
			List<Map<String, Object>> listObjects = new ArrayList<Map<String, Object>>();

			for (Bucket bucket : buckets.iterateAll()) {
				Map<String, Object> bucketMap = new HashMap<String, Object>();
				bucketMap.put("name", bucket.getName());
				// System.out.println(bucket.getName());
				listObjects.add(bucketMap);

			}
			return listObjects;
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Failed"+" "+ex.getMessage();
		}
	}

	private Object listObjects(GCPStorageConnectorInput input) {
		// TODO Auto-generated method stub
		try {
			GoogleCredentials credentials;
			String credentialsPath = input.getInData().getServiceAccountKey();
			FileInputStream serviceAccountStream = new FileInputStream(credentialsPath);
			credentials = ServiceAccountCredentials.fromStream(serviceAccountStream);

			Storage storage = StorageOptions.newBuilder().setProjectId(input.getInData().getProjectId())
					.setCredentials(credentials).build().getService();

			Page<Blob> blobs = storage.list(input.getInData().getBucketName());

			List<Map<String, Object>> listObjects = new ArrayList<Map<String, Object>>();

			for (Blob blob : blobs.iterateAll()) {
				Map<String, Object> blobMap = new HashMap<String, Object>();
				blobMap.put("bucket", blob.getBucket());
				blobMap.put("name", blob.getName());
				blobMap.put("generation", blob.getGeneration());
				blobMap.put("size", blob.getSize());
				blobMap.put("content-type", blob.getContentType());
				blobMap.put("metadata", blob.getMetadata());
				// System.out.println(blob.getName()+ " "+blob.getBucket);
				listObjects.add(blobMap);
			}

			return listObjects;
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Failed"+" "+ex.getMessage();
		}
	}

}
