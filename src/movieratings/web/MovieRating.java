package movieratings.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
	//	String movieJson = getJson(links.getRottenTomatoLinks().getMovies() + "?apikey=" + apiKey + "&q=" + movieString + "&page_limit=1");
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
		
		Movies movieInfo = movies.process("Hannah");
				
		if (!movieInfo.getMovies().isEmpty())
		{
			System.out.println("Critics Rating = " + movieInfo.getMovies().get(0).getRatings().critics_rating);
			System.out.println("Critics Rating = " + movieInfo.getMovies().get(0).getRatings().critics_score);
			
		}
		else
		{
			System.out.println("Couldn't find this movie");
		}
	}
}

