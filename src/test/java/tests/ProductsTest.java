package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.listeners.TestListeners;
import pages.*;
@Listeners({ TestListeners.class })
@Epic("Regression Tests")
@Feature("Products Tests")
public class ProductsTest extends BaseTest{

    LoginPage loginPage;

    HomePage homePage;

    ProductsPage productsPage;



    @Description("Test Description: Navigate to LC Waikiki website.")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    @Step("Go to lcw website")
    public void setupTest(){


        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);


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


}
