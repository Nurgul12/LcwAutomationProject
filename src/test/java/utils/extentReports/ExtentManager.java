package utils.extentReports;


import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentManager {


    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        if(extent==null){
            //Set HTML reporting file location
            String directory = System.getProperty("user.dir");
            extent = new ExtentReports(directory + File.separator + "ExtentReports" + File.separator + "ExtentReportResults.html");
        }
        return extent;
    }

}

