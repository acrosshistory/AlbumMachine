package com.record.collection;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/")
public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public RecordServlet(){
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("artist", "album");
		request.setAttribute("now", new Date());
		request.getRequestDispatcher("/WEB-INF/Record.jsp").forward(request, response);
		
		
	}

}
