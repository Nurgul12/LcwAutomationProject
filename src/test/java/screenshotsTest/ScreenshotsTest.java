package screenshotsTest;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenshotsTest {



    public WebDriver driver;
    String baseUrl = "https://www.lcw.com";


    //current directory
    private String currentDirectory = System.getProperty("user.dir");

    //getScreenShotMethodImage
    private File getScreenShotMethodImage = new File(currentDirectory + File.separator + "src/test/resources/screenshots/lcwimage.png");



    @BeforeClass
    public void setUp(){

        driver = new ChromeDriver();

        driver.get(baseUrl);

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }


    @Test
    public void visiblePart() throws IOException {

        // Take a screenshot of the current browser window
        File screenFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // Save the captured screenshot to the specified directory
        FileUtils.copyFile(screenFile,getScreenShotMethodImage);


    }




}
