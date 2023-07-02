package com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCartHomePage {

    public OpenCartHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".btn-close")
    WebElement closePopupWindow;

    @FindBy (css = "#menu-customer")
    WebElement customerMenu;

    @FindBy(xpath = "//ul[@id='collapse-5']//li//a[.='Customers']")
    WebElement subCustomersButton;

    public void findCustomerPageCreation() throws InterruptedException {
        closePopupWindow.click();
        Thread.sleep(1500);
        customerMenu.click();
        Thread.sleep(1500);
        subCustomersButton.click();
        Thread.sleep(1500);
    }



}
