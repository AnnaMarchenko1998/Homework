package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BlazeLaptopsPage {

    public  BlazeLaptopsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//h4//a[@class='hrefch']")
    List<WebElement> allLaptopHeaders;

    @FindBy (css = "#prev2")
    WebElement previousButton;

    @FindBy(xpath = "//h4[.=' PRODUCT STORE']")
    WebElement productStoreFooter;

    public void findMacBookPro(WebDriver driver, String laptopModelName) throws InterruptedException {

        BrowserUtils.scrollWithJS(driver,previousButton);
        Thread.sleep(1500);
        for (WebElement option : allLaptopHeaders){
            if (BrowserUtils.getText(option).equals(laptopModelName)){
                option.click();
                Thread.sleep(2000);
                break;
            }
        }
    }


}
