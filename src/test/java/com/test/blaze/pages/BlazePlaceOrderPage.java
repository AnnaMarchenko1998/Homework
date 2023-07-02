package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazePlaceOrderPage {

    public BlazePlaceOrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#name")
    WebElement name;

    @FindBy (css = "#country")
    WebElement country;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#card")
    WebElement card;

    @FindBy(css = "#month")
    WebElement month;

    @FindBy(css = "#year")
    WebElement year;

    @FindBy (xpath = "//button[@onclick='purchaseOrder()']")
    WebElement purchaseButton;

    @FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']//h2")
    WebElement thankYouMessage;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;


    public void fillOutCustomerInfo(WebDriver driver, String name, String country, String city, String card, String month, String year, String expectedMessage, String expectedUrl) throws InterruptedException {
        this.name.sendKeys(name);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        this.card.sendKeys(card);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        purchaseButton.click();
        Thread.sleep(1500);
        Assert.assertEquals(BrowserUtils.getText(thankYouMessage),expectedMessage );
        okButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

    }

}
