package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.listeners.TestListeners;
import pages.*;
@Listeners({ TestListeners.class })
@Epic("Regression Tests")
@Feature("ProductDetail Tests")
public class ProductDetailTest extends BaseTest{

    LoginPage loginPage;

    HomePage homePage;

    ProductsPage productsPage;

    ProductDetailPage productDetailPage;



    @Description("Test Description: Navigate to LC Waikiki website.")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    @Step("Go to lcw website")
    public void setupTest(){


        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);


    }

    @Description("Test Description: Login test with valid username and valid password.")
    @Test(priority = 2, description="Success Login Scenario with valid username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Valid username and password login test")
    public void getLoginTest(){

        loginPage.rejectCookies(); // reject cookies
        loginPage.hoverOverUserIcon(); // Hover process
        loginPage.clickLoginButton(); // Clicking on the login button

        // Login process
        loginPage.enterEmail("yazilimtest89@gmail.com");
        loginPage.clickContinueButton();
        loginPage.enterPassWord("yazilimtest12");
        loginPage.clickSignInButton();

        // Check page title
        Assertions.assertEquals("LCW.com: Trendler ve Yenilikçi Online Alışveriş Deneyimi Burada! | LCW", homePage.getPageTitle());

    }

    @Description("Test Description: Clicks on the Kids & Baby category, selects Girls Kids (6-14 YEARS), and chooses the Coat and Jacket subcategory.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Category selection test: Navigating through Kids & Baby category and selecting Girls Kids subcategory, then choosing Coat and Jacket subcategory.")
    @Test(priority = 3, description = "Test for selecting the correct subcategory and sub-menu in the Kids & Baby category.")
    public void setHomePageTest(){

        homePage.hoverOverKidsAndBabyCategory();
        homePage.hoverOverGirlsKidsCategory();
        homePage.clickCoatAndJacketSubcategory();


    }


    @Description("Test Description: Filters products by age (5-6, 6, 6-7 years) and color (beige), then sorts by 'Best Sellers'.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Product filtering and sorting test: Apply filters and sort options on the products page.")
    @Test(priority = 4, description = "Test for applying filters and sorting on the products page.")
    public void testFiltersOnProductsPage() throws InterruptedException {


        Thread.sleep(2000);

        // Filtering process
        productsPage.clickAge5To6Filter();
        Thread.sleep(2000);

        productsPage.clickAge6Filter();
        Thread.sleep(5000);

        productsPage.clickAge6To7Filter();
        Thread.sleep(2000);

        productsPage.clickColorBejFilter();
        Thread.sleep(2000);


        productsPage.hoverAndScrollToTop();


        // Sorting process
        productsPage.selectBestSellersSort();

        Thread.sleep(2000);



    }
    @Description("Test Description: Navigates to the product details page by clicking on the 4th product in the first row after applying filters and sorting.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Verify access to product details by selecting the 4th product in the first row.")
    @Test(priority = 5, description = "Test for navigating to the product details page by selecting the 4th product.")
    public void navigateToProductDetails() throws InterruptedException {

        //click on the product
        productsPage.clickOnProduct();
        Thread.sleep(2000);

    }



    @Description("Test Description: Verifies that the user has navigated to the product details page successfully.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Product Details Page Verification: Ensure the user is on the product details page.")
    @Test(priority = 6, description = "Test for verifying that the user is on the product details page.")
    public void verifyAddToCartButtonVisible() throws InterruptedException {
        // Check whether you enter the product detail page
        Assertions.assertTrue(productDetailPage.verifyAddToCartButtonVisible(),"Sepete Ekle butonu görünmüyor!");
        Thread.sleep(2000);
    }

    @Description("Test Description: Selects an available size from the product details page before adding the product to the cart.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Product Size Selection: Verify the ability to select an available size before adding a product to the cart.")
    @Test(priority = 7, description = "Test for selecting an available size on the product details page.")
    public void selectAvailableSize() throws InterruptedException {
        // Choose from available size options
        productDetailPage.selectAvailableSize();
        Thread.sleep(2000);
    }


    @Description("Test Description: Adds the product to the cart after selecting an available size from the product details page.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Product Selection Process: Verify the process of selecting a size and adding the product to the cart.")
    @Test(priority = 8, description = "Test for adding a product to the cart.")
    public void clickAddToCart() throws InterruptedException {

        // Add product to cart
        productDetailPage.clickAddToCart();
        Thread.sleep(2000);
    }


    @Description("Test Description: Navigates to the cart page after successfully adding a product to the cart.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Cart Page Navigation: Verify navigation to the cart page after adding a product.")
    @Test(priority = 9, description = "Test for navigating to the cart page.")
    public void goToCart() {
        // Go to cart
        homePage.goToCart();
    }




}
