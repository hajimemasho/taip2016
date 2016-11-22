package taip;
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
            System.out.print("We change the type from: "+LoggerSingleton.getType());
        }

        after(): changeType(){
            System.out.println(" new type is:" + LoggerSingleton.getType());
        }
          
}

