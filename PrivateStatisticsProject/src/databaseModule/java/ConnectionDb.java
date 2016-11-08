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
			mySqlConnection = new MySQLConnectionDB("","","");
		}
		return mySqlConnection.getConnection();
	}

	public static Connection geSqlServerConnection(){
		if(sqlServerConnection == null){
			sqlServerConnection = new SqlServerConnectionDB("","","");
		}
		return sqlServerConnection.getConnection();
	}
}
