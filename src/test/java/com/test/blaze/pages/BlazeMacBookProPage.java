package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazeMacBookProPage {

    public BlazeMacBookProPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='name']")
    WebElement header;

    @FindBy(xpath = "//h3[@class='price-container']")
    WebElement price;

    @FindBy (xpath = "//div[@id='more-information']")
    WebElement description;

    @FindBy(xpath = "//a[@onclick='addToCart(15)']")
    WebElement addToCart;

    public void macBookProInfo(WebDriver driver, String expectedHeader, String expectedPrice, String expectedDescription, String expectedAlertMessage) throws InterruptedException {
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(price), expectedPrice);
        Assert.assertEquals(BrowserUtils.getText(description),expectedDescription );
        addToCart.click();
        Thread.sleep(1500);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectedAlertMessage);
        alert.accept();
    }
}
