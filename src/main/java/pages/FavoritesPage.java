package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FavoritesPage extends BasePage {

    //  Locator
    private By productCardTitle = By.xpath("//h5[@class='product-card__title']");


    public FavoritesPage(WebDriver driver) {
        super(driver);
    }


    @Step("Verify if the product with name '{0}' is present in the favorites")
    public boolean isProductInFavorites(String productName) {

        WebElement product = waitUntilClickable(productCardTitle);
        return product.getText().contains(productName);

    }


}
