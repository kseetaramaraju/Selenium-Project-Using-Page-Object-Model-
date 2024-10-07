package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;


public class LoginPage extends TestBase{
	 public static Logger logger = Logger.getLogger(LoginPage.class);

	    @FindBy(xpath = "//input[@id='CustomerEmail']")
	    WebElement email;

	    @FindBy(xpath = "//input[@id='CustomerPassword']")
	    WebElement password;

	    @FindBy(xpath = "//*[@id=\"customer_login\"]/input[5]")
	    WebElement signIn;
	    
	    @FindBy(xpath = "//*[@id=\"customer_login\"]/div/ul/li")
	    WebElement errorMessage;

	@FindBy(xpath = "//div[@class='jsx-2022988330 Icon Icon--USER jsx-3907305029 jsx-85518033']//*[name()='svg']")
	WebElement user;


	public LoginPage() {
	        PageFactory.initElements(TestBase.driver, this);
	        logger.info("LoginPage elements initialized.");
	    }

	    public HomePage login(String email, String password) {

			user.click();
	        logger.info("Attempting login with email: " + email);
	        this.email.sendKeys(email);
	        this.password.sendKeys(password);
	        signIn.click();
	        logger.info("Login form submitted.");
	        return new HomePage();
	    }
	    
	    public String validateLoginPageTitle() {
			user.click();
	        String actualTitle = driver.getTitle();
	        logger.info("Validating login page title:  "+", Actual - " + actualTitle);
	        return actualTitle;
	    }
	    
	    public boolean validateEmailAndPasswordFields() {
			user.click();
	        logger.info("Validating email and password fields are enabled.");
	        return email.isDisplayed()&&password.isDisplayed();
	    }
	    
	    public boolean validateSignInButton() {
			user.click();
	        logger.info("Validating that the Sign-in button is displayed and enabled.");
	        return signIn.isDisplayed() && signIn.isEnabled();
	    }

	    public boolean validateErrorMessageForInvalidLogin() {
			user.click();
	        logger.info("Validating the error message for incorrect login credentials.");
	        return errorMessage.isDisplayed();
	    }

}
