package com.test.blaze.tests;

import com.test.blaze.pages.BlazeHomePage;
import com.test.blaze.pages.BlazeLaptopsPage;
import com.test.blaze.pages.BlazeMacBookProPage;
import com.test.blaze.pages.BlazePlaceOrderPage;
import org.testng.annotations.Test;

public class BlazeMacBookProTest extends BlazeTestBase {

    @Test
    public void validateMacBookProInformation() throws InterruptedException {
        BlazeHomePage blazeHomePage = new BlazeHomePage(driver);
        blazeHomePage.findLaptopsOption("Laptops");
        BlazeLaptopsPage blazeLaptopsPage = new BlazeLaptopsPage(driver);
        blazeLaptopsPage.findMacBookPro(driver,"MacBook Pro");

        BlazeMacBookProPage blazeMacBookProPage = new BlazeMacBookProPage(driver);
        blazeMacBookProPage.macBookProInfo(driver, "MacBook Pro", "$1100 *includes tax", "Product description\n" +
                "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.","Product added");
    }



}
