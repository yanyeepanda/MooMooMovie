package com.moomoo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.moomoo.helper.MooMooMovieHelper;
import com.moomoo.model.Cinema;
import com.moomoo.model.MooMooMovie;

// Begins the purchasing ticket process
public class MooMooMovieCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		MooMooMovieHelper helper = new MooMooMovieHelper();
		HttpSession session = request.getSession();
		session.setAttribute("helper", helper);
		forward("/moo_moo_movie.jsp");
	}

}
