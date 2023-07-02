package com.test.bank.pages;

import Utils.BrowserUtils;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {

    public  BankManagerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerBtn;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccount;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customers;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCustomerBtn;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountBtn;

    @FindBy (css = "#userSelect")
    WebElement customerName;

    @FindBy(css = "#currency")
    WebElement currency;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement processOpenAccountButton;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customerButton;

    @FindBy(xpath = "//input[@type='text']")
    WebElement searchCustomerBox;

    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> allCustomerInformation;

    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homeButton;

    public void addCustomerFunctionality(WebDriver driver, String firstName, String lastName, String postCode, String expectedMessage){
        addCustomerBtn.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        submitAddCustomerBtn.submit();

        Alert alert =driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }


    public void openAccountFeature(WebDriver driver, String name, String currency, String expectedMessage ){
        this.openAccountBtn.click();
        BrowserUtils.selectBy(customerName, name, "text");
        BrowserUtils.selectBy(this.currency, currency, "value");
        processOpenAccountButton.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }

    public void customersFunctionality(String customerName, String lastName, String postCode){
        this.customerButton.click();
        searchCustomerBox.sendKeys(customerName);
        List<String> expectedList = Arrays.asList(customerName,lastName,postCode);

        for(int i=0; i<allCustomerInformation.size(); i++){
            Assert.assertEquals(BrowserUtils.getText(allCustomerInformation.get(i)), expectedList.get(i));
        }
    }

    public void clickHomeButton(){
        homeButton.click();
    }




}
