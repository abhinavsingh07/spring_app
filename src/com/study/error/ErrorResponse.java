package com.study.error;

import java.util.List;

public class ErrorResponse {

	String message;
	List<String> details;

	public ErrorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}

//getters are setters are imp as error response object is sending in response entity else we get 406 unacceptable
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", details=" + details + "]";
	}

}
