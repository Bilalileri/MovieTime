package de.hwg_lu.bw.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppJDBCTest {

	Connection dbConn = null;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AppJDBCTest myApp = new AppJDBCTest();
		myApp.dbConn = new PostgreSQLAccess().getConnection();
		myApp.doSomething();
	}
	public void doSomething() throws SQLException{
		//		this.dropTableAccount();
		//		this.createTableAccount();
		//		this.insertFirstAccount();
		//		this.insertMoreAccounts();
		//		this.deleteAllAccounts();
		//		this.showAllAccounts();
			
	}
	public void showAllAccounts() throws SQLException{
		String sql = "select userid, password, age, active, admin, email "
				+ "from account "
//				+ "where userid between 'testus2' and 'testus4'"
				;
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		//keine Fragezeichen -> nichts zu ersetzen
		ResultSet dbRes = prep.executeQuery();
		while(dbRes.next()){
			String userid   = dbRes.getString("userid");
			String password = dbRes.getString("password");
			int age         = dbRes.getInt("age");
			String active   = dbRes.getString("active");
			String admin    = dbRes.getString("admin");
			String email    = dbRes.getString("email");
//			if (userid.trim().equals("testus3")){
				System.out.print(userid + " ");
				System.out.print(password + " ");
				System.out.print(age + " ");
				System.out.print(active + " ");
				System.out.print(admin + " ");
				System.out.println(email + " ");
//			}
		}
	}
	
	public void deleteAllAccounts() throws SQLException{
		String sql = "delete from account";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		System.out.println(prep.executeUpdate());
		System.out.println("Account mit userid testus1 angelegt");
	} 

	public void insertMoreAccounts() throws SQLException{
		//SQL-String
		//PreparedStatement-Objekt mit oder ohne Fragezeichen
		//Wenn Fragezeichen vorhanden sind: Ersetzen durch echte Werte
		//executeUpdate oder executeQuery
		String sql = "insert into account "
				+ "(userid, password, age, active, admin, email) "
				+ "values(?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql); //Statement-Object
		for (int index = 2; index <= 6; index++){
			String userid = "testus" + index;
			String password = "geheim";
			int age = 30 + index;
			String active = "Y";
			String admin = "N";
			String email = "testus" + index + "@abc.de";
			prep.setString(1, userid);
			prep.setString(2, password);
			prep.setInt(3, age);
			prep.setString(4, active);
			prep.setString(5, admin);
			prep.setString(6, email);
			System.out.println(prep.executeUpdate());
		}
		System.out.println("testus2 bis testus 6 erfolgreich angelegt");
	}
	
	public void insertFirstAccount() throws SQLException{
		String sql = "insert into account "
						+ "(userid, password, age, active, admin, email) "
//						+ "values ('a', 'b', 1, 'Y', 'N', 'hr@abc.de')";
						+ "values(?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, "testus1");
		prep.setString(2, "geheim");
		prep.setInt(3, 29);
		prep.setString(4, "Y");
		prep.setString(5, "N");
		prep.setString(6, "hr@abc.de");
		prep.executeUpdate();
		System.out.println("Account mit userid testus1 angelegt");
	}
	
	public void dropTableAccount() throws SQLException{
		String sql = "drop table if exists account";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.executeUpdate();
		System.out.println("table account existiert jetzt nicht (mehr)");
	 }
		
	public void createTableAccount() throws SQLException{
		String sql = "create table if not exists account("
				+ "			userid   char(32)     not null primary key    ,"
				+ "			password char(32)     not null                ,"
				+ "			age      integer                              ,"
				+ "			active   char(1)      default  'Y'            ,"
				+ "			admin    char(1)      default  'N'            ,"
				+ "			email    varchar(256) default  ''              "
				+ "		)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.executeUpdate();
		System.out.println("table account existiert jetzt");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
