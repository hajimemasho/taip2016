/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggerModule.tests;

import java.io.IOException;

import loggerModule.java.LoggerSingleton;

/**
 *
 * @author -Oana-
 */
public class TestSingleton {

	public static void main(String[] args) throws IOException {
		int i = LoggerSingleton.getLogger("ERROR").writeLog("test",
				LoggerSingleton.LogLevel.ERROR);
		System.out.println(LoggerSingleton.getType());
	}

}
