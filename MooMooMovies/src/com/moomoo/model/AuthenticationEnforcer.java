package com.moomoo.model;

import com.moomoo.mapper.AdminMapper;

// Class responsible for handling authentication
public class AuthenticationEnforcer {
	public static Admin validateCredentials(RequestContext request) {
		String username = request.getRequestUsername();
		Admin admin = AdminMapper.retrieveAdmin(username);
		if (admin != null && admin.getPassword().equals(request.getRequestPassword())) {
			return admin;
		} else {
			return null;
		}
	}
}
