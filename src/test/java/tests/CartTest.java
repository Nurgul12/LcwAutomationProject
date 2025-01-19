package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.listeners.TestListeners;
import pages.*;
@Listeners({ TestListeners.class })
@Epic("Regression Tests")
@Feature("Cart Tests")
public class CartTest extends BaseTest{


    LoginPage loginPage;

    HomePage homePage;

    ProductsPage productsPage;

    ProductDetailPage productDetailPage;
    CartPage cartPage;

    FavoritesPage favoritesPage;


    @Description("Test Description: Navigate to LC Waikiki website.")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    @Step("Go to lcw website")
    public void setupTest(){


        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        favoritesPage = new FavoritesPage(driver);

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
        loginPage.enterEmail("test@gmail.com");
        loginPage.clickContinueButton();
        loginPage.enterPassWord("test12");
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

        // Click on the product
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


    @Description("Test Description: Verifies that the quantity of a product in the cart can be incremented successfully.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Cart Quantity Update: Ensure users can increase the quantity of a product in the cart.")
    @Test(priority = 10, description = "Test for incrementing the quantity of a product in the cart.")
    public void QuantityIncrement() throws InterruptedException {

        Thread.sleep(2000);

        // Product quantity increase by 1
        cartPage.testQuantityIncrement();


    }

    @Description("Test Description: Validates the accuracy of the product's name, color, quantity, and total price displayed in the cart.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Cart Verification: Validate the accuracy of product details and pricing in the cart.")
    @Step("On the cart screen, the accuracy of the selected product’s ‘name,’ ‘color,’ and ‘quantity’ fields is checked.The product’s total price is matched with the amount displayed in the ‘Proceed to Payment’ section on the right side of the same screen.")
    @Test(priority = 11, description = "Test for validating the accuracy of product details in the cart.")
    public void verifyCart() {

        // Product name verification
        String productName = cartPage.getProductName();
        Assertions.assertEquals(productName, "Mont");

        // Product color verification
        String productColor = cartPage.getProductColor();
        Assertions.assertEquals(productColor, "Koyu Bej");

        // Product quantity verification
        String productQuantity = cartPage.getProductQuantity();
        Assertions.assertEquals(productQuantity, "2");

        // Product total price verification
        String productPrice = cartPage.getProductPrice();
        String totalPrice = cartPage.getTotalPrice();
        Assertions.assertEquals(productPrice, totalPrice);
    }

    @Description("Test Description: Validates that a product can be added to the favorites by clicking the heart icon on the product card in the cart page.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Product Favorites: Verify that users can add a product to their favorites by clicking the heart icon on the product card.")
    @Test(priority = 12, description = "Test for adding a product to the favorites using the heart icon in the cart.")
    public void addProductToFavorites() throws InterruptedException {

        // Add product to favorites
        cartPage.addProductToFavorites();
        Thread.sleep(2000);

    }

    @Description("Test Description: Validates that users can open the favorites page by clicking the 'Favorites' icon on the screen.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Navigate to Favorites: Ensure users can access the favorites page by clicking the 'Favorites' icon.")
    @Test(priority = 13, description = "Test for navigating to the favorites page.")
    public void navigateToFavoritesPage() {

        // Go to favorites page
        homePage.goToFavoritesPage();

    }

    @Description("Test Description: Ensures that the product previously added to favorites is listed in the favorites screen, verified by matching the product name.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Favorites Verification: Verify that a product added to favorites is displayed in the favorites list using its product name.")
    @Test(priority = 14, description = "Test for verifying that the product appears in the favorites list.")
    public void productExistsInFavorites() {
        // Check product in favorites
        boolean isProductInFavorites = favoritesPage.isProductInFavorites("Kapüşonlu Kız Çocuk Mont");
        Assertions.assertTrue(isProductInFavorites, "Ürün favorilerde bulunamadı");

    }




    @Description("Test Description: Verifies that users can proceed to the payment step by clicking the 'Proceed to Payment' button on the cart page.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Payment Step Navigation: Verify that users can navigate to the payment step from the cart page by clicking the 'Proceed to Payment' button.")
    @Test(priority = 15, description = "Test for navigating to the payment step from the cart page.")
    public void testProceedToCheckout() {
        // Go to cart page
        homePage.goToCart();

        // Go to payment step
        cartPage.proceedToPaymentStep();


    }


}
