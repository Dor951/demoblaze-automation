package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By deleteButton = By.xpath("//a[text()='Delete']");
    private By placeOrderButton = By.xpath("//button[text()='Place Order']");
    private By productPrices = By.xpath("//td[3]");
    private By totalPrice = By.id("totalp");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void removeItemFromCart() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    public int getDisplayedTotalPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice));

        return Integer.parseInt(driver.findElement(totalPrice).getText());
    }
}
