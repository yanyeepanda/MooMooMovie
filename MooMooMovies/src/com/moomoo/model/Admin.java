package com.moomoo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

// Class to represent an admin user of the system
@Entity
public class Admin {
	private String username;
	private String password;
	
	public Admin() {}
	
	@Id
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
