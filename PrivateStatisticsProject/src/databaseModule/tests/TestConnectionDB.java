package databaseModule.tests;

import databaseModule.java.ConnectionDb;

public class TestConnectionDB {

	public TestConnectionDB(){
		
	}
	
	public boolean testGetMysqlConnection(){
		return ConnectionDb.getMySqlConnection() != null;
	}
	
	public boolean testGetSqlServerConnection(){
		return ConnectionDb.geSqlServerConnection()!= null;
	}
}
