package com.emcopentechnologies.viprcloudstorage;

import java.io.Serializable;

public class CloudBlob implements Serializable {

	private static final long serialVersionUID = -1873484056669542679L;
	
	private final String blobName;
	private final String blobURL;
	
	public CloudBlob(String blobName, String blobURL) {
		this.blobName = blobName;
		this.blobURL = blobURL;
	}

	public String getBlobName() {
		return blobName;
	}
	
	public String getBlobURL() {
		return blobURL;
	}

	@Override
	public String toString() {
		return "CloudBlob [blobName=" + blobName + ", blobURL="
				+ blobURL + "]";
	}
	
	
}
