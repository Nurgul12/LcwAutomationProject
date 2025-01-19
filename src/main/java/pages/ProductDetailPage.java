package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailPage extends BasePage {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By addToCartButton = By.xpath("//button[normalize-space()='SEPETE EKLE']");


    private By sizeButtons = By.cssSelector("button[data-label]");


    @Step("Go to product details")
    public boolean verifyAddToCartButtonVisible() {

        boolean isAddToCartButtonVisible = isDisplayed(addToCartButton);
        return isAddToCartButtonVisible;


    }


    @Step("Select the available size for the product")
    public void selectAvailableSize() {
        List<WebElement> sizes = findAll(sizeButtons);
        for (WebElement size : sizes) {
            if (size.isEnabled()) {
                size.click();
                break;
            }
        }
    }


    @Step("Click the 'Add to Cart' button")
    public void clickAddToCart() {
        WebElement buttonCart = find(addToCartButton);
        if (buttonCart.isDisplayed()) {
            buttonCart.click();
        }
    }


}
