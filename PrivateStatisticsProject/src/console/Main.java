package console;

import databaseModule.tests.TestConnectionDB;

public class Main {
	public static void main(String[]args){
		TestConnectionDB t= new TestConnectionDB();
		t.testGetMysqlConnection_Is_Connection_class();
	}
}
