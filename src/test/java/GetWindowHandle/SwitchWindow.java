package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchPractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
        WebElement multipleWindowsLink = driver.findElement(By.xpath("//a[.='Multiple Windows']"));
        multipleWindowsLink.click();
        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        System.out.println(driver.getWindowHandle()); //main pageID --> The internet
        Set<String> allPagesId = driver.getWindowHandles(); //70C9C371514C58560E2CDBE78CDF3FAB  --> mainPageID
        String mainPageID = driver.getWindowHandle();
        for(String id : allPagesId){
            if (!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }


    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement buttonTwo = driver.findElement(By.cssSelector("#newTabBtn"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",buttonTwo);
        buttonTwo.click();

        String mainPageId = driver.getWindowHandle();
        Set<String> allPages = driver.getWindowHandles();
        for (String id: allPages){
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }

        Assert.assertEquals(driver.getTitle(), "AlertsDemo - H Y R Tutorials");

        WebElement header = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        Assert.assertEquals(BrowserUtils.getText(header), "AlertsDemo");

        WebElement confirmBoxBttn = driver.findElement(By.cssSelector("#confirmBox"));
        confirmBoxBttn.click();
    }


}
