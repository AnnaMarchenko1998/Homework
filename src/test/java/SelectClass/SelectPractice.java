package SelectClass;

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
import java.util.List;

public class SelectPractice {

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/anyam/Downloads/Techtorial.html");
        WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        Select countries = new Select(country);
        Assert.assertEquals(countries.getFirstSelectedOption().getText().trim(), "UNITED STATES");
        //task 2 -> Print out all options

        int count = 0;
        List<WebElement> allCountries = countries.getOptions();
        for (int i=0; i< allCountries.size(); i++){
            System.out.println(allCountries.get(i).getText().trim());
            count++;
        }
        System.out.println("The total amount of countries is - " + count);

        //TASK 3 - 1 OWN country (by visible text); 2 - favorite cntry (by value); 3 - cntry for travel(index)
        Thread.sleep(2000);
       countries.selectByVisibleText("UKRAINE");
        Thread.sleep(2000);
        countries.selectByValue("17");
        Thread.sleep(2000);
        countries.selectByIndex(250);



    }
}
