package mvj.practice.better;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.austinacc.capstone.QuoteManager;

/**
 *
/**
 * Servlet implementation class QuoteServlet
 */
@WebServlet("")
public class AlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/quoteDB")
	javax.sql.DataSource ds;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		AlbumManager manager = new AlbumManager(ds);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Quote.jsp");
		request.setAttribute("quotes", manager.allQuotes());
		request.setAttribute("now", new Date());
		//request.setAttribute("author", "me");
		dispatcher.forward(request, response);
		