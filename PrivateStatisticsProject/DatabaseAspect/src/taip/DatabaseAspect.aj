package taip;

import java.sql.Connection;
import databaseModule.java.*;

public aspect DatabaseAspect {
  
        pointcut mysqlConnection(): call( public static Connection getMySqlConnection());
        after() returning(Connection cn): mysqlConnection(){
            if(cn==null){
                System.out.println("We create a new mysql connection. ");    
            }else{
                System.out.println("We retrieve active mysql connection. ");
            }
        };
        before(): mysqlConnection(){
            System.out.println("Before pointcut: "+ thisJoinPoint.getSignature());
        }
         

	pointcut sqlServerConnection(): call( public static Connection getSqlServerConnection());
	after()returning(Connection cn): sqlServerConnection()
	{
            if(cn==null){
                System.out.println("We create a new sql server connection. ");    
            }else{
                System.out.println("We retrieve active sql server connection. ");
            }
        };
        before(): mysqlConnection(){
            System.out.println("Before pointcut :"+ thisJoinPoint.getSignature());
        }

        pointcut testGetConnection(): call( public Connection getConnection());
        before():testGetConnection(){
            System.out.println("Get connection. ");
        };
        after(): testGetConnection(){
            System.out.println("Apel getConnection(): "+ thisJoinPoint.getSignature());
        }
          }
/*package mop;

import java.io.*;
import java.util.*;

SafeWriteToDB(Connection conn) {
     
   event open after() returning(Connection conn) : 
      call(* ConnectionDB.getMySqlConnection(..)) {}
   event writeSecurePatient before(Connection conn) : 
      call(* insertSecurePatient(..)) && target(conn) {}
   event readSecurePatientAge before(Connection conn) : 
      call(* getSecurePatientAge(..)) && target(conn) {}

   cfg : 
      S -> open SafeWriteToDB writeSecurePatient readSecurePatientAge , 
      SafeWriteToDB -> SafeWriteToDB S | SafeWriteToDB writeSecurePatient | SafeWriteToDB readSecurePatientAge  | epsilon

   @match {
      System.out.println("write before open");
   }
}*/