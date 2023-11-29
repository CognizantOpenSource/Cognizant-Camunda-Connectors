package com.cts.eas.ipm.connector.azureblobstorageconnector.inputs.dtos;

import java.io.IOException;

import com.azure.storage.blob.models.BlobProperties;

public class BlobResponse {

	private final BlobProperties blobProperties;

	private final String fileData;

	private BlobResponse(String fileData, BlobProperties blobProperties) {
		this.blobProperties = blobProperties;
		this.fileData = fileData;
	}

	public BlobProperties getBlobProperties() {
		return blobProperties;
	}

	public String getFileData() {
		return fileData;
	}

	public static BlobResponse withResponse(String fileData, BlobProperties blobProperties) throws IOException {
		return new BlobResponse(fileData, blobProperties);
	}

}
