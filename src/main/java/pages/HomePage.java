package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    
    private final By accountManagerIcon = By.cssSelector("body > div.page-wrapper > header > div.sticky-wrapper > div > div > div.header-right > div.dropdown.cart-dropdown.clsMobileLogin > a > svg");
    private final By signUpButton = By.xpath("//*[@id=\"clsLoginregister\"]/div[2]/div[1]/a[3]");
    private final By ContactUsPage = By.cssSelector("body > div.page-wrapper > header > div.header-top > div > div.header-left.header-dropdowns.clsMobTop > p.welcome-msg1.clsTopContact > a");
    private final By logoutButton = By.cssSelector("body > div.page-wrapper > header > div.header-top > div > div.header-right > p:nth-child(2) > a");

    @Step("navigate to register page")
    public RegisterPage navigateToRegisterPage() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(accountManagerIcon)));
        driver.findElement(accountManagerIcon).click();
        Thread.sleep(2000);
        driver.findElement(signUpButton).click();


        return  new RegisterPage(driver);
    }

    @Step("navigate tp contact us page")
    public ContactUsPage navigateToContactUs() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(ContactUsPage).click();
        return new ContactUsPage(driver);
    }

    public void logout(){
        driver.findElement(logoutButton).click();
    }


    public LoginPage navigateToLoginPage(){
        driver.findElement(accountManagerIcon).click();
        return new LoginPage(driver);
    }
}
