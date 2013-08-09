package movieratings.web;

public class RottenTomatoLinks
{
	private String lists;
	private String movies;

	RottenTomatoLinks(String lists, String movies)
	{
		this.lists = lists;
		this.movies = movies;
	}

	RottenTomatoLinks()
	{ }

	public String getLists()
	{
		return lists;
	}

	public void setLists(String lists)
	{
		this.lists = lists;
	}

	public String getMovies()
	{
		return movies;
	}

	public void setMovies(String movies)
	{
		this.movies = movies;
	}
}
