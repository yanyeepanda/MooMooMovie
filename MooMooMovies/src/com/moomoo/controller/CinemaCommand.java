package com.moomoo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.moomoo.helper.CinemaHelper;
import com.moomoo.model.Cinema;

// Open cinema screen based on cinema selected
public class CinemaCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		long id = Long.valueOf(request.getParameter("cinema").replace(" ", ""));
		Cinema cinema = Cinema.findById(id);

		CinemaHelper helper = new CinemaHelper(cinema);
		HttpSession session = request.getSession();
		session.setAttribute("helper", helper);
		session.setAttribute("searchResults", false);
		forward("/cinema.jsp");
	}

}
