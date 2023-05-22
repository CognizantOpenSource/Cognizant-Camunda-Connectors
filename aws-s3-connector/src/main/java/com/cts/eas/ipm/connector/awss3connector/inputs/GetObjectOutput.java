package com.cts.eas.ipm.connector.awss3connector.inputs;

import java.time.Instant;

public class GetObjectOutput {

	private String key;
	private String contentType;
	private String eTag;
	private Instant lastModified;

	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String geteTag() {
		return eTag;
	}

	public void seteTag(String eTag) {
		this.eTag = eTag;
	}

	

	public Instant getLastModified() {
		return lastModified;
	}

	public void setLastModified(Instant lastModified) {
		this.lastModified = lastModified;
	}
    

	public GetObjectOutput(String key,String contentType, String eTag, Instant lastModified) {
		super();
		this.key=key;
		this.contentType=contentType;
		this.eTag=eTag;
		this.lastModified=lastModified;	
	}

	@Override
	public String toString() {
		return "getObjectOutput [key=" + key + ", contentType=" + contentType + ", eTag=" + eTag + ", lastModified=" + lastModified +  "]";
	}

}
