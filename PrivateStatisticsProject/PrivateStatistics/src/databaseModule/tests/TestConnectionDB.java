package databaseModule.tests;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;
import databaseModule.java.ConnectionDb;

public class TestConnectionDB {

	public TestConnectionDB(){
		
	}
	
	//region mysql connection
	@Test
	public void testGetMysqlConnection_Null(){
		 assertEquals(ConnectionDb.getMySqlConnection(), null);
	}
	

	@Test
	public void testGetMysqlConnection_Is_Connection_class(){
		 assertEquals(ConnectionDb.getMySqlConnection().getClass(), com.mysql.jdbc.JDBC4Connection.class);
	}
	//endregion mysql connection
	
	
	//region sqlserver connection
	@Test
	public void testGetSqlServerConnection(){
		assertEquals(ConnectionDb.getSqlServerConnection(), null);
	}
	
	@Test
	public void testGetSqlServerConnection_Is_Connection_class(){
		 assertEquals(ConnectionDb.getSqlServerConnection().getClass(), com.mysql.jdbc.JDBC4Connection.class);
	}
	//endregion sqlserver connection
}
