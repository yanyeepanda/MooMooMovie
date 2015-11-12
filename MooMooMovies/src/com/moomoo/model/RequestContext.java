package com.moomoo.model;

// Request object created for authentication
public class RequestContext {
	private String requestUsername;
	private String requestPassword;
	
	public RequestContext(String username, String password) {
		this.requestPassword = password;
		this.requestUsername = username;
	}

	public String getRequestUsername() {
		return requestUsername;
	}

	public String getRequestPassword() {
		return requestPassword;
	}
	
}
