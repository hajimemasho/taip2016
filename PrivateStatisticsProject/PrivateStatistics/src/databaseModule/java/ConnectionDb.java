package databaseModule.java;

import java.sql.Connection;

import utilitiesModule.java.BaseClass;
import loggerModule.java.*;

public class ConnectionDb extends BaseClass {
	private static IConnectionDB mySqlConnection;
	private static IConnectionDB sqlServerConnection;
	
	
	public ConnectionDb(){	
		super();
	}
	
//	private ConnectionDb(){
//		
//		super();
//	}
	
	public static Connection getMySqlConnection(){
		if(mySqlConnection == null){
			String dbUrl="localhost/dbo";
			String username="sa";
			String password="1234";
			mySqlConnection = new MySQLConnectionDB(dbUrl,username,password);
		}
		return mySqlConnection.getConnection();
	}
	
	public IConnectionDB getMySqlConnectionDB(){
		if(mySqlConnection== null){
			ConnectionDb.getMySqlConnection();
		}
		return mySqlConnection;
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

	public IConnectionDB getSqlServerConnectionDB(){
		if(sqlServerConnection== null){
			ConnectionDb.getSqlServerConnection();
		}
		return sqlServerConnection;
	}
}
