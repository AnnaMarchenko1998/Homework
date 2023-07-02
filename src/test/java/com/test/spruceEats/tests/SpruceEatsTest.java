package com.test.spruceEats.tests;

import com.test.spruceEats.pages.SpruceEatsHomePage;
import org.testng.annotations.Test;

public class SpruceEatsTest extends SpruceEatsTestBase{

    @Test
    public void validateReceipt() throws InterruptedException {
        SpruceEatsHomePage spruceEatsHomePage = new SpruceEatsHomePage(driver);
        spruceEatsHomePage.findFishAndSeafood(driver, "Fish for dinner", "6-Ingredient Roasted Salmon Fillets");
    }

}
