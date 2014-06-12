package mvj.practice.better;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewAlbumServlet
 */
@WebServlet("/NewAlbumServlet")
public class NewAlbumServlet extends HttpServlet {
	package edu.austinacc.capstone;

	import java.io.IOException;

	import javax.annotation.Resource;
	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import com.sun.tools.internal.ws.processor.model.Request;

	/**
	 * Servlet implementation class NewQuoteServlet
	 */
	@WebServlet("/new")
	public class NewAlbumServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		@Resource(name="jdbc/quoteDB")
		javax.sql.DataSource ds;
		
	       
	 
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("/WEB-INF/NewJSP.jsp").forward(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String text = request.getParameter("album");
			String author = request.getParameter("artist");
			System.out.println("post" + album + " -> " + artist);
			
			Album album = new Album(album,artist);
			AlbumManager manager = new AlbumManager(ds);
			
			
			if (manager.newAlbum(album)) {
				
				response.sendRedirect("/");
			} else{
				
				request.getRequestDispatcher("/WEB-INF/NewJSP.jsp").forward(request, response);
				
			}
		}

	}
