package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {
    WebDriver driver;
    WebDriverWait wait;
    Select select;
    public ContactUsPage(WebDriver driver){
        this.driver = driver;
    }

    private final By mobileTxt = By.id("contact-mobile");
    private final By subjectList = By.id("contact-subject");
    private final By messageTxt = By.id("contact-enquiry");
    private final By submitButton = By.name("submit");


    @Step("enter contact us data")
    public void enterContactUsData(String mobile, String subject,String message)  {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(mobileTxt)));
        driver.findElement(mobileTxt).sendKeys(mobile);
        select = new Select(driver.findElement(subjectList));
        select.selectByVisibleText(subject);
        driver.findElement(messageTxt).sendKeys(message);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(mobileTxt)));
        driver.findElement(submitButton).click();
    }
    
}
