package com.moomoo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moomoo.mapper.CinemaMapper;
import com.moomoo.model.MooMooMovie;

/**
 * Servlet implementation class FrontController
 * Taken from swen9007 notes
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Creates command and calls the process method
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		FrontCommand command = getCommand(request);
		command.init(getServletContext(), request, response);
		command.process();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Creates command and calls the process method
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		FrontCommand command = getCommand(request);
		command.init(getServletContext(), request, response);
		command.process();
	}

	
	// Creates new command instance
	private FrontCommand getCommand(HttpServletRequest request){
		try{
			return (FrontCommand) getCommandClass(request).newInstance();
		}
		catch(Exception e){
			return null; 
		}
	}
	
	// Determines type of command according to a passed "command" parameter
	private Class getCommandClass(HttpServletRequest request){
		Class result;
		final String commandClassName = "com.moomoo.controller." + (String) request.getParameter("command") + "Command";
		try{
		    result = Class.forName(commandClassName);
		} catch(ClassNotFoundException e){
			result = null;
		}
		return result; 
	}
}
