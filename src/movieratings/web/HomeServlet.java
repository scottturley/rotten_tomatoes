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

import org.apache.log4j.Logger;

public class HomeServlet extends HttpServlet
{	
	private RequestDispatcher homeJsp;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		ServletContext context = config.getServletContext();
		homeJsp = context.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
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

		PrintWriter writer = resp.getWriter();		
		System.out.println("Starting Test");
		

		MovieRating movies = new MovieRating();		
//		Movies movieInfo = movies.process("Despicable Me 2");
		Movies movieInfo = movies.process(movie);
		
		if (!movieInfo.getMovies().isEmpty())
		{
			writer.println("<img src=" + movieInfo.getMovies().get(0).getPosters().detailed + ">");
			writer.println("<H2>Critics Rating = " + movieInfo.getMovies().get(0).getRatings().critics_rating + "</H2>");
			writer.println("<H2>Critics Rating = " + movieInfo.getMovies().get(0).getRatings().critics_score + "</H2>");
			writer.println("<p>" + movieInfo.getMovies().get(0).getCritics_consensus() + "</p>");
		}
		else
		{
			writer.println("Couldn't find this movie");
		}
	}
}

