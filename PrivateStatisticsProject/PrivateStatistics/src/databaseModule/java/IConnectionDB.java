package databaseModule.java;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IConnectionDB {
	public Connection getConnection();
	
	public List<String> getSecurePatientName() throws SQLException;
//	public List<BigInteger> getSecurePatientAge() throws SQLException;	
	public List<BigInteger> getSecurePatientAge(String userName) throws SQLException;	
	public List<String> getUnsecurePatientName() throws SQLException;
	public List<BigInteger> getUnsecurePatientAge() throws SQLException;
	public Boolean insertSecurePatient(String name, BigInteger age, String userType, String userName);
	public Boolean insertInsecurePatient(String name, BigInteger age); 
	public BigInteger getUserName(String username);
	
	
	//for tests only!
	public Boolean insertUserKeys(String username, BigInteger p, BigInteger q, int keylength, int keycertainty);
	
}
