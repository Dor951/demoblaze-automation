package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By loginLink = By.id("login2");
    private By cartLink = By.id("cartur");
    private By logoutLink = By.id("logout2");
    private By addToCartButton = By.xpath("//a[text()='Add to cart']");
    private By homePage = By.xpath("//a[.='Home (current)']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public void selectProduct(String productName) {
        By productLink = By.xpath("//a[.='" + productName + "']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(productLink)).click();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }

    public void goToHomePage() {
        wait.until(ExpectedConditions.elementToBeClickable(homePage)).click();
    }

    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }
}
