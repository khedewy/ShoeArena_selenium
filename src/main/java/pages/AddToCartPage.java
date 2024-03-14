package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartPage {
    WebDriver driver;
    WebDriverWait wait;
    public AddToCartPage(WebDriver driver){
        this.driver = driver;
    }

    private final By size = By.xpath("//li[@data-eu='43.5']");
    private final By addToCartButton = By.id("button-cart");
    private final By viewCartButton = By.xpath("//button[text()=\"View Cart\"]");
    private final By AssertionMessage = By.xpath("//a[text()=\"Adidas Men Sport Shoes Dark Gray\"]");

    public void addProductToCart(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(size)));
        driver.findElement(size).click();
        driver.findElement(addToCartButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(viewCartButton)));
        driver.findElement(viewCartButton).click();
    }

    public String getAssertionMessage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AssertionMessage)));
        return driver.findElement(AssertionMessage).getText();
    }
}
