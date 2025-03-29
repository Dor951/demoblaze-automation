package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CheckoutPage;
import pages.CartPage;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import java.time.Duration;

public class CheckoutSteps {
    WebDriver driver = BaseTest.driver;
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    HomePage homePage = new HomePage(driver);

    private final By confirmationPopUp = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']");

    @When("User proceeds to checkout")
    public void user_proceeds_to_checkout() {
        cartPage.proceedToCheckout();
    }

    @When("User enters checkout details")
    public void user_enters_checkout_details() {
        checkoutPage.enterCheckoutDetails("Aviv Geffen", "USA", "New York", "1234567812345678", "12", "2026");
    }

    @When("User confirms the purchase")
    public void user_confirms_purchase() {
        checkoutPage.confirmPurchase();
    }

    @When("User navigates to home page")
    public void user_navigates_to_cart_page() {
        homePage.goToHomePage();
    }

    @Then("User should see the purchase confirmation message")
    public void user_should_see_confirmation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationPopUp));
        String actualConfirmationText = confirmationElement.getText();
        Assert.assertTrue("Purchase failed: Expected No confirmation, got: " + actualConfirmationText, actualConfirmationText.contains("Thank you for your purchase!"));
        driver.quit();
    }
}
