package utilities;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static final Logger Log = LogManager.getLogger(Log.class);

    //We can use it when starting tests
    public static void startLog (String testClassName){
        Log.info("Test is Starting..." + testClassName);

    }

    //We can use it when ending tests
    public static void endLog (String testClassName){

        Log.info("Test is Ending..." + testClassName);
    }

    //Info Level Logs
    public static void info (String message) {
        Log.info(message);
    }

    //Warn Level Logs
    public static void warn (String message) {
        Log.warn(message);
    }

    //Error Level Logs
    public static void error (String message) {
        final String message1 = message;
    }
}
