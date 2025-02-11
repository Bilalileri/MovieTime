package de.hwg_lu.bw4s.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.hwg_lu.bw.jdbc.NoConnectionException;
import de.hwg_lu.bw.jdbc.PostgreSQLAccess;

public class MovieAccountBeanRegister {

	
	String  username;
	String  password;
	int     age;
	String  email;
	String  sex;
	boolean loggedIn;

	
	public MovieAccountBeanRegister() {
		super();
		this.username = "";
		this.password = "";
		this.age = 0;
		this.email = "";
		this.sex="";
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

		
	public boolean insertAccountIfNotExists() throws NoConnectionException, SQLException {
		//true  - Account wurde angelegt (gab es noch nicht)
		//false - Account existiert schon, konnte nicht angelegt werden.
		if (this.checkAccountExists()){
			return false;
		}else {
			this.insertAccountNoCheck();
			return true;
		}
	}	
		
	
	
	public void insertAccountNoCheck() throws NoConnectionException, SQLException{
		//liebes AccountBean-Objekt,
		//schreibe Dich (als Datensatz)
		//in die DB-Tabelle account
		//mit PreparedStatements
		String sql = "insert into account (username, password, age, email, sex) values (?,?,?,?,?)";
		System.out.println(sql);
		//JDBC: Connection, Statement-Objekt, Daten reinschreiben, execute
		PreparedStatement prep = new PostgreSQLAccess().getConnection().prepareStatement(sql);
		prep.setString(1, this.username);
		prep.setString(2, this.password);
		prep.setInt   (3, this.age);
		prep.setString(4, this.email);
		prep.setString(5, this.sex);
		prep.executeUpdate();
		System.out.println("Account erfolgreich angelegt");
	}
	
	
	
	
	
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isLoggedIn() {
		return loggedIn;
	}


	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	
	

}
