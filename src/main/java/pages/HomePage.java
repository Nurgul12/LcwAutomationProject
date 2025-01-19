package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {

    // Locators

    private By kidsAndBabyCategory = By.xpath("//a[normalize-space()='ÇOCUK & BEBEK']");
    private By girlsKidsCategory = By.xpath("//button[span[contains(text(),'KIZ ÇOCUK')] and span[contains(text(),'(6-14 YAŞ)')]]");
    private By coatAndJacketSubCategory = By.xpath("//section[contains(@class,'content-tab')]//a[contains(@class,'')][normalize-space()='Mont ve Kaban']");

    private By favoritePageClick = By.xpath("//span[normalize-space()='Favorilerim']");
    private By goToCartButton = By.xpath("//span[normalize-space()='Sepetim']");
    private By goToCartPageButton = By.xpath("//div[@class='drop-down-menu drop-down-menu--cart-menu drop-down-menu--active']//a[@class='cart-action__btn cart-action__btn--bg-green'][normalize-space()='Sepete Git']");


    public HomePage(WebDriver driver) {
        super(driver);


    }


    public String getPageTitle() {
        return driver.getTitle();
    }
    @Step("Click on Kids & Baby category")
    public void hoverOverKidsAndBabyCategory(){

        hoverWhenVisible(kidsAndBabyCategory);

    }
    @Step("Select Girls Kids (6-14 years) category")
    public void hoverOverGirlsKidsCategory(){

        hoverWhenVisible(girlsKidsCategory);
    }
    @Step("Select Coat and Jacket subcategory")
    public void clickCoatAndJacketSubcategory(){

        WebElement subcategoryElement =  waitForVisibility(coatAndJacketSubCategory);
        subcategoryElement.click();

    }


    @Step("Click on the 'Favorites' icon. The Favorites screen opens.")
    public void goToFavoritesPage() {
        WebElement favoritesButton = waitUntilClickable(favoritePageClick);
        favoritesButton.click();
    }


    @Step("Go to Cart page")
    public void goToCart() {

        hoverWhenVisible(goToCartButton);
        WebElement cartButton = waitUntilClickable(goToCartPageButton);
        cartButton.click();


    }


}
