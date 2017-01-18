package databaseModule.java;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import utilitiesModule.java.BaseClass;
import loggerModule.java.*;

public class MySQLConnectionDB extends BaseClass implements IConnectionDB {

	private Connection _connection;
	private String _username;
	private String _password;
	private String _dbURL;
	private String _port;

	public MySQLConnectionDB(String dbUrl, String username, String password) {
		super();
		_dbURL = dbUrl;
		_username = username;
		_password = password;
	}

	// singleton
	@Override
	public Connection getConnection() {
		if (_connection == null) {

			try {
				_connection = DriverManager.getConnection("jdbc:mysql://"
						+ this._dbURL + "?user=" + this._username
						+ "&password=" + this._password);
				return _connection;
			} catch (SQLException ex) {
				try {
					LoggerSingleton.getLogger("INFO").writeLog(ex.getMessage(),
							LoggerSingleton.LogLevel.ERROR);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return _connection;
	}

	@Override
	public List<String> getSecurePatientName() throws SQLException {

		Statement stmt = null;
		List<String> patientName = new ArrayList<String>();
		String query = "SELECT PatientName FROM dbo.securepatient";
		try {
			stmt = _connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				patientName.add(rs.getString("PatientName"));
			}
			return patientName;
		} catch (SQLException ex) {
			try {
				LoggerSingleton.getLogger("INFO").writeLog(ex.getMessage(),
						LoggerSingleton.LogLevel.ERROR);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	@Override
	public List<BigInteger> getSecurePatientAge() throws SQLException {

		Statement stmt = null;
		List<BigInteger> patientAgeList = new ArrayList<BigInteger>();
		String query = "SELECT PatientAge FROM dbo.securepatient";
		try {
			stmt = _connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				patientAgeList.add(new BigInteger(rs.getString("PatientAge")));
			}
			return patientAgeList;
		} catch (SQLException ex) {
			try {
				LoggerSingleton.getLogger("INFO").writeLog(ex.getMessage(),
						LoggerSingleton.LogLevel.ERROR);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	@Override
	public List<String> getUnsecurePatientName() throws SQLException {

		Statement stmt = null;
		List<String> patientName = new ArrayList<String>();
		String query = "SELECT PatientName FROM dbo.unsecurepatient";
		try {
			stmt = _connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				patientName.add(rs.getString("PatientName"));
			}
			return patientName;
		} catch (SQLException ex) {
			try {
				LoggerSingleton.getLogger("INFO").writeLog(ex.getMessage(),
						LoggerSingleton.LogLevel.ERROR);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	@Override
	public List<BigInteger> getUnsecurePatientAge() throws SQLException {

		Statement stmt = null;
		List<BigInteger> patientAgeList = new ArrayList<BigInteger>();
		String query = "SELECT PatientAge FROM dbo.unsecurepatient";
		try {
			stmt = _connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				patientAgeList.add(new BigInteger(rs.getString("PatientAge")));
			}
			return patientAgeList;
		} catch (SQLException ex) {
			try {
				LoggerSingleton.getLogger("INFO").writeLog(ex.getMessage(),
						LoggerSingleton.LogLevel.ERROR);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	@Override
	public Boolean insertSecurePatient(String name, BigInteger age) {
		// the mysql insert statement
		String query = " INSERT INTO `dbo`.`securepatient` (`PatientName`, `PatientAge`) VALUES (?,?)";
		try {
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = _connection
					.prepareStatement(query);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, age.toString());

			// execute the preparedstatement

			preparedStmt.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean insertInsecurePatient(String name, BigInteger age) {
		// the mysql insert statement
		String query = " INSERT INTO `dbo`.`unsecurepatient` (`PatientName`, `PatientAge`) VALUES (?,?)";
		try {
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = _connection
					.prepareStatement(query);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, age.toString());

			// execute the preparedstatement

			preparedStmt.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
