package com.testcases;

import com.base.TestBase;
import com.listeners.CustomListener;
import com.pages.CollectionsPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class CartPageTest  extends TestBase {

    HomePage homePage;
    LoginPage login;
    CollectionsPage collectionsPage;
    ProductPage productPage;
    @BeforeMethod
    void setup() {
        init();
        homePage=new HomePage();
    }

    @Test(priority = 1)
    @Description("Test case is user to select the product and add cart after that user is able to view the cart items.")
    @Severity(SeverityLevel.NORMAL)
    @Feature("View Cart")
    @Story("As a user,add product to the cart after user is view the product in the cart items")
    @Step("Viewing the Cart Page")
    void viewCartTest() {
        login =homePage.viewAccount();
        homePage = login.login(data.getProperty("email"), data.getProperty("password"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //driver.navigate().to("https://www.allbirds.com/");
        collectionsPage = homePage.viewMensProduct("Active Shoes");
        productPage = collectionsPage.productPage();
        homePage = productPage.selectProduct();
        //driver.navigate().to("https://www.allbirds.com/");
        homePage.viewCart();

    }

    @AfterMethod
    void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
