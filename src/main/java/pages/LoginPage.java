package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    // Locators
    private By cookies = By.id("cookieseal-banner-reject");
    private By userIcon = By.xpath("//span[contains(@class,'user-wrapper')]//span[1]");
    private By loginButton = By.xpath("//a[@class='cart-action__btn cart-action__btn--bg-blue']");
    private By emailField = By.xpath("//input[@placeholder='E-posta Adresi veya Telefon Numarası']");
    private By continueButton = By.xpath("//button[normalize-space()='Devam Et']");
    private By passwordField = By.xpath("//input[@placeholder='Şifreniz']");
    private By submitButton = By.xpath("//button[@type='submit']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void rejectCookies(){

        click(cookies);

    }

    public void hoverOverUserIcon(){

        hoverOverElement(userIcon);


    }
    @Step("Click the “Sign In” button.")
    public void clickLoginButton(){

        WebElement loginButtonElement= waitUntilClickable(loginButton);
        loginButtonElement.click();

    }
    @Step("Enter a valid email: {email}")
    public void enterEmail(String email){

        WebElement emailFieldElement = waitUntilClickable(emailField);
        emailFieldElement.sendKeys(email);

    }
    @Step("Click the continue button")
    public void clickContinueButton(){
        click(continueButton);


    }
    @Step("Enter the valid password: {password}")
    public void enterPassWord(String password){

        WebElement passwordFieldElement = waitUntilClickable(passwordField);
        passwordFieldElement.sendKeys(password);

    }
   @Step("Click the “Sign In” button.")
    public void clickSignInButton(){

        WebElement submitButtonElement = waitUntilClickable(submitButton);
        submitButtonElement.click();
        driver.navigate().to("https://www.lcw.com");

    }









}
