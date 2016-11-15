/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import taip.LoggerSingleton;

/**
 *
 * @author -Oana-
 */
public class LoggerJUnitTest extends TestCase {
    
     @Test
    public void testCreateLogger()throws Exception{
        
        assertNotNull(LoggerSingleton.getLogger("INFO"));
    }
    
     @Test
    public void testErrorMessage()throws Exception{
    assertEquals(2,LoggerSingleton.getLogger("ERROR").writeLog(null, LoggerSingleton.LogLevel.ERROR));
    }
    @Test
    public void testWarningMessage()throws Exception{
    assertEquals(1,LoggerSingleton.getLogger("WARNING").writeLog(null, LoggerSingleton.LogLevel.WARNING));
    }
    @Test
    public void testInfoMessage()throws Exception{
    assertEquals(0,LoggerSingleton.getLogger("INFO").writeLog(null, LoggerSingleton.LogLevel.INFO));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
