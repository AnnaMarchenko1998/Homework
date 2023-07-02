package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectMidLevelPractice {

    /*
    https://demo.guru99.com/test/newtours/reservation.php
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
     */
    @Test
    public void validateOrderMessage(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(" https://demo.guru99.com/test/newtours/reservation.php");
        WebElement tripType = driver.findElement(By.xpath("//input[@value='oneway']"));
        tripType.click();
        WebElement passenger = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passangers = new Select(passenger);
        passangers.selectByIndex(3);
        WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departFromselection = new Select(departingFrom);
        Assert.assertEquals(departFromselection.getFirstSelectedOption().getText().trim(), "Acapulco");
        departFromselection.selectByVisibleText("Paris");
        WebElement onMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select onMonthSelection = new Select(onMonth);
        onMonthSelection.selectByValue("8");
        WebElement onDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select onDaySelection = new Select(onDay);
        onDaySelection.selectByValue("15");
        WebElement arrivingTo = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivingToSelection = new Select(arrivingTo);
        arrivingToSelection.selectByVisibleText("San Francisco");
        WebElement arrivingDate = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select arrivingDateSelection = new Select(arrivingDate);
        arrivingDateSelection.selectByValue("15");
        WebElement serviceClass = driver.findElement(By.xpath("//input[@value='First']"));
        serviceClass.click();
        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airLineSelection = new Select(airline);
        List<WebElement> allOptions = airLineSelection.getOptions();
        List<String> expectedOptions = Arrays.asList("No Preference","Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

        for (int i=0; i>expectedOptions.size(); i++) {
            Assert.assertEquals(allOptions.get(i).getText().trim(), expectedOptions.get(i).trim());
        }
        airLineSelection.selectByVisibleText("Unified Airlines");
        WebElement continueBttn = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueBttn.click();

        WebElement text = driver.findElement(By.xpath("(//font[@size='4'])[1]"));

        Assert.assertEquals(text.getText(),"After flight finder - No Seats Available");
    }

    @Test
    public void validateOrderMessageShortCut(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(" https://demo.guru99.com/test/newtours/reservation.php");
        WebElement tripType = driver.findElement(By.xpath("//input[@value='oneway']"));
        tripType.click();
        WebElement passenger = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passenger,"3","index");
        WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departFromselection = new Select(departingFrom);
        Assert.assertEquals(departFromselection.getFirstSelectedOption().getText().trim(), "Acapulco");
        departFromselection.selectByVisibleText("Paris");
        BrowserUtils.selectBy(departingFrom,"Paris","text");
        WebElement onMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(onMonth, "8","value");
        WebElement onDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(onDay,"15","value");
        WebElement arrivingTo = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(arrivingTo,"San Francisco","text");
        WebElement arrivingDate = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(arrivingDate,"15","value");
        WebElement serviceClass = driver.findElement(By.xpath("//input[@value='First']"));
        serviceClass.click();
        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airLineSelection = new Select(airline);
        List<WebElement> allOptions = airLineSelection.getOptions();
        List<String> expectedOptions = Arrays.asList("No Preference","Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

        for (int i=0; i>expectedOptions.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(allOptions.get(i)), expectedOptions.get(i).trim());
        }
        airLineSelection.selectByVisibleText("Unified Airlines");
        WebElement continueBttn = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueBttn.click();

        WebElement text = driver.findElement(By.xpath("(//font[@size='4'])[1]"));

        Assert.assertEquals(BrowserUtils.getText(text),"After flight finder - No Seats Available");
}


}
