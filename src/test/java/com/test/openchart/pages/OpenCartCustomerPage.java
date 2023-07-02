package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenCartCustomerPage {

    public OpenCartCustomerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement plusSign;

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//input[@name='confirm']")
    WebElement passwordConfirm;

    @FindBy(css = "#input-newsletter")
    WebElement newsletterButton;

    @FindBy(css = "#input-status")
    WebElement statusButton;

    @FindBy(css = "#input-safe")
    WebElement safeButton;

    @FindBy(xpath = "//div[@class='float-end']//button[@type='submit']")
    WebElement saveInfoButton;

    @FindBy (xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement errorMessage;

    @FindBy(css = "#footer")
    WebElement footer;


    public void addNewCustomer(WebDriver driver, String firstName, String lastName, String email, String password, String confirmPassword, String expectedErrorMessage) throws InterruptedException {
        plusSign.click();
        Thread.sleep(2000);

        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.passwordConfirm.sendKeys(confirmPassword);

        BrowserUtils.scrollWithJS(driver, footer);
        Thread.sleep(2000);
        if(newsletterButton.isDisplayed() && newsletterButton.isEnabled() && !newsletterButton.isSelected()){
            newsletterButton.click();
        }
        if (statusButton.isEnabled() && statusButton.isDisplayed() && !statusButton.isSelected()){
            statusButton.click();
        }
        if (safeButton.isDisplayed() && safeButton.isEnabled() && !safeButton.isSelected()){
            safeButton.click();
        }
        BrowserUtils.scrollWithJS(driver, saveInfoButton);
        Thread.sleep(2000);
        saveInfoButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(errorMessage), expectedErrorMessage);


    }

}
