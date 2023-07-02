package HomeWork;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindowPersonalPractice {

    @Test
    public void practiceSwitchWindow(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement openNewTab = driver.findElement(By.cssSelector("#newTabBtn"));
        BrowserUtils.scrollWithJS(driver,openNewTab);
        openNewTab.click();
        String mainPageID  = driver.getWindowHandle();
        Set<String> allPagedID = driver.getWindowHandles();
        for (String id : allPagedID){
            if (!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }

        Assert.assertEquals(driver.getTitle(), "AlertsDemo - H Y R Tutorials");

        WebElement header = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        Assert.assertEquals(BrowserUtils.getText(header), "AlertsDemo");

        WebElement alertBoxBttn = driver.findElement(By.cssSelector("#alertBox"));
        alertBoxBttn.click();


    }
}
