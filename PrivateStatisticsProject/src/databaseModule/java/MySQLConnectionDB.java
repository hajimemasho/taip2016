package databaseModule.java;

import java.sql.Connection;
import java.sql.DriverManager;

import utilitiesModule.java.BaseClass;
import loggerModule.java.*;

public class MySQLConnectionDB extends BaseClass implements IConnectionDB{
	
	private Connection _connection;
	private String _username;
	private String _password;
	private String _dbURL;
	private String _port;
	
	public MySQLConnectionDB(String dbUrl, String username, String password){
				super();
	}
	
	//singleton
	@Override
	public Connection getConnection(){
		if(_connection==null){

			/*_connection = DriverManager.getConnection(
			                   "jdbc:" + this.dbms + "://" +
			                   this._dbURL +
			                   ":" + this._port + "/",
			                   connectionProps);*/
			    return _connection;
		}
		return _connection;
	}
}
