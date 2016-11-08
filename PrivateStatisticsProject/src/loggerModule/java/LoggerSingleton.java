/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taip;

import java.util.logging.Logger;

/**
 *
 * @author -Oana-
 */
public class LoggerSingleton {
	public enum LogLevel {INFO, WARNING, ERROR};
	private static LoggerSingleton obj;
	//private Logger oLog;
	
	private LoggerSingleton(){
        }
	
	
	public static LoggerSingleton getLogger(){
		if (obj == null)
                    
			obj = new LoggerSingleton();
		
		return obj;
	}
      public void writeLog(String Msg, LoggerSingleton.LogLevel _eLogLevel){
		switch(_eLogLevel){
			
			case INFO:
				 System.out.println("Info Console: " + Msg);
				break;
			case WARNING:
				System.out.println("Warning Console: " + Msg);
				break;
			case ERROR:
				System.out.println("Error Console: " + Msg);
				
				break;
			
			default:
				
		}
      }
	
	
}

