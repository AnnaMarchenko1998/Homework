package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankCustomerPage {

    public BankCustomerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#userSelect")
    WebElement yourNameBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement welcomeMessage;

    @FindBy (xpath = "//button[@ng-click='deposit()']")
    WebElement depositButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement depositAmountBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement confirmDepositAmountButton;

    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement depositSuccessfullyMessage;

    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    WebElement withdrawlButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement withdrawlAmountBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement confirmWithdrawlButton;

    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement transactionSuccessfulMessage;

    @FindBy(xpath = "//div[@ng-hide='noAccount']//strong[2]")
    WebElement balance;

    @FindBy(xpath = "//button[@ng-click='transactions()']")
    WebElement transactionsButton;

    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement creditInfo;

    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement debitInfo;


    public void findYourName(String yourName, String expectedMessage){
        yourNameBox.sendKeys(yourName);
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(welcomeMessage), expectedMessage );
    }


    public void deposit(String depositAmount, String expectedDepositMessage){
        depositButton.click();
        depositAmountBox.sendKeys(depositAmount);
        confirmDepositAmountButton.click();

        Assert.assertEquals(BrowserUtils.getText(depositSuccessfullyMessage), expectedDepositMessage);
    }

    public void withdrawl(String withdrawlAmount, String expectedWithdrawlMessage) throws InterruptedException {
        withdrawlButton.click();
        Thread.sleep(2000);
        withdrawlAmountBox.sendKeys(withdrawlAmount);
        Thread.sleep(2000);
        confirmWithdrawlButton.submit();
        Thread.sleep(2000);

        Assert.assertEquals(BrowserUtils.getText(transactionSuccessfulMessage),expectedWithdrawlMessage);
    }

    public void balance(){
        transactionsButton.click();
        int currentBalance = Integer.parseInt(BrowserUtils.getText(this.balance));
        int substraction = (Integer.parseInt(BrowserUtils.getText(creditInfo)) - Integer.parseInt(BrowserUtils.getText(debitInfo)));
        Assert.assertEquals(substraction, currentBalance);

        }



    }


