package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;
    Robot robot;
    public SearchPage(WebDriver driver){
        this.driver= driver;
    }

    private final By searchBox = By.id("search-box");
    private final By firstProduct = By.xpath("//a[@title='Adidas Men Sport Shoes Dark Gray']");

    public void searchForItems(String product) throws  AWTException {
        driver.findElement(searchBox).sendKeys(product);
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstProduct)));
        driver.findElement(firstProduct).click();
    }
}
