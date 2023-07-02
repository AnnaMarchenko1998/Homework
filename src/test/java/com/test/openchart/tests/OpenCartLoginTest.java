package com.test.openchart.tests;

import com.test.openchart.pages.OpenCartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartLoginTest extends OpenCartTestBase{

    @Test
    public void happyPathLoginPage() throws InterruptedException {
        OpenCartLoginPage openCartLoginPage = new OpenCartLoginPage(driver);
        openCartLoginPage.loginFunctionality("demo","demo");
        Assert.assertEquals(driver.getTitle().trim(), "Dashboard");
    }

    @Test
    public void validateNegativeLoginPage() throws InterruptedException {
        OpenCartLoginPage openCartLoginPage = new OpenCartLoginPage(driver);
        openCartLoginPage.loginFunctionality("anna","1234");
        Assert.assertEquals(openCartLoginPage.errorMessage(),"No match for Username and/or Password.");
    }



}
