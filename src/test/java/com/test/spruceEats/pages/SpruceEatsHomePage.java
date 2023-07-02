package com.test.spruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SpruceEatsHomePage {

    public SpruceEatsHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredients;

    @FindBy (xpath = "//a[.='Fish & Seafood']")
    WebElement fishAndSeafood;

    @FindBy(css = "#search-form-input")
    WebElement searchBar;

    @FindBy (xpath = "//button[@id='button_1-0']")
    WebElement searchSubmitButton;

    @FindBy(css = "#starRating_score_4Star")
    WebElement forStarRating;

    @FindBy (xpath = "//label[@for='pop_search_editor']")
    WebElement popularChoice;

    @FindBy(xpath = "//h4[@class='card__title']")
    WebElement productName;

    public void findFishAndSeafood(WebDriver driver, String receiptName, String productName) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.click(ingredients);
        actions.click(fishAndSeafood);
        BrowserUtils.scrollWithJS(driver, searchBar);
        searchBar.sendKeys(receiptName);
        Thread.sleep(1500);
        searchSubmitButton.submit();
        if (forStarRating.isDisplayed() && fishAndSeafood.isEnabled() && !forStarRating.isSelected()){
            forStarRating.click();
        }

        if (!popularChoice.isSelected() && popularChoice.isEnabled() && popularChoice.isDisplayed()){
            popularChoice.click();
        }
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(this.productName), productName);
    }

}
