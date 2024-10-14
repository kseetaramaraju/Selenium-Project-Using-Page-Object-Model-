package com.pages;

import com.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ProductPage extends TestBase{

    public static Logger logger=Logger.getLogger(ProductPage.class);
    @FindBy(xpath = "//div[@class='jsx-3582184252 ColorSwatch']")
    WebElement selectEdition;


    @FindBy(xpath = "//button[@aria-label='Add Size 9']//span[@class='jsx-32168038 jsx-1605516658 SizeButton-content']")
    WebElement size;

    @FindBy(xpath = "//button[@id='add-to-cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    WebElement conButton;

    public ProductPage() {
        PageFactory.initElements(driver, this);
        logger.info("CartPage elements initialized.");
    }

    public HomePage selectProduct() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        selectEdition.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        size.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        addToCartBtn.click();
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
