package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.Log;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    WebDriver driver;
    String baseUrl = "https://www.lcw.com";

   @BeforeSuite
    public void setUp(){

       Log.info("Browser is starting up...");
       driver = new ChromeDriver();
       Log.startLog("Lcw Test");
       Log.info("Going to LC Waikiki website...");
       driver.get(baseUrl);

       Log.info("Browser window is maximized...");
       //implicit wait
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().window().maximize();

    }

    @AfterSuite
    public void close(){
       Log.endLog("Lcw Test");
       driver.quit();

    }


}
