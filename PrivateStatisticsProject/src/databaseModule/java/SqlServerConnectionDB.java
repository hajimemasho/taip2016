package databaseModule.java;

import java.sql.Connection;
import java.sql.DriverManager;

import utilitiesModule.java.BaseClass;
import loggerModule.java.*;

public class SqlServerConnectionDB extends BaseClass implements IConnectionDB {
	private Connection _connection;
	private String _dbURL;
	private String _username;
	private String _password;
	
	public SqlServerConnectionDB(String dbUrl, String username, String password){
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Connection getConnection() {
		if(_connection==null){
			
			/*String url = "jdbc:sqlserver://MYPC\\SQLEXPRESS;databaseName=MYDB";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection _connection = DriverManager.getConnection(url, userName, password);*/
			return _connection;
		}
		return _connection;
	}

}
