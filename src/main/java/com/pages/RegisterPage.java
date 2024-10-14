package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;



public class RegisterPage extends TestBase {
	public static Logger logger = Logger.getLogger(RegisterPage.class);

    @FindBy(id = "FirstName")
    WebElement firstName;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "CreatePassword")
    WebElement password;

    @FindBy(id = "CustomerPasswordConfirmation")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@value='Register']")
    WebElement register;

    @FindBy(xpath = "//a[@href='/account']//div//*[local-name()='svg']")
    WebElement user;




    public RegisterPage() {
        PageFactory.initElements(driver, this);
        logger.info("Registration Page elements initialized.");
    }

    public HomePage Register(String firstName, String lastName, String email, String password, String confirmPassword) {

//        driver.navigate().to("https://www.allbirds.com/account/login?return_url=%2Faccount");
        user.click();
        logger.info("Filling in register details: FirstName=" + firstName + ", LastName=" + lastName + ", Email=" + email);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
        logger.info("Submitting register form.");
        register.click();
        return new HomePage();
    }
    
    public boolean validateRegisterButton() {
//        driver.navigate().to("https://www.allbirds.com/account/login?return_url=%2Faccount");
        user.click();
        logger.info("Validating that the Register button is displayed and enabled.");
        return register.isDisplayed() && register.isEnabled();
    }

    public boolean validateFieldsOnRegisterPage() {
//        driver.navigate().to("https://www.allbirds.com/account/login?return_url=%2Faccount");
        user.click();
        logger.info("Validating that the register fields are displayed and enabled.");
        return firstName.isDisplayed() && lastName.isDisplayed() && email.isDisplayed() && password.isDisplayed() && confirmPassword.isDisplayed();
    }

    public String validateRegsiterPageTitle() {
//        driver.navigate().to("https://www.allbirds.com/account/login?return_url=%2Faccount");
        user.click();
        String title = driver.getTitle();
        logger.info("Signup page title: " + title);
        return title;
    }

}
