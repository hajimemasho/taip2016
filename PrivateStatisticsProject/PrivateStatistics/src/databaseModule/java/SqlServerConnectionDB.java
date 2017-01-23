package databaseModule.java;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
				try {
					LoggerSingleton.getLogger("INFO").writeLog(ex.getMessage(), LogLevel.ERROR);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return _connection;
		}
		return _connection;
	}

	@Override
	public List<String> getSecurePatientName() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
//	public List<BigInteger> getSecurePatientAge() throws SQLException {
	public List<BigInteger> getSecurePatientAge(String userType) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getUnsecurePatientName() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BigInteger> getUnsecurePatientAge() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean insertSecurePatient(String name, BigInteger age, String userType, String userName) {
		// the mysql insert statement
		return null;

	}

	@Override
	public Boolean insertInsecurePatient(String name, BigInteger age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigInteger getUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean insertUserKeys(String username, BigInteger p, BigInteger q,
			int keylength, int keycertainty) {
		// TODO Auto-generated method stub
		return null;
	}

}
