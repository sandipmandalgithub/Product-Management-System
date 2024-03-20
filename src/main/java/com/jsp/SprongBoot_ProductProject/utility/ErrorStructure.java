package com.jsp.SprongBoot_ProductProject.utility;

import org.springframework.stereotype.Component;

@Component
public class ErrorStructure<T> {
	private int errorStatusCode;
	private String errorMessage;
	private T errorData;
	public int getErrorStatusCode() {
		return errorStatusCode;
	}
	public ErrorStructure<T> setErrorStatusCode(int errorStatusCode) {
		this.errorStatusCode = errorStatusCode;
		return this;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public ErrorStructure<T> setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}
	public T getErrorData() {
		return errorData;
	}
	public ErrorStructure<T> setErrorData(T errorData) {
		this.errorData = errorData;
		return this;
	}
	@Override
	public String toString() {
		return "ErrorStructure [errorStatusCode=" + errorStatusCode + ", errorMessage=" + errorMessage + ", errorData="
				+ errorData + "]";
	}
	

}
