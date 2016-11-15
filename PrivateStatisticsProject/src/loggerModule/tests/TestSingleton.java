/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggerModule.tests;

import loggerModule.java.LoggerSingleton;

import java.io.IOException;

/**
 *
 * @author -Oana-
 */
public class TestSingleton {

	public static void main(String[] args) throws IOException {
		int i=LoggerSingleton.getLogger("INFO").writeLog("test", LoggerSingleton.LogLevel.INFO);
	}

}
