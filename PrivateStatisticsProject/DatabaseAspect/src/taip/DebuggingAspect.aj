package taip;

import java.util.ArrayList;
import java.util.List;

import loggerModule.java.LoggerSingleton;

/**
 *
 * @author -Oana-
 */
public aspect DebuggingAspect {
  
       
	pointcut changeMsg(): call( public int  LoggerSingleton.writeLog(**));
        before(): changeMsg(){
        System.out.println("POINTCUT or :"+ thisJoinPoint.getSignature());
        }
         
          
        pointcut testCreateInstance(): call( public static LoggerSingleton getLogger(String));
        after(): testCreateInstance(){
        System.out.println("Apel getInstance(): "+ thisJoinPoint.getSignature());}

          
        pointcut changeType(): call( public static void setType(String));
        before():changeType(){
            System.out.println("We change the type from: "+LoggerSingleton.getType());
        }

        after(): changeType(){
            System.out.println(" new type is:" + LoggerSingleton.getType());
        }
          
        pointcut insertSecurePatient():call(* insertSecurePatient(String, int));
        before(String name, int age):insertSecurePatient()&& args(name,age){
            System.out.println("We insert a new Patient! The values are, name: "+name +" age: " + age);
        }
        
       after() returning(boolean success):insertSecurePatient(){
		     if(success){
		    	 System.out.println("The insert succedded !");
		     }
		     else{
		    	 System.out.println("The insert failed !");
		     }
    	 }
       
       pointcut pointcutGetSecurePatientName():call(public List<String> getSecurePatientName());
       after() returning(List<String> listName):pointcutGetSecurePatientName(){
			     for (String name : listName) {
			    	 System.out.println("Name: "+name);
				}		  
	   };

       pointcut pointcutGetSecurePatientAge():call(public List<Integer> getSecurePatientAge());
       after() returning(ArrayList<Integer> listAge): pointcutGetSecurePatientAge(){
			     for (Integer age: listAge) {
			    	 System.out.println("Age: " + age);
				}		  
	   };
}


