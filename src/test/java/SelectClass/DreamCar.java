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

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */

    @Test
    public void headersOfTheCars() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");

        Thread.sleep(1500);
        WebElement newUsed = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(newUsed,"new","value");
        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make,"Lexus","text");
        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model,"RX 350","text");
        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select priceSelection = new Select(price);
        Assert.assertEquals(BrowserUtils.getText(priceSelection.getFirstSelectedOption()),"No max price");
        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"40","value");
        WebElement zipcode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipcode.clear();
        zipcode.sendKeys("60056");
        WebElement searchBttn = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        searchBttn.click();
        WebElement header = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(BrowserUtils.getText(header),"New Lexus RX 350 for sale" );
        Thread.sleep(2000);
        WebElement sort = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        BrowserUtils.selectBy(sort,"Lowest price","text");
        List<WebElement> titles = driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement title : titles){
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
        }

        Thread.sleep(1500);
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='primary-price']"));
        List<Integer> actualPrices = new ArrayList<>();
        List<Integer> expectedPrices = new ArrayList<>();

        for (int i=0; i<prices.size(); i++){

            String number = BrowserUtils.getText(prices.get(i)).replace("$","").replace(",","");
            actualPrices.add(Integer.parseInt(number));
            expectedPrices.add(Integer.parseInt(number));
        }
        Collections.sort(expectedPrices);
        Assert.assertEquals(actualPrices,expectedPrices);



    }
}
