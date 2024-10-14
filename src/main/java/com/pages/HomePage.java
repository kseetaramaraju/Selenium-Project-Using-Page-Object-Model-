package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        logger.info("Selecting Men's product: " + name);
        element.click();
        
        return new CollectionsPage();
    }

    public CollectionsPage viewWomensProduct(String name) {

        logger.info("Navigating to Women's product category.");
        womens.click();
        WebElement element = driver.findElement(By.xpath("//p[normalize-space()='" + name + "']"));
        logger.info("Selecting Women's product: " + name);
        element.click();
        return new CollectionsPage();
    }

    public SocksPage viewSocks() {

        logger.info("Navigating to Socks category.");
        socks.click();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        // scrolling for specific pixels
       // js.executeScript("window.scrollBy(0,3000)","");
        WebElement anklesock = driver.findElement(By.xpath("//img[@alt='Anytime Ankle Sock - Basin Blue']"));
        js.executeScript("arguments[0].scrollIntoView();",anklesock);
        return new SocksPage();
    }

    public SalesPage viewSales() {

        logger.info("Navigating to Sales category.");
        sale.click();
        return new SalesPage();
    }

    public SearchPage searchItems() throws InterruptedException {

        logger.info("Opening search functionality.");
        search.click();

        WebElement element=driver.findElement(By.xpath("//input[@id='SearchBarMinimal__input']"));
        element.sendKeys("Mens Shoes");

        Thread.sleep(2000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
         //scrolling for specific pixels
         js.executeScript("window.scrollBy(0,3000)","");
        return new SearchPage();
    }

    public LoginPage viewAccount() {
        logger.info("Navigating to User account page.");
        user.click();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //scrolling for specific pixels
        js.executeScript("window.scrollBy(0,200)","");
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
