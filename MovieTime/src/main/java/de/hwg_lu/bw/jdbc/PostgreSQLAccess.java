package de.hwg_lu.bw.jdbc;


import java.sql.Connection;
import java.sql.SQLException;

public class PostgreSQLAccess extends JDBCAccess {

	public PostgreSQLAccess() throws NoConnectionException {
		super();
	}
	public void setDBParms(){
		dbDrivername = "org.postgresql.Driver";
		dbURL        = "jdbc:postgresql://143.93.200.243:5435/BWUEBDB";
		dbUser       = "user1";
		dbPassword   = "pgusers";
//		dbURL        = "jdbc:postgresql://localhost:5432/BWUEBDB";
//		dbUser       = "postgres";
//		dbPassword   = "pgadmin";
		dbSchema     = "bwi520_636093"; // hier Matrikelnummer eintragen
		
	}
	public static void main(String[] args) throws NoConnectionException { 
		
		new PostgreSQLAccess().getConnection();
		
	}

}

