package de.hwg_lu.bw4s.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import de.hwg_lu.bw.jdbc.NoConnectionException;
import de.hwg_lu.bw.jdbc.PostgreSQLAccess;

public class BucketlistBean {
	
	
	int selectedMovieId ;
	// in the table account we add a bucket id as fremdschluüssel make it a sequel
	ArrayList<Movie> allMovies;
	String  username;

	
	public void AddtoBucketlist() throws NoConnectionException, SQLException {
		String sql ="INSERT INTO Bucketlist (username, movieid) VALUES (?, ARRAY[?])";
		sql += " ON CONFLICT (username)"; 
		sql += " DO UPDATE"; 
		sql += " SET movieid = Bucketlist.movieid || EXCLUDED.movieid"; 
		System.out.println(sql);
		PreparedStatement prep = new PostgreSQLAccess().getConnection().prepareStatement(sql);
		prep.setString(1, username);
		prep.setInt(2, selectedMovieId);
		prep.executeUpdate();
	}
	
	
	public String getMoviesFromBucketlist() throws NoConnectionException, SQLException {
		 String sql = "SELECT m.* FROM Bucketlist b JOIN Movie m ON m.MovieId = ANY(b.movieid) WHERE b.username = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, username);
		ResultSet dbRes = prep.executeQuery();
		String html="<ol class='list-group list-group-numbered'>";
	   
		this.allMovies = new ArrayList<Movie>();
	    boolean hasMovies = false;
	    
	    while (dbRes.next()) {
	        hasMovies = true;
	        this.allMovies.add(new Movie(
	            dbRes.getInt("MovieId"), 
	            dbRes.getString("Title").trim(),
	            dbRes.getString("Genre").trim(),
	            dbRes.getInt("YearOfRelease"),
	            dbRes.getString("Director").trim(),
	            dbRes.getDouble("ImdbRating"),
	            dbRes.getString("BriefIntroduction").trim())
	        );
	    }
	    
	    if (!hasMovies){
	        html += "Unfortunately, your Bucketlist is empty, feel free to fill it.<br>";
	        html += "We have action movies, drama, fantasy, whatever your soul desires.";
	    }
		for (Movie movie : allMovies) {
	
	        html += "<li class='list-group-item d-flex align-items-center'>";
	        html += "<img src='../img/" + movie.getMovie_id() + ".jpg' alt='Movie Poster' class='img-fluid' style='width: 50px; height: 75px; margin-right: 15px;'>";
	        html += "<div>";
	        html += "<h5 class='mb-1'><a href='./BucketlistAppl.jsp?chosenElement=" + movie.getMovie_id() + "' class='text-decoration-none text-dark'>" + movie.getTitle() + "</a></h5>"; // Tıklanabilir film ismi
	        html += "<small>IMDb: " + movie.getImdb_rating() + "</small>";
	        html += "</div>";
	        html += "</li>";
	    }
	    html += "</ol>";  
	    return html;
	}
	
	
	public void RemovefromBucketlist() throws NoConnectionException, SQLException {
		String sql = "UPDATE Bucketlist";
	    sql += " SET movieid = CASE";
	    sql += " WHEN ? = ANY(movieid) THEN array_remove(movieid, ?)";
	    sql += " ELSE movieid";
	    sql += " END";
	    sql += " WHERE username = ?";
		System.out.println(sql);
		PreparedStatement prep = new PostgreSQLAccess().getConnection().prepareStatement(sql);
		prep.setInt(1, selectedMovieId);
		prep.setInt(2, selectedMovieId);
		prep.setString(3, username);
		prep.executeUpdate();
	}
	
	public boolean checkMovieInBucketlist() throws NoConnectionException, SQLException {
	    String sql = "SELECT username FROM Bucketlist WHERE username = ? AND array_position(movieid, ?) IS NOT NULL";
	    System.out.println(sql);
	    
	    PreparedStatement prep = new PostgreSQLAccess().getConnection().prepareStatement(sql);
	    prep.setString(1, this.username); // Set the username
	    prep.setInt(2, this.selectedMovieId); // Set the movie ID to check
	    
	    ResultSet dbRes = prep.executeQuery();
	    
	    // Check if a row was returned, meaning the movie exists in the user's bucket list
	    if (dbRes.next()) {
	        System.out.println("Movie " + this.selectedMovieId + " is already in " + this.username + "'s bucket list");
	        return true;
	    } else {
	        System.out.println("Movie " + this.selectedMovieId + " is not in " + this.username + "'s bucket list");
	        return false;
	    }
	}

	
	
	
	
	
	public int getSelectedMovieId() {
		return selectedMovieId;
	}

	public void setSelectedMovieId(int selectedMovieId) {
		this.selectedMovieId = selectedMovieId;
	}


	public ArrayList<Movie> getAllMovies() {
		return allMovies;
	}

	public void setAllMovies(ArrayList<Movie> allMovies) {
		this.allMovies = allMovies;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public BucketlistBean() {
		// TODO Auto-generated constructor stub
	}

}
