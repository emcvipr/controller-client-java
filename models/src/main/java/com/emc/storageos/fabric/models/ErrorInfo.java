package com.emc.storageos.fabric.models;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("error")
@XmlRootElement(name = "error")
public class ErrorInfo {
	
	private ErrorCode code;
	
	public ErrorCode getCode() {
		return code;
	}

	public void setCode(ErrorCode code) {
		this.code = code;
	}
	
	public ErrorInfo() {
	}
	
	public ErrorInfo(ErrorCode code) {
		this.code = code;
	}
	public enum ErrorCode {
		MISSING_PARAMETERS,
		SERVICE_ALREADY_PROVISIONED,
		SERVICE_NOT_FOUND,
	}
}