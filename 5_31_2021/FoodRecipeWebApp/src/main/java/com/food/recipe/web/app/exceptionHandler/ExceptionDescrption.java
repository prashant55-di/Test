package com.food.recipe.web.app.exceptionHandler;

import java.util.Date;

import org.springframework.stereotype.Component;
 
@Component
public class ExceptionDescrption extends RuntimeException{
	
	private Date timestamp;
	
	private String errorCode;
	private String errorMessage;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public ExceptionDescrption(Date timestamp, String errorCode, String errorMessage) {
		super();
		this.timestamp = timestamp;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public ExceptionDescrption()
	{
		
	}
	@Override
	public String toString() {
		return "ExceptionDescrption [timestamp=" + timestamp + ", errorCode=" + errorCode + ", errorMessage="
				+ errorMessage + "]";
	}
	

}
