package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSPractice {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
        WebElement yesBttn = driver.findElement(By.cssSelector("#yesRadio"));
      //  yesBttn.click();
//        Actions actions = new Actions(driver);
//        actions.click(yesBttn).perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", yesBttn);
        WebElement message = driver.findElement(By.cssSelector(".mt-3"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "You have selected Yes";
        Assert.assertEquals(actualMessage,expectedMessage);

        WebElement noRadioBttn = driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertTrue(!noRadioBttn.isEnabled());
    }

    @Test
    public void ScrollIntView(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement findCourseBttn = driver.findElement(By.xpath("//span[contains(text(),'which course')]//.."));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",findCourseBttn);
        findCourseBttn.click();
    }

    @Test
    public void practice2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement copyrightText = driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",copyrightText);
        Assert.assertEquals(BrowserUtils.getText(copyrightText),"Copyright © 2023");
        WebElement applyBttn = driver.findElement(By.xpath("//span[contains(text(),'Apply Now')]"));
        js.executeScript("arguments[0].scrollIntoView(true)",applyBttn);
        js.executeScript("arguments[0].click()",applyBttn);
        List<WebElement> headers = driver.findElements(By.xpath("//div[@id='el_1658248667273_2363']//h3"));
        List<String> expectedHeaders = Arrays.asList("info@techtorialacademy.com", "+ 1 (224) 570 91 91", "Chicago & Houston");

        for (int i = 0; i < headers.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(headers.get(i)), expectedHeaders.get(i));
        }
        js.executeScript("return document.title");

    }
}
