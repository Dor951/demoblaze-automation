package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import pages.CartPage;
import pages.HomePage;
import org.openqa.selenium.WebDriver;


public class CartSteps {
    WebDriver driver = BaseTest.driver;
    HomePage homePage = new HomePage(driver);
    CartPage cartPage = new CartPage(driver);

    @When("User adds {string} to the cart")
    public void user_adds_product_to_cart(String productName) {
        homePage.selectProduct(productName);
        homePage.addToCart();
        homePage.acceptAlert();
    }

    @When("User navigates to cart page")
    public void user_navigates_to_cart_page() {
        homePage.goToCart();
    }

    @Then("Total cart price should be {int}")
    public void total_cart_price_should_be(int expectedTotal) {
        int actualTotal = cartPage.getDisplayedTotalPrice();
        Assert.assertEquals("Wrong total cart price, Expected: " + expectedTotal + " Actual: " + actualTotal, expectedTotal, actualTotal);
    }

    @Then("User should see the product in the cart")
    public void user_should_see_product_in_cart() {
        Assert.assertTrue(driver.getPageSource().contains("Product"));
    }
}
