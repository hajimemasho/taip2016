package databaseModule.java;

import java.sql.Connection;

import utilitiesModule.java.BaseClass;
import loggerModule.java.*;

public class ConnectionDb extends BaseClass {
	private static IConnectionDB mySqlConnection;
	private static IConnectionDB sqlServerConnection;
	
	private ConnectionDb(){
		
		super();
	}
	
	public static Connection getMySqlConnection(){
		if(mySqlConnection == null){
			String dbUrl="";
			String username="";
			String password="";
			mySqlConnection = new MySQLConnectionDB(dbUrl,username,password);
		}
		return mySqlConnection.getConnection();
	}

	public static Connection getSqlServerConnection(){
		if(sqlServerConnection == null){
			String dbUrl="";
			String username="";
			String password="";
			sqlServerConnection = new SqlServerConnectionDB(dbUrl, username, password);
		}
		return sqlServerConnection.getConnection();
	}
}
