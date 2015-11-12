package com.moomoo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Abstract command all concrete commands inherit from for command pattern
// Taken from swen90007 notes
public abstract class FrontCommand {
	protected ServletContext context; 
	protected HttpServletRequest request; 
	protected HttpServletResponse response;
	
	// Initialising method
	public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response){
		this.context = context;
		this.request = request; 
		this.response = response;
	}
	
	// Method each concrete command implements independently
	abstract public void process() throws ServletException, IOException;
	
	// Helper method for directing which page to send to
	protected void forward(String target) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = context.getRequestDispatcher(target);
		dispatcher.forward(request, response);
	}
}
