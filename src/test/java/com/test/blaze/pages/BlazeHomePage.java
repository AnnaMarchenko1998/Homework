package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BlazeHomePage {

    public BlazeHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//a[@id='itemc']")
    List<WebElement> allMenuOptions;

    @FindBy(css = "#cartur")
    WebElement cart;

    @FindBy (xpath = "//tr[@class='success']")
    List<WebElement> allProductFDescriptionCart;

    @FindBy (xpath = "//button[.='Place Order']")
    WebElement placeOrder;

    public void findLaptopsOption(String menuOption) throws InterruptedException {

        for (WebElement option : allMenuOptions){
            if (BrowserUtils.getText(option).equals(menuOption)){
                option.click();
                break;
            }
        }
        Thread.sleep(2000);
    }

    public void openCart(String expectedTitle, String expectedPrice ){
        cart.click();

        List<String> expectedOptionDescriptionCart =Arrays.asList("", expectedTitle, expectedPrice, "" );
        for(int i = 1; i < allProductFDescriptionCart.size()-1; i++){
            Assert.assertEquals(BrowserUtils.getText(allProductFDescriptionCart.get(i)), expectedOptionDescriptionCart.get(i));
        }
        placeOrder.click();
    }

}
