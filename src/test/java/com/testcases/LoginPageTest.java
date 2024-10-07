package com.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.listeners.CustomListener;
import com.pages.LoginPage;
import com.utility.UtilityTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


@Listeners(CustomListener.class)
public class LoginPageTest extends TestBase
{
	LoginPage login;
	UtilityTest utility;


	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	void setup() {
		init();
		login = new LoginPage();
		utility=new UtilityTest();
	}

	@Test(priority = 1)
	@Description("Test case to verify the login functionality with valid credentials.")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user, I want to log in to the application with valid credentials.")
	@Feature("Login with Single User")
	@Step("Logging into the application with valid credentials")
	void loginTest() {

		login.login(data.getProperty("email"), data.getProperty("password"));
	}


	@DataProvider(name = "loginData")
	public Object[][] loginData() {

		Object[][] data = utility.getDataFromSheet("Sheet1","src\\main\\java\\com\\base\\testdata\\exceldata.xlsx"); 
		utility.closeWorkbook();
		return data;
	}


	@Test(dataProvider = "loginData",priority = 1)
	public void testLogin(String username, String password) {
		login.login(username, password);
		String expectedTitle = "Dashboard"; // Example title
		assertEquals(driver.getTitle(), expectedTitle, "Login failed for user: " + username);
	}



	@Test(priority = 2)
	@Description("Test case to verify the login failure with incorrect credentials.")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user, I want to receive an error message when logging in with invalid credentials.")
	@Feature("Login Failure")
	@Step("Attempting login with invalid credentials")
	void loginFailureTest() {
		login.login("invalid-email@example.com", "wrongPassword");
		assertTrue(login.validateErrorMessageForInvalidLogin(), "Error message not displayed for invalid login.");
	}

	@Test(priority = 3)
	@Description("Test case to verify that the login page title is correct.")
	@Severity(SeverityLevel.MINOR)
	@Story("As a user, I want to ensure that the login page has the correct title.")
	@Feature("Login Page Title")
	@Step("Validating login page title")
	void validateLoginPageTitleTest() {
		assertEquals(login.validateLoginPageTitle(), "Login or Create an Account - Allbirds", "Login page title does not match.");
	}

	@Test(priority = 4)
	@Description("Test case to verify that the email and password fields are visible and enabled.")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user, I want to ensure that the email and password fields are functional.")
	@Feature("Email and Password Fields")
	@Step("Validating email and password fields")
	void validateEmailAndPasswordFieldsTest() {
		assertTrue(login.validateEmailAndPasswordFields(), "Email or password fields are not displayed or enabled.");
	}

	@Test(priority = 5)
	@Description("Test case to verify that the sign-in button is visible and enabled.")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user, I want to ensure that the sign-in button is functional.")
	@Feature("Sign-in Button")
	@Step("Validating the sign-in button")
	void validateSignInButtonTest() {
		assertTrue(login.validateSignInButton(), "Sign-in button is not displayed or enabled.");
	}

	@Test(priority = 6)
	@Description("Test case to verify that an error message is shown for invalid credentials.")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user, I want to be notified when entering invalid login credentials.")
	@Feature("Login Error Message")
	@Step("Verifying error message for invalid login credentials")
	void validateErrorMessageForInvalidLoginTest() {
		login.login("invalid-email@example.com", "wrongPassword");
		assertTrue(login.validateErrorMessageForInvalidLogin(), "Error message not displayed for invalid login.");
	}

	
	@AfterMethod
	void tearDown() {
		driver.quit();
	}


}
