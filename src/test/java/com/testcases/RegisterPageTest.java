package com.testcases;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.base.TestBase;
import com.listeners.CustomListener;
import com.pages.RegisterPage;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners(CustomListener.class)
public class RegisterPageTest extends TestBase {

	RegisterPage page;

	public RegisterPageTest() {
		super();
	}

	@BeforeMethod
	@Step("Setting up browser and initializing the SignupPage object.")
	void setup() {
		init();
		page=new RegisterPage();
	}

	@Test(priority = 1)
	@Description("Test case to verify the register functionality with valid user details.")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Register Feature")
	@Story("As a new user, I want to register to the platform using valid credentials.")
	@Step("Performing registration with first name, last name, email, and password.")
	void registerTest() {
		page.Register(data.getProperty("firstName"), data.getProperty("lastName"), data.getProperty("email"), data.getProperty("password"), data.getProperty("password"));

	}

	@Test(priority = 2)
	@Description("Test case to verify that all register fields are displayed and enabled.")
	@Severity(SeverityLevel.MINOR)
	@Feature("Register Fields Validation")
	@Story("As a new user, I want to ensure that the register form fields are visible and functional.")
	@Step("Validating all register fields.")
	void validateRegisterFieldsTest() {
		assertTrue(page.validateFieldsOnRegisterPage(), "Some register fields are not displayed or enabled.");
	}

	@Test(priority = 3)
	@Description("Test case to verify the visibility and functionality of the Register button.")
	@Severity(SeverityLevel.MINOR)
	@Feature("Register Button Validation")
	@Story("As a new user, I want to ensure that the Register button is visible and functional.")
	@Step("Validating the Register button.")
	void validateRegisterButtonTest() {
		assertTrue(page.validateRegisterButton(), "Register button is not displayed or enabled.");
	}

	@Test(priority = 4)
	@Description("Test case to verify the register page title.")
	@Severity(SeverityLevel.MINOR)
	@Feature("Register Page Title Validation")
	@Story("As a new user, I want to ensure that the register page has the correct title.")
	@Step("Validating register page title.")
	void validateRegisterPageTitleTest() {
		String actualTitle = page.validateRegsiterPageTitle();
		assertEquals(actualTitle, "Login or Create an Account - Allbirds", "Signup page title does not match.");
	}

	@AfterMethod
	@Step("Closing the browser after register test execution.")
	void quit() {
		driver.quit();
	}


}
