package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;



public class HomePage extends TestBase{
	public static Logger logger = Logger.getLogger(HomePage.class);

    @FindBy(xpath = "//*[@id=\"top-navigation\"]/nav/ul[1]/li[1]/div/button")
    WebElement mens;

    @FindBy(xpath = "//*[@id=\"top-navigation\"]/nav/ul[1]/li[2]/div/button")
    WebElement womens;

    @FindBy(xpath = "//*[@id=\"top-navigation\"]/nav/ul[1]/li[3]/div/a")
    WebElement socks;

    @FindBy(xpath = "//*[@id=\"top-navigation\"]/nav/ul[1]/li[4]/div/button")
    WebElement sale;

    @FindBy(xpath = "//*[@id=\"top-navigation\"]/nav/ul[2]/li[4]/a")
    WebElement search;

    @FindBy(xpath = "//*[@id=\"top-navigation\"]/nav/ul[2]/li[5]/div/a")
    WebElement user;

    @FindBy(xpath = "//*[@id=\"top-navigation\"]/nav/ul[2]/li[7]/button")
    WebElement cart;

    public HomePage() {
        PageFactory.initElements(driver, this);
        logger.info("HomePage elements initialized.");
    }

    public CollectionsPage viewMensProduct(String name) {

        logger.info("Navigating to Men's product category.");
        mens.click();
        
        WebElement element = driver.findElement(By.xpath("//p[normalize-space()='" + name + "']"));
        Actions act = new Actions(driver);
        logger.info("Selecting Men's product: " + name);
        act.moveToElement(element).click().perform();
        
        return new CollectionsPage();
    }

    public CollectionsPage viewWomensProduct(String name) {

        logger.info("Navigating to Women's product category.");
        womens.click();
        WebElement element = driver.findElement(By.xpath("//p[normalize-space()='" + name + "']"));
        Actions act = new Actions(driver);
        logger.info("Selecting Women's product: " + name);
        act.moveToElement(element).click().perform();
        return new CollectionsPage();
    }

    public SocksPage viewSocks() {

        logger.info("Navigating to Socks category.");
        socks.click();
        return new SocksPage();
    }

    public SalesPage viewSales() {

        logger.info("Navigating to Sales category.");
        sale.click();
        return new SalesPage();
    }

    public SearchPage searchItems() {

        logger.info("Opening search functionality.");
        search.click();
        return new SearchPage();
    }

    public LoginPage viewAccount() {
        logger.info("Navigating to User account page.");
        user.click();
        return new LoginPage();
    }

    public CartPage viewCart() {
        logger.info("Navigating to Cart page.");
        cart.click();
        return new CartPage();
    }
    
    // Validate that the title of the homepage is correct
    public String validateHomePageTitle() {

        String actualTitle = driver.getTitle();
        logger.info("Validating home page title: Actual - " + actualTitle);
   return actualTitle;
    }

    public boolean validateMensCategoryPresence() {

        logger.info("Validating Men's category button is displayed.");
        return mens.isDisplayed();
    }

    public boolean validateCartButtonPresence() {

        logger.info("Validating Cart button is displayed.");
        return cart.isEnabled();
    }

}
