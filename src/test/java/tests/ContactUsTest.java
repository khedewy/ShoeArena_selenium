package tests;

import data.ContactUsData;
import data.RegisterData;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;

public class ContactUsTest extends TestBase {
    HomePage homePage;
    RegisterPage registerPage;
    ContactUsPage contactUsPage;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    @Step("navigate to create account page")
    public void navigateToRegisterPage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
    }
    @Test(priority = 1)
    @Step("enter register data")
    public void enterRegisterData() throws IOException, ParseException, InterruptedException {
        registerPage = new RegisterPage(driver);
        RegisterData data = new RegisterData();
        data.registerData();

        registerPage.enterRegisterData(
                data.firstName, data.lastName,data.email+currentTime+"@gmail.com", data.password);

        Assert.assertEquals(registerPage.getAssertionMessage(),"First Name : Mahmoud");

    }

    @Test(priority = 2)
    @Step("navigate to contact us page")
    public void navigateToContactUsPage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.navigateToContactUs();
    }

    @Test(priority = 3)
    @Step("enter contact us data")
    public void contactUs() throws IOException, ParseException, InterruptedException {
        contactUsPage = new ContactUsPage(driver);
        ContactUsData data = new ContactUsData();
        data.contactUsData();
        contactUsPage.enterContactUsData(data.mobile, data.subject, data.message);
    }
}
