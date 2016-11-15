package databaseModule.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

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
				_dbURL = dbUrl;
				_username=username;
				_password= password;
	}
	
	//singleton
	@Override
	public Connection getConnection(){
		if(_connection==null){

			try{
			_connection = DriverManager.getConnection(
			                   "jdbc:mysql://" +
			                   this._dbURL +
			                   "?user=" + this._username +
			                   "&password=" + this._password);
			    return _connection;
			}catch(SQLException ex){
				LoggerSingleton.getLogger().writeLog(ex, LoggerSingleton.LogLevel.ERROR);
			}
		}
		return _connection;
	}
}
