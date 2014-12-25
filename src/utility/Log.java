package utility;


import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {

    private static Logger logger;

    private static String filePath = "src/log4j.properties";

    private static boolean flag = false;

    private static synchronized void getPropertyFile() {
        logger = Logger.getLogger(Log.class.getClass());
        PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
        flag = true;
    }

    
    public static void startTestCase(String testCaseName){
    	
    	logger.info("*************************START****************************");
    	logger.info("*****************************************************");
    	logger.info("$$$$$$$$$$$$$$$$$$$$           "+testCaseName+"           $$$$$$$$$$$$$$$$$$$$");
    	logger.info("*****************************************************");
    	logger.info("*****************************************************");
    }
    
    public static void endTestCase(String testCaseName){
    	
    	logger.info("XXXXXXXXXXXXXXXXXXXXXX-- E---N---D --XXXXXXXXXXXXXXXXXXXXXX");
    	logger.info("X");
    	logger.info("X");
    	logger.info("X");
    }
    
    private static void getFlag() {
        if (flag == false)
            Log.getPropertyFile();
    }

    public static void logInfo(String message) {
        Log.getFlag();
        logger.info(message);
    }

    public static void logError(String message) {
        Log.getFlag();
        logger.error(message);
    }

    public static void logWarn(String message) {
        Log.getFlag();
        logger.warn(message);
    }

}