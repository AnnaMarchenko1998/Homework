package com.test.openchart.tests;

import com.test.openchart.pages.OpenCartCustomerPage;
import com.test.openchart.pages.OpenCartHomePage;
import com.test.openchart.pages.OpenCartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartCustomerTest extends OpenCartTestBase{

    @Test
    public void ValidatingCustomerPageFunctionality() throws InterruptedException {
        OpenCartLoginPage openCartLoginPage = new OpenCartLoginPage(driver);
        openCartLoginPage.loginFunctionality("demo","demo");
        Assert.assertEquals(driver.getTitle().trim(), "Dashboard");
        OpenCartHomePage openCartHomePage = new OpenCartHomePage(driver);
        openCartHomePage.findCustomerPageCreation();
        OpenCartCustomerPage openCartCustomerPage = new OpenCartCustomerPage(driver);
        openCartCustomerPage.addNewCustomer(driver,"Anna","March","sff@gmail.com","1234","1234", "Warning:You do not have permission to modify customers!");

    }


}
