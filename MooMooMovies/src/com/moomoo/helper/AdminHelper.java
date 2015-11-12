package com.moomoo.helper;

import com.moomoo.model.Admin;

// Helper for Admin class for JSP pages
public class AdminHelper {
	private Admin admin;
	
	public AdminHelper(Admin admin) {
		this.admin = admin;
	}
	
	// Get admin username
	public String getUsername(){
		return admin.getUsername();
	}
}
