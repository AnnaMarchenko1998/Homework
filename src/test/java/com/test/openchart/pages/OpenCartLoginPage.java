package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenCartLoginPage {


    public OpenCartLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwords;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(css = "#alert")
    WebElement popUpMessage;

    public void loginFunctionality(String username, String password) throws InterruptedException {
        this.userName.sendKeys(username);
        this.passwords.sendKeys(password);
        loginButton.submit(); Thread.sleep(2000);
    }

    public String errorMessage(){
        return BrowserUtils.getText(popUpMessage);
    }

}
