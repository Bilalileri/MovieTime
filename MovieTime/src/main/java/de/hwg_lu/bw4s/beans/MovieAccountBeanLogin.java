package de.hwg_lu.bw4s.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.hwg_lu.bw.jdbc.NoConnectionException;
import de.hwg_lu.bw.jdbc.PostgreSQLAccess;

public class MovieAccountBeanLogin {


	
	String  username;
	String  password;
	boolean loggedIn;
	
	public MovieAccountBeanLogin() {
		super();
		this.username = "";
		this.password = "";
		this.loggedIn= false;
	}
	
	
	public boolean checkAccountExists() throws NoConnectionException, SQLException  {
		String sql = "select username, password from account where username = ? and password= ?";
		System.out.println(sql);
		PreparedStatement prep = new PostgreSQLAccess().getConnection().prepareStatement(sql);
		prep.setString(1,  this.username);
		prep.setString(2,  this.password);
		ResultSet dbRes = prep.executeQuery();
		
		if (dbRes.next()) {
			System.out.println("Account " + this.username + " existiert");
			return true;
		}else {
			System.out.println("Account " + this.username + " existiert nicht");
			return false;
		}
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isLoggedIn() {
		return loggedIn;
	}


	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	

	
}
