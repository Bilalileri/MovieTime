package de.hwg_lu.bw4s.beans;

public class Movie {

	int  movie_id ;
	String title;    
	String genre;    
	int year_of_release;  
	String director; 
	double imdb_rating; 
	String brief_introduction;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Movie(int movie_id, String title, String genre, int year_of_release, String director, double imdb_rating,
			String brief_introduction) {
		super();
		this.movie_id = movie_id;
		this.title = title;
		this.genre = genre;
		this.year_of_release = year_of_release;
		this.director = director;
		this.imdb_rating = imdb_rating;
		this.brief_introduction = brief_introduction;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear_of_release() {
		return year_of_release;
	}

	public void setYear_of_release(int year_of_release) {
		this.year_of_release = year_of_release;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public double getImdb_rating() {
		return imdb_rating;
	}

	public void setImdb_rating(double imdb_rating) {
		this.imdb_rating = imdb_rating;
	}

	public String getBrief_introduction() {
		return brief_introduction;
	}

	public void setBrief_introduction(String brief_introduction) {
		this.brief_introduction = brief_introduction;
	}

	
}
