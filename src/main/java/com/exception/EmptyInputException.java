package com.exception;

public class EmptyInputException extends RuntimeException {

	String errorCode;
	String errorMessage;

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public EmptyInputException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public EmptyInputException() {
		// TODO Auto-generated constructor stub
	}

}
