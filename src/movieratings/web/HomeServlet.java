package movieratings.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet
{	
	private RequestDispatcher homeJsp;
	private RequestDispatcher movieJsp;
	
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		ServletContext context = config.getServletContext();
		homeJsp = context.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		movieJsp = context.getRequestDispatcher("/WEB-INF/jsp/movies.jsp");
	}
	
//	public void init(ServletConfig config) throws ServletException
//	{
//		String jsp_path = config.getInitParameter("jsp-path");
//		System.out.println("Initializating, jsp path = " + jsp_path);
//		ServletContext context = config.getServletContext();
//		jsp = context.getRequestDispatcher(config.getInitParameter("jsp-path"));
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("doGet()");

	    homeJsp.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String movie = req.getParameter("movie");	
		
		System.out.println("Movie = " + movie);
		System.out.println("Starting Test");

		MovieRating movies = new MovieRating();		
		Movies movieInfo = movies.process(movie);
			
		if (movieInfo.getMovies().isEmpty())
		{
			PrintWriter writer = resp.getWriter();	
			
			writer.write("<H2>Sorry Movie Not Found</H2>");
			
			writer.println("<H2>Sorry Movie Not Found</H2>");
		}
		else
		{
			req.setAttribute("movies", movieInfo.getMovies());
			movieJsp.forward(req, resp);
		}
	}
}

