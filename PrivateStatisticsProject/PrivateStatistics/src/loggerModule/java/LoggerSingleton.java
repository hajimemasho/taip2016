/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggerModule.java;

import java.io.IOException;
import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

//import java.util.logging.Logger;

/**
 *
 * @author -Oana-
 */
public class LoggerSingleton {
	private static String type;

	public enum LogLevel {
		INFO(0), WARNING(1), ERROR(2);
		private final int type;

		LogLevel(int type) {
			this.type = type;
		}
	};

	private static LoggerSingleton obj;

	// private Logger oLog;

	private LoggerSingleton() {
	}

	/*
	 * public static void getInstance(String type) throws SampleException{
	 * Object obj = new LoggerSingleton(); try{ throw new SampleException(); }
	 * catch( SampleException e){ e.printStackTrace;}
	 * 
	 * }
	 */
	public static void setType(String type) {
		LoggerSingleton.type = type;
	}

	public static String getType() {
		return LoggerSingleton.type;
	}

	public static LoggerSingleton getLogger(String type) {
		if (obj == null)
			obj = new LoggerSingleton();
		LoggerSingleton.type = type;
		return obj;
	}

	/*
	 * public int writeLog(String Msg, LoggerSingleton.LogLevel _eLogLevel){
	 * switch(_eLogLevel){
	 * 
	 * case INFO: System.out.println("Info Console: " + Msg);
	 * 
	 * break; case WARNING: System.out.println("Warning Console: " + Msg);
	 * break; case ERROR: System.out.println("Error Console: " + Msg);
	 * 
	 * break;
	 * 
	 * default:
	 * 
	 * } return 1; }
	 */

	public int writeLog(String Msg, LoggerSingleton.LogLevel _eLogLevel)
			throws IOException {
		Logger logger = Logger.getLogger("MyLog");
		Appender fh = null;
		try {
			fh = new FileAppender(new SimpleLayout(), "MyLogFile.log");
			logger.addAppender(fh);
			fh.setLayout(new SimpleLayout());
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		switch (_eLogLevel) {

		case INFO:
			Msg = "INFO";
			System.out.println("Info Console: " + Msg);
			logger.info("Info message");
			break;
		case WARNING:
			Msg = "WARNING";
			System.out.println("Warning Console: " + Msg);
			logger.info("Warning message");
			break;
		case ERROR:
			Msg = "ERROR";
			System.out.println("Error Console: " + Msg);
			logger.info("Error message");

			break;

		default:

		}
		return LogLevel.valueOf(type).type;

	}

}
