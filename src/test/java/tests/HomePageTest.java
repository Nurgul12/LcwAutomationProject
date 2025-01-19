package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.listeners.TestListeners;
import pages.*;
@Listeners({ TestListeners.class })
@Epic("Regression Tests")
@Feature("HomePage Tests")
public class HomePageTest extends BaseTest{


    LoginPage loginPage;

    HomePage homePage;



    @Description("Test Description: Navigate to LC Waikiki website.")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    @Step("Go to lcw website")
    public void setupTest(){

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

    }

    @Description("Test Description: Login test with valid username and valid password.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Valid username and password login test")
    @Test(priority = 2, description="Success Login Scenario with valid username and password.")
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
    @Test(priority = 3, description = "Selecting the correct subcategory and sub-menu in the Kids & Baby category.")
    public void setHomePageTest(){


        homePage.hoverOverKidsAndBabyCategory();
        homePage.hoverOverGirlsKidsCategory();
        homePage.clickCoatAndJacketSubcategory();


    }



}
