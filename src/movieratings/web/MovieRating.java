package movieratings.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import movieratings.web.Movies.Movie;

import com.google.gson.Gson;

public class MovieRating
{	
	static final String apiKey = "vbbkc45gk7hcjvnvvubdhvam";
	
	public static class Links {
		private RottenTomatoLinks links;
		
		public void setRottenTomatoLinks(RottenTomatoLinks links)
		{
			this.links = links;
		}
		
		public RottenTomatoLinks getRottenTomatoLinks()
		{
			return this.links;
		}
	}
	
	public MovieRating()
	{ }
	
	public String getJson(String uri)
	{
		String json   = null;
		
		try
		{
			URL url = new URL(uri);
		
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	
			connection.setRequestMethod("GET");

			connection.setRequestProperty("Content-length", "0");
			connection.setUseCaches(false);
			connection.setAllowUserInteraction(false);
			connection.connect();
		
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder  sb = new StringBuilder();
			String line;
		
			while ((line = br.readLine()) != null) 
			{
				if (!line.isEmpty())
				{
					sb.append(line);
				}
			} 
			
			json = sb.toString();
		}
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
	}

	public Movies process(String movie)
	{
		System.out.println("Entering process");
		
		String uri = "http://api.rottentomatoes.com/api/public/v1.0.json?apikey=" + apiKey;
		
		String linkData = getJson(uri);
		
		System.out.println(linkData);
		Links links = new Gson().fromJson(linkData, Links.class);
					
		System.out.println(links.getRottenTomatoLinks().getLists());
		System.out.println(links.getRottenTomatoLinks().getMovies());
		
		String movieString = movie.replaceAll(" ", "+").toLowerCase();
		
	//	String movie = getJson(links.getRottenTomatoLinks().getMovies() + "?apikey=" + apiKey + "&q=despicable+me+2&page_limit=1");
	//	String movieJson = getJson(links.getRottenTomatoLinks().getMovies() + "?apikey=" + apiKey + "&q=" + movieString + "&page_limit=" + count);
		String movieJson = getJson(links.getRottenTomatoLinks().getMovies() + "?apikey=" + apiKey + "&q=" + movieString);


		System.out.println(movieJson);
		System.out.println("Getting here.");
		
		Movies movieInfo = new Gson().fromJson(movieJson, Movies.class);
			
		return movieInfo;

	}
	
	public static void main(String [ ] args)
	{
		System.out.println("Starting Test");

		MovieRating movies = new MovieRating();
		
		Movies movieInfo = movies.process("Schindler's List");
		
		for (Movie thisMovie : movieInfo.getMovies())
		{
				System.out.println("<img src=" + thisMovie.getPosters().detailed + ">");
				
				if (thisMovie.getRatings() != null)
				{
					System.out.println("<H2>Critics Rating = " + thisMovie.getRatings().getCritics_rating() + "</H2>");
					System.out.println("<H2>Critics Score = " + thisMovie.getRatings().getCritics_score() + "</H2>");
				}
				
				System.out.println("<p>" + thisMovie.getCritics_consensus() + "</p>");
				System.out.println("<hr>");
		}
	}
}

