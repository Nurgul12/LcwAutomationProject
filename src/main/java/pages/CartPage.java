package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage extends BasePage {

    WebDriverWait wait;

    // Locators
    private By productName = By.xpath("//span[@class='rd-cart-item-code']");
    private By productColor = By.xpath("//strong[normalize-space()='Koyu Bej']");
    private By productQuantity = By.xpath("//input[@value='2']");
    private By productPrice = By.xpath("//span[@class='rd-cart-item-price mb-15']");
    private By totalPrice = By.xpath("//div[@class='price-info-area']//span[@class='total-grand-box-amount'][normalize-space()='2.999,98 TL']");
    private By favoriteIcon = By.xpath("//i[@class='fa fa-heart-o']");

    private By paymentStepButton = By.xpath("//div[@class='col-md-12 pl-20 pr-20']//a[@class='main-button mt-15'][normalize-space()='ÖDEME ADIMINA GEÇ']");

    private By increaseButtonLocator = By.xpath("//input[@class='item-quantity-input ignored']/../a[2]");

    private By quantityFieldLocator = By.xpath("//input[@class='item-quantity-input ignored']");



    public CartPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    @Step("Increase the product quantity by 1 in the cart")
    public void testQuantityIncrement() throws InterruptedException {

        // Find increaase button
        WebElement increaseButton = waitForVisibility(increaseButtonLocator);

        // Find quantity field
        WebElement quantityField = waitForVisibility(quantityFieldLocator);


        // Get the first quantity
        int initialQuantity = Integer.parseInt(quantityField.getAttribute("value"));
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(increaseButton));

        // İncrease quantity
        increaseButton.click();

        // Check the increasing amount
        int increasedQuantity = Integer.parseInt(quantityField.getAttribute("value"));
        Thread.sleep(2000);

        // verify
        Assert.assertEquals(increasedQuantity, initialQuantity + 1, "Miktar artırma testi başarısız!");
        Thread.sleep(4000);
    }



    public String getProductName() {

        return find(productName).getText();


    }


    public String getProductColor() {
        return find(productColor).getText();
    }



    public String getProductQuantity() {
        return find(productQuantity).getAttribute("value");
    }



    public String getProductPrice() {
        return find(productPrice).getText();
    }



    public String getTotalPrice() {
        return find(totalPrice).getText();
    }


    @Step("The heart icon on the product card is clicked, ensuring the product is added to the favorites.")
    public void addProductToFavorites() {

        WebElement favoriteIconButton = waitUntilClickable(favoriteIcon);
        favoriteIconButton.click();

    }


    @Step("Click on the 'Proceed to Payment' button")
    public void proceedToPaymentStep() {

        WebElement paymentButtonElement = waitUntilClickable(paymentStepButton);
        paymentButtonElement.click();

    }

}
