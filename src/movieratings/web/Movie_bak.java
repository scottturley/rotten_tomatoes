package movieratings.web;

import java.util.List;

public class Movies
{
	private int total;
	private List<Movie> movies;
	private Link links;
	private String link_template;
	
	public static class Link
	{
		public String getSelf()
		{
			return self;
		}

		public void setSelf(String self)
		{
			this.self = self;
		}

		public String getAlternate()
		{
			return alternate;
		}

		public void setAlternate(String alternate)
		{
			this.alternate = alternate;
		}

		public String getCast()
		{
			return cast;
		}

		public void setCast(String cast)
		{
			this.cast = cast;
		}

		public String getClips()
		{
			return clips;
		}

		public void setClips(String clips)
		{
			this.clips = clips;
		}

		public String getReviews()
		{
			return reviews;
		}

		public void setReviews(String reviews)
		{
			this.reviews = reviews;
		}

		public String getSimilar()
		{
			return similar;
		}

		public void setSimilar(String similar)
		{
			this.similar = similar;
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
		private Integer runtime;
		private String critics_consensus;
		private ReleaseDates release_dates;
		private Ratings ratings;
		private String synopsis;
		private Posters posters;
		private List<AbridgedCast> abridged_cast;
		private AlternateIds alternate_ids;
		private MovieInfo links;
		
		Movie() { }
		
		public static class ReleaseDates
		{
			String theater;
			String dvd;
			
			public ReleaseDates() { }
		}
		
		public static class Ratings
		{
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
		
		public static class AbridgedCast
		{
			String name;
			String id;
			List<String> characters;
		}
		
		public static class AlternateIds
		{
			String imdb;
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

		public String getId()
		{
			return id;
		}

		public void setId(String id)
		{
			this.id = id;
		}

		public String getTitle()
		{
			return title;
		}

		public void setTitle(String title)
		{
			this.title = title;
		}

		public Integer getYear()
		{
			return year;
		}

		public void setYear(Integer year)
		{
			this.year = year;
		}

		public Integer getRuntime()
		{
			return runtime;
		}

		public void setRuntime(Integer runtime)
		{
			this.runtime = runtime;
		}

		public String getCritics_consensus()
		{
			return critics_consensus;
		}

		public void setCritics_consensus(String critics_consensus)
		{
			this.critics_consensus = critics_consensus;
		}

		public ReleaseDates getRelease_dates()
		{
			return release_dates;
		}

		public void setRelease_dates(ReleaseDates release_dates)
		{
			this.release_dates = release_dates;
		}

		public Ratings getRatings()
		{
			return ratings;
		}

		public void setRatings(Ratings ratings)
		{
			this.ratings = ratings;
		}

		public String getSynopsis()
		{
			return synopsis;
		}

		public void setSynopsis(String synopsis)
		{
			this.synopsis = synopsis;
		}

		public Posters getPosters()
		{
			return posters;
		}

		public void setPosters(Posters posters)
		{
			this.posters = posters;
		}

		public List<AbridgedCast> getAbridged_cast()
		{
			return abridged_cast;
		}

		public void setAbridged_cast(List<AbridgedCast> abridged_cast)
		{
			this.abridged_cast = abridged_cast;
		}

		public AlternateIds getAlternate_ids()
		{
			return alternate_ids;
		}

		public void setAlternate_ids(AlternateIds alternate_ids)
		{
			this.alternate_ids = alternate_ids;
		}

		public MovieInfo getLinks()
		{
			return links;
		}

		public void setLinks(MovieInfo links)
		{
			this.links = links;
		}

		public String getMpaa_rating()
		{
			return mpaa_rating;
		}

		public void setMpaa_rating(String mpaa_rating)
		{
			this.mpaa_rating = mpaa_rating;
		}
		
	}
	
	public Movies()
	{
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

	public List<Movie> getMovies()
	{
		return movies;
	}

	public void setMovies(List<Movie> movies)
	{
		this.movies = movies;
	}

	public Link getLinks()
	{
		return links;
	}

	public void setLinks(Link links)
	{
		this.links = links;
	}

	public String getLink_template()
	{
		return link_template;
	}

	public void setLink_template(String link_template)
	{
		this.link_template = link_template;
	}

}
