package tests;

import data.CheckoutData;
import data.RegisterData;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.awt.*;
import java.io.IOException;

public class CheckoutTest extends TestBase{
    HomePage homePage;
    RegisterPage registerPage;
    SearchPage searchPage;
    AddToCartPage add;
    CheckoutPage checkoutPage;
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
    @Test(priority = 2)
    public void searchForProducts() throws AWTException {
        searchPage = new SearchPage(driver);
        searchPage.searchForItems("Adidas Men Sport Shoes Dark Gray");
    }

    @Test(priority = 3)
    public void addProductToCart() throws InterruptedException {
        add = new AddToCartPage(driver);
        add.addProductToCart();
        Assert.assertEquals(add.getAssertionMessage(),"Adidas Men Sport Shoes Dark Gray");
        Thread.sleep(1000);
    }

    @Test(priority = 4)
    public void navigateToCheckOutPage(){
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.navigateToCheckOutPage();
    }

    @Test(priority = 5)
    public void enterUserData() throws IOException, ParseException, InterruptedException {
        CheckoutData data = new CheckoutData();
        data.checkoutData();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterUserData(data.firstName, data.lastName, data.mobile, data.address, data.city, data.landmark, data.postcode);
        Thread.sleep(10000);

    }

    @Test(priority = 6)
    public void chosePaymentMethode() throws InterruptedException {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.chosePaymentMethode();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getAssertionMessage(),"Your Order has been successfully done.");
    }


}
