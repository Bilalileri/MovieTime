package de.hwg_lu.bw4s.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import de.hwg_lu.bw.jdbc.NoConnectionException;
import de.hwg_lu.bw.jdbc.PostgreSQLAccess;

public class MovieBean {

	
	Vector<Movie> allMovies; // erst mal null
	int selectedMovieId ; // this one is for when we select a movie to see more infos about it
	String chosenCategorie;
	String addedReview;

	public MovieBean(){
		this.allMovies = new Vector<Movie>();
		this.chosenCategorie="";
		this.selectedMovieId=0;
		this.addedReview="";
	}
	
	
	
	public String getMoviesFromDB() throws NoConnectionException, SQLException {
		this.allMovies = new Vector<Movie>();
		String sql = "SELECT MovieId, Title, Genre, YearOfRelease, Director, ImdbRating, BriefIntroduction FROM Movie ORDER BY RANDOM();";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		ResultSet dbRes = prep.executeQuery();
		while(dbRes.next()) {
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
	    String html = "<table class='table table-borderless text-white'>"; // Bootstrap table class with white text
		for (int i = 0; i < allMovies.size(); i += 5) {
			html += "<tr>";
			for (int j = 0; j < 5; j++) {
				if (i + j < allMovies.size()) {
					Movie movie = allMovies.get(i+j);
	                html += "<td class='bg-black'>"; // Siyah arka plan rengi için sınıf ekleyin
	                html += "<a href='./HomepageAppl.jsp?chosenElement=" + movie.getMovie_id() + "'>";
	                html += "<div class='thumbnail-container'>";
	                html += "<img src='../img/" + movie.getMovie_id() + ".jpg'  title='" + movie.getTitle() + "' class='img-fluid movie-poster' />";
	                html += "</div></a></td>";
	            } else {
	                html += "<td class='bg-black'></td>"; // Boş hücre ekleyin ve siyah arka plan rengi için sınıf ekleyin
	            }
	        }
	        html += "</tr>";
	    }
	    html += "</table>";
	    return html;
	}
	
	
	
	public String getMoviesFromDBRefined() throws NoConnectionException, SQLException {
		this.allMovies = new Vector<Movie>();
		String sql = "SELECT MovieId, Title, Genre, YearOfRelease, Director, ImdbRating, BriefIntroduction FROM Movie where Genre = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.chosenCategorie);
		ResultSet dbRes = prep.executeQuery();
		while(dbRes.next()) {
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
	    String html = "<table class='table table-borderless text-white'>"; // Bootstrap table class with white text
		for (int i = 0; i < allMovies.size(); i += 5) {
			html += "<tr>";
			for (int j = 0; j < 5; j++) {
				if (i + j < allMovies.size()) {
					Movie movie = allMovies.get(i+j);
	                html += "<td class='bg-black'>"; // Siyah arka plan rengi için sınıf ekleyin
	                html += "<a href='./CategorieViewAppl.jsp?chosenElement=" + movie.getMovie_id() + "'>";
	                html += "<div class='thumbnail-container'>";
	                html += "<img src='../img/" + movie.getMovie_id() + ".jpg'  title='" + movie.getTitle() + "' class='img-fluid movie-poster' />";
	                html += "</div></a></td>";
	            } else {
	                html += "<td class='bg-black'></td>"; // Boş hücre ekleyin ve siyah arka plan rengi için sınıf ekleyin
	            }
	        }
	        html += "</tr>";
	    }

	    html += "</table>";
	    return html;
	}
		
	public String getBest60MoviesFromDB() throws NoConnectionException, SQLException {
		this.allMovies = new Vector<Movie>();
		String sql = "SELECT MovieId, Title, Genre, YearOfRelease, Director, ImdbRating, BriefIntroduction FROM Movie ORDER BY ImdbRating DESC LIMIT 60";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		ResultSet dbRes = prep.executeQuery();
		while(dbRes.next()) {
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
		 String html = "<ol class='list-group list-group-numbered'>";
		    for (Movie movie : allMovies) {
		        html += "<li class='list-group-item d-flex align-items-center'>";
		        html += "<img src='../img/" + movie.getMovie_id() + ".jpg' alt='Movie Poster' class='img-fluid' style='width: 50px; height: 75px; margin-right: 15px;'>";
		        html += "<div>";
		        html += "<h5 class='mb-1'><a href='./Best60Appl.jsp?chosenElement=" + movie.getMovie_id() + "' class='text-decoration-none text-dark'>" + movie.getTitle() + "</a></h5>"; // Tıklanabilir film ismi
		        html += "<small>IMDb: " + movie.getImdb_rating() + "</small>";
		        html += "</div>";
		        html += "</li>";
		    }
		    html += "</ol>";
		    
		    return html;
		}
	
	
	
	
	public String getInfosAsHtmlForSelectedPoster() throws NoConnectionException, SQLException {
	    String sql = "SELECT Title, Genre, YearOfRelease, Director, ImdbRating, BriefIntroduction FROM Movie where MovieId = ?";
	    Connection dbConn = new PostgreSQLAccess().getConnection();
	    PreparedStatement prep = dbConn.prepareStatement(sql);
	    prep.setInt(1, this.selectedMovieId);
	    ResultSet dbRes = prep.executeQuery();
	    String html = "<ol class='list-group list-group-numbered'>"; // Bootstrap ordered list

	    while (dbRes.next()) {
	        html += "<li class='list-group-item d-flex justify-content-between align-items-start'>";
	        html += "<div class='ms-2 me-auto'>";
	        html += "<div class='fw-bold'>Name</div>" + dbRes.getString("Title").trim() + "</div>";
	        html += "</li>";
	        
	        html += "<li class='list-group-item d-flex justify-content-between align-items-start'>";
	        html += "<div class='ms-2 me-auto'>";
	        html += "<div class='fw-bold'>Director</div>" + dbRes.getString("Director").trim() + "</div>";
	        html += "</li>";
	        
	        html += "<li class='list-group-item d-flex justify-content-between align-items-start'>";
	        html += "<div class='ms-2 me-auto'>";
	        html += "<div class='fw-bold'>Category</div><a href='./ViewInfosSelectedPosterAppl.jsp?selectedKategorie="+dbRes.getString("Genre").trim()+"'>" + dbRes.getString("Genre").trim() + "</a></div>";
	        html += "</li>";
	        
	        html += "<li class='list-group-item d-flex justify-content-between align-items-start'>";
	        html += "<div class='ms-2 me-auto'>";
	        html += "<div class='fw-bold'>Year of release</div>" + dbRes.getInt("YearOfRelease") + "</div>";
	        html += "</li>";
	        
	        html += "<li class='list-group-item d-flex justify-content-between align-items-start'>";
	        html += "<div class='ms-2 me-auto'>";
	        html += "<div class='fw-bold'>IMDb rating</div>" + dbRes.getDouble("ImdbRating") + "</div>";
	        html += "</li>";
	        
	        html += "<li class='list-group-item d-flex justify-content-between align-items-start'>";
	        html += "<div class='ms-2 me-auto'>";
	        html += "<div class='fw-bold'>Resume</div>" + dbRes.getString("BriefIntroduction").trim() + "</div>";
	        html += "</li>";
	    }

	    html += "</ol>";
	    return html;
	}
		
	public String getReviewsForSelectedPoster() throws NoConnectionException, SQLException {
	    String sql = "SELECT review FROM Review where MovieId = ?";
	    Connection dbConn = new PostgreSQLAccess().getConnection();
	    PreparedStatement prep = dbConn.prepareStatement(sql);
	    prep.setInt(1, this.selectedMovieId);
	    ResultSet dbRes = prep.executeQuery();
	    String html = "<ol class='list-group list-group-numbered'>";
	    while (dbRes.next()) {
	        html += "<li class='list-group-item'>" + dbRes.getString("review").trim() + "</li>\n";
	    }
	    html += "</ol>";
	    return html;
	}
	
	
	public void insertReviewForSelectedPoster() throws NoConnectionException, SQLException{
		//liebes AccountBean-Objekt,
		//schreibe Dich (als Datensatz)
		//in die DB-Tabelle account
		//mit PreparedStatements
		String sql = "insert into Review (MovieId, Review) values (?,?)";
		System.out.println(sql);
		//JDBC: Connection, Statement-Objekt, Daten reinschreiben, execute
		PreparedStatement prep = new PostgreSQLAccess().getConnection().prepareStatement(sql);
		prep.setInt(1, this.selectedMovieId);
		prep.setString(2, this.addedReview);
		
		prep.executeUpdate();
		System.out.println("Review Succesfully added");
	}
	
		
	
	
	
	
	
	
	public Vector<Movie> getAllMovies() {
		return allMovies;
	}

	public void setAllMovies(Vector<Movie> allMovies) {
		this.allMovies = allMovies;
	}

	public String getChosenCategorie() {
		return chosenCategorie;
	}

	public void setChosenCategorie(String chosenCategorie) {
		this.chosenCategorie = chosenCategorie;
	}

	public int getSelectedMovieId() {
		return selectedMovieId;
	}

	public void setSelectedMovieId(int selectedMovieId) {
		this.selectedMovieId = selectedMovieId;
	}


	public String getAddedReview() {
		return addedReview;
	}

	public void setAddedReview(String addedReview) {
		this.addedReview = addedReview;
	}


	
}





