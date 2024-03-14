package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    WebDriverWait wait;

    public RegisterPage (WebDriver driver){
        this.driver = driver;
    }


    private final By firstNameTxt = By.id("registerfirst");
    private final By lastNameTxt = By.id("registerlast");
    private final By emailTxt = By.id("registeremail");
    private final By passwordTxt = By.id("registerpassword");
    private final By genderButton = By.xpath("//input[@value='male']");
    private final By AssertionMessage = By.xpath("//p[text()='First Name : Mahmoud']");

    public void enterRegisterData (String firstName,String lastName,String email, String password
    ) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstNameTxt)));
        driver.findElement(firstNameTxt).sendKeys(firstName);
        driver.findElement(lastNameTxt).sendKeys(lastName);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(genderButton).click();
        Thread.sleep(3000);

    }

    public String getAssertionMessage(){
        return driver.findElement(AssertionMessage).getText();
    }
}
