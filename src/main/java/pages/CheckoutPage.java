package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    Select select;
    WebDriverWait wait;
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    private final By checkoutButton = By.xpath("//a[text()='Proceed To Checkout']");
    private final By firstNameTxt = By.id("input-payment-firstname");
    private final By lastNameTxt = By.id("input-payment-lastname");
    private final By mobileTxt = By.id("input-payment-telephone");
    private final By addressTxt = By.id("input-payment-address-1");
    private final By cityTxt = By.id("input-payment-city");
    private final By landMarkTxt = By.id("input-payment-address-2");
    private final By postCodeTxt = By.id("input-payment-postcode");
    private final By continueButton = By.id("button-payment-address");
    private final By paymentMethode = By.id("cod");
    private final By confirmOrderButton = By.id("button-payment-method");
    private final By AssertionMessage = By.xpath("//p[text()='Your Order has been successfully done.']");

    public void navigateToCheckOutPage(){
        driver.findElement(checkoutButton).click();
    }
    public void enterUserData(String firstName, String lastName, String mobile, String address, String city, String landMark
    ,String postCode){
        driver.findElement(firstNameTxt).sendKeys(firstName);
        driver.findElement(lastNameTxt).sendKeys(lastName);
        driver.findElement(mobileTxt).sendKeys(mobile);
        driver.findElement(addressTxt).sendKeys(address);
        select = new Select(driver.findElement(cityTxt));
        select.selectByVisibleText(city);
        driver.findElement(landMarkTxt).sendKeys(landMark);
        driver.findElement(postCodeTxt).sendKeys(postCode);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(continueButton)));
        driver.findElement(continueButton).click();
    }

    public void chosePaymentMethode() throws InterruptedException {
        driver.findElement(paymentMethode).click();
        driver.findElement(confirmOrderButton).click();
    }

    public String getAssertionMessage(){
        return driver.findElement(AssertionMessage).getText();
    }
}
