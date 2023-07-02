package com.test.bank.tests;

import com.test.bank.pages.BankCustomerPage;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankCustomerTest extends BankTestBase{

    @Test
    public void validateCustomersDepositAndWithdrawlFunctionality() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Anna", "March", "60126", "Customer added successfully with customer id");
        bankManagerPage.openAccountFeature(driver, "Anna March", "Dollar", "Account created successfully with account Number");

        bankManagerPage.customersFunctionality("Anna","March", "60126");
        bankManagerPage.clickHomeButton();
        bankLoginPage.clickCustomerButton();

        BankCustomerPage bankCustomerPage = new BankCustomerPage(driver);
        bankCustomerPage.findYourName("Anna","Welcome Anna March !!");
        bankCustomerPage.deposit("500", "Deposit Successful");
        bankCustomerPage.withdrawl("300","Transaction successful");
        bankCustomerPage.balance();

    }


}
