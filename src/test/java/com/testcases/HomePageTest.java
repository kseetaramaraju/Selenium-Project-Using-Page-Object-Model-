package com.testcases;

import com.pages.CollectionsPage;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.listeners.CustomListener;
import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners(CustomListener.class)
public class HomePageTest extends TestBase{
	
	HomePage homePage;
	LoginPage login;

	public HomePageTest() {

		super();
	}

	@BeforeMethod
	@Step("Setting up the browser and logging in to the application.")
	void setup() {
		init();
		login = new LoginPage();
		homePage = login.login(data.getProperty("email"), data.getProperty("password"));
	}

	@Test(priority = 1)
	@Description("Test case to view Men's products under the category 'Everyday Sneakers'.")
	@Severity(SeverityLevel.NORMAL)
	@Feature("View Men's Products")
	@Story("As a user, I want to view the men's products from the category Everyday Sneakers.")
	@Step("Viewing Men's products: Everyday Sneakers.")
	void viewMensProduct() {
		CollectionsPage viewMensProduct = homePage.viewMensProduct("Everyday Sneakers");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	@Description("Test case to view Women's products under the category 'Shop all'.")
	@Severity(SeverityLevel.NORMAL)
	@Feature("View Women's Products")
	@Story("As a user, I want to view the women's products from the category Shop all.")
	@Step("Viewing Women's products: Shop all.")
	void viewWomensProduct()
	{
		homePage.viewWomensProduct("Flats");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	@Description("Test case to view available socks.")
	@Severity(SeverityLevel.MINOR)
	@Feature("View Socks")
	@Story("As a user, I want to view the available socks.")
	@Step("Viewing available socks.")
	void viewSocks() {
		homePage.viewSocks();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	@Test(priority = 4)
	@Description("Test case to view ongoing sales.")
	@Severity(SeverityLevel.MINOR)
	@Feature("View Sales")
	@Story("As a user, I want to view the ongoing sales.")
	@Step("Viewing available sales.")
	void viewSales() {
		homePage.viewSales();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	@Description("Test case to search for items on the homepage.")
	@Severity(SeverityLevel.MINOR)
	@Feature("Search Items")
	@Story("As a user, I want to search for products on the homepage.")
	@Step("Searching for items on the homepage.")
	void searchItems() throws InterruptedException {
		homePage.searchItems();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 6)
	@Description("Test case to view the user's account.")
	@Severity(SeverityLevel.MINOR)
	@Feature("View Account")
	@Story("As a user, I want to view my account details.")
	@Step("Viewing the user's account.")
	void viewAccount() {
		homePage.viewAccount();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 7)
	@Description("Test case to view the cart.")
	@Severity(SeverityLevel.MINOR)
	@Feature("View Cart")
	@Story("As a user, I want to view my cart.")
	@Step("Viewing the cart.")
	void viewCart() {
		homePage.viewCart();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 8)
	@Description("validating home page title ")
	@Severity(SeverityLevel.MINOR)
	@Feature("getting home page title")
	@Story("As a user, I want to validate home page title")
	@Step("capturing home page title")
	void testValidateHomePageTitle() {
		
		AssertJUnit.assertEquals(homePage.validateHomePageTitle(),"My Account - Allbirds");
		
	}
	
	@Test(priority = 9)
	@Description("Test mens category .")
	@Severity(SeverityLevel.MINOR)
	@Feature("Mens Category")
	@Story("As a user, I want to view mens Catagory.")
	@Step("Viewing the Mens Catogory.")
	void testValidateMensCategoryPresence(){

		AssertJUnit.assertTrue(homePage.validateMensCategoryPresence());
	}
	
	@Test(priority = 10)
	@Description("Test case to validate cart button.")
	@Severity(SeverityLevel.MINOR)
	@Feature("Cart button")
	@Story("As a user, I want click on cart button.")
	@Step("clicking on the cart button")
	void testValidateCartButtonPresence() {
		AssertJUnit.assertTrue(homePage.validateCartButtonPresence());
	}
	

	@AfterMethod
	@Step("Closing the browser after test execution.")
	void shutdown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}


}
