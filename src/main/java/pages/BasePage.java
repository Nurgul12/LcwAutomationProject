package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Commonly used methods. Prevents code duplication.
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void enterText(By locator, String text) {
        find(locator).sendKeys(text);

    }

    public Boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public void hoverOverElement(By locator) {

        WebElement element = find(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();


    }

    public WebElement waitForVisibility(By locator) {
        // explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public WebElement waitUntilClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public void hoverWhenVisible(By locator){
        WebElement element = waitForVisibility(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
