package databaseModule.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utilitiesModule.java.BaseClass;
import loggerModule.java.*;
import loggerModule.java.LoggerSingleton.LogLevel;

public class SqlServerConnectionDB extends BaseClass implements IConnectionDB {
	private Connection _connection;
	private String _dbURL;
	private String _username;
	private String _password;
	
	public SqlServerConnectionDB(String dbUrl, String username, String password){
		super();
		_dbURL = dbUrl;
		_username = username;
		_password = password;
	}

	@Override
	public Connection getConnection() {
		if(_connection==null){
			
			String url = "jdbc:sqlserver://MYPC\\SQLEXPRESS;databaseName=MYDB";
			try {
				_connection = DriverManager.getConnection(url, _username, _password);
			} catch (SQLException ex) {
				LoggerSingleton.getLogger().writeLog(ex, LogLevel.ERROR);
			}
			return _connection;
		}
		return _connection;
	}

}
