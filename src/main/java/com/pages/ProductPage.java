package com.pages;

import com.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ProductPage extends TestBase{

    public static Logger logger=Logger.getLogger(ProductPage.class);
    @FindBy(xpath = "//*[@id=\"pdp-container\"]/div/div/div/div[1]/div[1]/div/div/div[1]/button[2]")
    WebElement image;

    @FindBy(xpath = "//*[@id=\"pdp-container\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div[2]/button[2]")
    WebElement color;

    @FindBy(xpath = "//*[@id=\"pdp-size-selector\"]/ul/li[2]/button")
    WebElement size;

    @FindBy(id = "add-to-cart")
    WebElement button;

    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    WebElement conButton;

    public ProductPage() {
        PageFactory.initElements(driver, this);
        logger.info("CartPage elements initialized.");
    }

    public HomePage selectProduct() {
        image.click();
        color.click();
        size.click();
        button.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // driver.switchTo().frame("//*[@id=\"men-39-s-trail-runners-swt-blizzard-natural-black-blizzard-sole\"]/div[25]/div");

        //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //  WebElement conButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Continue Shopping')]")));
        conButton.click();
        return new HomePage();
    }



}
