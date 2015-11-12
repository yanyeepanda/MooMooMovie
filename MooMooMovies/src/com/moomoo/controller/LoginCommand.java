package com.moomoo.controller;

import java.io.IOException;

import javax.servlet.ServletException;

// Sends to login form
public class LoginCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		forward("/login.jsp");
	}

}
