package taip;
/**
 *
 * @author -Oana-
 */

import loggerModule.java.LoggerSingleton;
public aspect MessageAspect {
  
       
	pointcut changeMsg(): call( public int  LoggerSingleton.writeLog(**));

        before(): changeMsg(){
        System.out.println("POINTCUT or :"+ thisJoinPoint.getSignature());
        }
         
         // pt a vedea daca a fost creata o instanta 
        pointcut testCreateInstance(): call( public static LoggerSingleton getLogger(String));

        after(): testCreateInstance(){
        System.out.println("Apel getInstance(): "+ thisJoinPoint.getSignature());}

            // schimb tipul mesajului meu.
        pointcut changeType(): call( public static void setType(String));

        before():changeType(){
            System.out.println("We change the type from: "+LoggerSingleton.getType());
        }

        after(): changeType(){
            System.out.println(" new type is:" + LoggerSingleton.getType());
        }
          
}

