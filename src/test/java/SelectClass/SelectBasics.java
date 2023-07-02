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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectBasics {

    @Test
    public void selectMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/");
        WebElement dropdown = driver.findElement(By.linkText("Dropdown"));
        dropdown.click();
        WebElement dropdownOptions = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select optionsBox = new Select(dropdownOptions);// It means I will choose an option from THAT BOX

        String actualDefaultOption = optionsBox.getFirstSelectedOption().getText().trim();
        String expectedDefaultOption = "Please select an option";
        Assert.assertEquals(actualDefaultOption,expectedDefaultOption);

        optionsBox.selectByVisibleText("Option 2");
        Thread.sleep(2000);
        optionsBox.selectByValue("1");
        Thread.sleep(2000);
        optionsBox.selectByIndex(2);
        Thread.sleep(2000);
        List<WebElement> actualOptions =  optionsBox.getOptions();
        List<String> expectedOptions = Arrays.asList("Please select an option","Option 1", "Option 2");

        for (int i = 0; i <actualOptions.size(); i++){
            Assert.assertEquals(actualOptions.get(i).getText().trim(),expectedOptions.get(i).trim());
        }


        driver.quit();
    }
}
