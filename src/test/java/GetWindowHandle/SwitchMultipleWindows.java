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

public class SwitchMultipleWindows {

    @Test
    public void practiceMultipleWindows(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");

        BrowserUtils.switchByTitle(driver, "Contact");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        BrowserUtils.switchByTitle(driver, "Kickstart ");
        System.out.println(driver.getTitle());
        BrowserUtils.switchByTitle(driver, "Courses");
        System.out.println(driver.getTitle());
    }


    @Test
    public void realTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement multipleTabsBttn = driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.scrollWithJS(driver,multipleTabsBttn);
        multipleTabsBttn.click();
        BrowserUtils.switchByTitle(driver, "Basic Controls");
        WebElement scrollDownLocation = driver.findElement(By.xpath("//h2[.='Recent Tutorials']"));
        BrowserUtils.scrollWithJS(driver, scrollDownLocation);
        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Anna");
        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("March");
        WebElement gender = driver.findElement(By.cssSelector("#femalerb"));
        gender.click();
        WebElement language = driver.findElement(By.id("englishchbx"));
        language.click();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("am@gmail.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("1234");
        WebElement registerBttn = driver.findElement(By.cssSelector("#registerbtn"));
        BrowserUtils.scrollWithJS(driver, scrollDownLocation);
        registerBttn.click();
        WebElement message = driver.findElement(By.xpath("//label[@id='msg']"));

        Assert.assertEquals(BrowserUtils.getText(message), "Registration is Successful");

        BrowserUtils.switchByTitle(driver, "Window");
        WebElement header = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        Assert.assertEquals(BrowserUtils.getText(header), "Window Handles Practice");

        BrowserUtils.switchByTitle(driver, "AlertsDemo");
        WebElement promptBox = driver.findElement(By.cssSelector("#promptBox"));
        promptBox.click();
        driver.quit();



                       /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */
    }
}

