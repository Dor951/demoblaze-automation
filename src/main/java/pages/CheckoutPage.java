package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By nameField = By.id("name");
    private By countryField = By.id("country");
    private By cityField = By.id("city");
    private By cardField = By.id("card");
    private By monthField = By.id("month");
    private By yearField = By.id("year");
    private By purchaseButton = By.xpath("//button[text()='Purchase']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterCheckoutDetails(String name, String country, String city, String card, String month, String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryField)).sendKeys(country);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityField)).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardField)).sendKeys(card);
        wait.until(ExpectedConditions.visibilityOfElementLocated(monthField)).sendKeys(month);
        wait.until(ExpectedConditions.visibilityOfElementLocated(yearField)).sendKeys(year);
    }

    public void confirmPurchase() {
        wait.until(ExpectedConditions.elementToBeClickable(purchaseButton)).click();
    }
}
