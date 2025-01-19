package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductsPage extends BasePage {

    //age-color filter locators
    private By age5To6FilterOption = By.xpath("//div[@class='filter-option']//span[text()='5-6 Yaş']");
    private By age6FilterOption = By.xpath("//div[@class='filter-option']//span[text()='6 Yaş']");
    private By age6To7FilterOption = By.xpath("//div[@class='filter-option']//span[text()='6-7 Yaş']");
    private By colorFilterBejOption = By.xpath("//span[@class='color-filter-option__text' and text()='BEJ']");

    private  By dropdownButton = By.xpath("//button[@class='dropdown-button__button']");

    // Sorting combobox locator
    private By sortComboBox = By.xpath("//button[@class='dropdown-button__button']");
    private By sortDropdown = By.xpath("//div[@class='dropdown-button__dropdown dropdown-button__dropdown--open']");
    private By bestSellersOption = By.xpath("//a[normalize-space()='En çok satanlar']");

    // product locator
    private By productImage = By.xpath("//a[@title='Kapüşonlu Kız Çocuk Mont']//img[@class='product-image__image']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    @Step("Click on the 5-6 years age filter")
    public void clickAge5To6Filter() {
        WebElement filter = waitForVisibility(age5To6FilterOption);
        filter.click();
    }


    @Step("Click on the 6 years age filter")
    public void clickAge6Filter() {
        WebElement filter = waitForVisibility(age6FilterOption);
        filter.click();
    }


    @Step("Click on the 6-7 years age filter")
    public void clickAge6To7Filter() {
        WebElement filter = waitForVisibility(age6To7FilterOption);
        filter.click();
    }


    @Step("Click on the BEIGE color filter")
    public void clickColorBejFilter() {
        WebElement filter = waitForVisibility(colorFilterBejOption);
        filter.click();


    }

    public void hoverAndScrollToTop() throws InterruptedException {

        hoverOverElement(dropdownButton);
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(2000);
    }


    @Step("Click on the sorting combobox and select 'Best Sellers'")
    public void selectBestSellersSort() throws InterruptedException {
        // Click sorting combobox
        WebElement sortComboBoxElement = waitForVisibility(sortComboBox);
        Thread.sleep(2000);
        sortComboBoxElement.click();


        waitForVisibility(sortDropdown);
        Thread.sleep(2000);

        // click bestSellers
        WebElement bestSellersElement = waitForVisibility(bestSellersOption);
        bestSellersElement.click();
    }


    @Step("Click on the 4th product in the first row")
    public void clickOnProduct() {

        WebElement product = find(productImage);
        product.click();

    }



}
