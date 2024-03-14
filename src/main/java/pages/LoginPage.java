package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By emailTxt = By.id("notifyemail");
    private final By passwordTxt = By.id("notifypassword");
    private final By submitButton = By.id("submit");
    private final By AssertionMessage = By.xpath("//p[text()='First Name : Mahmoud']");

    public void enterLoginData(String email, String password){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailTxt)));
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(submitButton)));
        driver.findElement(submitButton).click();
    }

    public String getAssertionMessage(){
        return driver.findElement(AssertionMessage).getText();
    }
}
