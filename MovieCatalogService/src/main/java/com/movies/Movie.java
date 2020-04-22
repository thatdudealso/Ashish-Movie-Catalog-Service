package com.movies;

public class Movie {
	private String movieId;
	private String name;
	private String getOverview;
	
	public Movie(String movieId, String name, String getOverview) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.getOverview = getOverview;
	}
	public Movie() {}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Movie(String movieId, String name) {
		super();
		this.movieId = movieId;
		this.name = name;
	}
	
	
}
