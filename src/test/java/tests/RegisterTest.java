package tests;

import data.RegisterData;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;

public class RegisterTest extends TestBase{
    HomePage homePage;
    RegisterPage registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    @Step("navigate to create account page")
    public void navigateToRegisterPage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
    }
    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException, InterruptedException {
        registerPage = new RegisterPage(driver);
        RegisterData data = new RegisterData();
        data.registerData();

        registerPage.enterRegisterData(
                data.firstName, data.lastName,data.email+currentTime+"@gmail.com", data.password);

        Assert.assertEquals(registerPage.getAssertionMessage(),"First Name : Mahmoud");

    }
}
