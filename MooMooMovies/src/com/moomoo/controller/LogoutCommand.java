package com.moomoo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

// Command for logout
public class LogoutCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// Remove admin from session
		HttpSession session = request.getSession();
		session.setAttribute("admin", null);
		forward("/logout.jsp");
	}

}
