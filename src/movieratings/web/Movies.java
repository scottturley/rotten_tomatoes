package movieratings.web;

import java.util.List;

public class Movies
{
	public Integer getTotal()
	{
		return total;
	}

	public List<Movie> getMovies()
	{
		return movies;
	}

	public Link getLinks()
	{
		return links;
	}

	private int total;
	private List<Movie> movies;
	private Link links;
	
	public static class Link
	{
		public String getSelf()
		{
			return self;
		}
		public String getAlternate()
		{
			return alternate;
		}
		public String getCast()
		{
			return cast;
		}
		public String getClips()
		{
			return clips;
		}
		public String getReviews()
		{
			return reviews;
		}
		public String getSimilar()
		{
			return similar;
		}
		private String self;
		private String alternate;
		private String cast;
		private String clips;
		private String reviews;
		private String similar;
	}
	
	public static class Movie
	{
		private String id;
		private String title;
		private Integer year;
		private String mpaa_rating;
		private String runtime;
		private String critics_consensus;
		private Ratings ratings;
		private String synopsis;
		private Posters posters;
		private MovieInfo links;
		
		public String getId()
		{
			return id;
		}

		public String getTitle()
		{
			return title;
		}


		public Integer getYear()
		{
			return year;
		}


		public String getMpaa_rating()
		{
			return mpaa_rating;
		}


		public String getRuntime()
		{
			return runtime;
		}


		public String getCritics_consensus()
		{
			return critics_consensus;
		}


		public Ratings getRatings()
		{
			return ratings;
		}


		public String getSynopsis()
		{
			return synopsis;
		}


		public Posters getPosters()
		{
			return posters;
		}


		public MovieInfo getLinks()
		{
			return links;
		}


		public static class Ratings
		{
			public String getCritics_rating()
			{
				return critics_rating;
			}

			public Integer getCritics_score()
			{
				return critics_score;
			}

			public String getAudience_rating()
			{
				return audience_rating;
			}

			public Integer getAudience_score()
			{
				return audience_score;
			}

			String  critics_rating;
			Integer critics_score;
			String  audience_rating;
			Integer audience_score;
			
			public Ratings() { }
		}

		public static class Posters
		{
			String thumbnail;
			String profile;
			String detailed;
			String original;
		}
		
		public static class MovieInfo
		{
			String self;
			String alternate;
			String cast;
			String clips;
			String reviews;
			String similar;
		}
		
		
		Movie() { }
	}
	
	public Movies()
	{
	}
}
