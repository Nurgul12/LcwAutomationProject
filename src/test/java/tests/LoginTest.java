package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.listeners.TestListeners;
import pages.*;


@Listeners({ TestListeners.class })
@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;



    @Description("Test Description: Navigate to LC Waikiki website.")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    @Step("Go to lcw website")
    public void setupTest(){

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

    }




    @Description("Test Description: Login test with valid username and valid password.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Valid username and password login test")
    @Test(priority = 2, description="Success Login Scenario with valid username and password.")
    public void testLogin() {


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


}
