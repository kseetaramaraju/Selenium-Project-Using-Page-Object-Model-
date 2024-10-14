package com.pages;

import com.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CollectionsPage extends TestBase {

    public static Logger logger=Logger.getLogger(CollectionsPage.class);

    @FindBy(xpath = "//*[@id=\"parent-collection-container\"]/div/div/div[1]/div[2]/div[2]/div/div[3]/div[1]/div/div/div/div/div[1]/a")
    WebElement product;

    public CollectionsPage() {
        PageFactory.initElements(driver, this);
        logger.info("CartPage elements initialized.");
    }

    public ProductPage productPage() {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 1000)");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        product.click();
        return new ProductPage();

    }
}
