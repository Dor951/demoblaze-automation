package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import java.time.Duration;


public class LoginSteps {
    WebDriver driver = BaseTest.driver;
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    private final By welcomeText = By.xpath("//*[@id='nameofuser']");

    @When("User click on login button")
    public void user_navigates_to_login_page() {
        homePage.openLoginPage();
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("An alert appears with text {string}")
    public void an_alert_appears_with_text(String expectedText) {
        String actualText = loginPage.getAlertText();
        Assert.assertEquals("Wrong alert text, Expected: " + expectedText + " Actual: " + actualText, expectedText, actualText);
        loginPage.acceptAlert();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement welcomeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText));
        String actualWelcomeText = welcomeElement.getText();
        Assert.assertTrue("Login failed: Expected 'Welcome' in page, but got: " + actualWelcomeText, actualWelcomeText.contains("Welcome"));
        driver.quit();
    }
}
