/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggerModule.tests;

import loggerModule.java.AbstractLogger;
import loggerModule.java.ConsoleLogger;
import loggerModule.java.ErrorLogger;
import loggerModule.java.FileLogger;

/**
 *
 * @author -Oana-
 */
public class ChainPatternTest {
	
   public static AbstractLogger getChainOfLoggers(){

      AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
      AbstractLogger fileLogger = new FileLogger(AbstractLogger.WARNING);
      AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.DATA);

      errorLogger.setNextLogger(fileLogger);
      fileLogger.setNextLogger(consoleLogger);

      return errorLogger;	
   }
   

   public static void main(String[] args) {
      AbstractLogger loggerChain = getChainOfLoggers();
      
      
      

      loggerChain.logMessage(AbstractLogger.DATA, 
         "This is a data message.");

      loggerChain.logMessage(AbstractLogger.WARNING, 
         "This is a warning information.");

      loggerChain.logMessage(AbstractLogger.ERROR, 
         "This is an error information.");
   }
}
