package taip;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import loggerModule.java.AbstractLogger;
import loggerModule.java.LoggerSingleton;
import loggerModule.tests.ChainPatternTest;
import databaseModule.java.ConnectionDb;
import databaseModule.tests.TestConnectionDB;

public class Main {

	public static void main(String[] args) {
		ConnectionDb c = new ConnectionDb();
		List<String> patientNameList;
		List<Integer> patientAgeList;
		try {
			patientNameList = c.getMySqlConnectionDB().getSecurePatientName();
			patientAgeList = c.getMySqlConnectionDB().getSecurePatientAge();
			boolean z = c.getMySqlConnectionDB().insertSecurePatient("Test2", 5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestConnectionDB t = new TestConnectionDB();
		t.testGetMysqlConnection_Is_Connection_class();

		try {
			int i = LoggerSingleton.getLogger("ERROR").writeLog("test",
					LoggerSingleton.LogLevel.ERROR);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(LoggerSingleton.getType());

		LoggerSingleton.setType("WARNING");
		
		AbstractLogger loggerChain = ChainPatternTest.getChainOfLoggers();

		loggerChain.logMessage(AbstractLogger.DATA, "This is a data message.");

		loggerChain.logMessage(AbstractLogger.WARNING,
				"This is a warning information.");

		loggerChain.logMessage(AbstractLogger.ERROR,
				"This is an error information.");
	}

}
