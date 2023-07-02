package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FramePractice {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr");
        WebElement box = driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }

    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        WebElement pavilion = driver.findElement(By.xpath("//a[.='Pavilion']"));
        pavilion.click();
        BrowserUtils.switchByTitle(driver, "Home");
        Actions actions = new Actions(driver);
        WebElement seleniumMenu = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        actions.moveToElement(seleniumMenu).perform();
        WebElement seleniumPython = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Python']"));
        seleniumPython.click();
        WebElement header = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header),"Selenium-Python Tutorial");

        List<WebElement> allLinks = driver.findElements(By.xpath("//p//a"));
        for (WebElement link : allLinks){
            System.out.println(BrowserUtils.getText(link));
        }
        /*
TASK 1:
  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
  2-Click pavilion (new tab will be opened, consider switch window)
  3-Choose "Selenium-Phyton" from Selenium button (Action class is suggested)
  4-Validate the Header "Selenium-Python Tutorial"
  5-Print out(NO validation) all the links from website
  6-Wait for Second task
 */

        BrowserUtils.switchByTitle(driver,"iframes");
        Thread.sleep(1500);
        driver.switchTo().frame("Frame1");
        WebElement categoryOne = driver.findElement(By.linkText("Category1"));
        categoryOne.click();
        BrowserUtils.switchByTitle(driver,"SeleniumTesting");
        Thread.sleep(2000);
        WebElement header2 = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header2),"Category Archives: SeleniumTesting" );
        Thread.sleep(2000);
        List<WebElement> titlesAll = driver.findElements(By.xpath("//h3//a"));
        for (WebElement title : titlesAll){
            System.out.println(BrowserUtils.getText(title));
        }

        /*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)
 */

        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement text1 = driver.findElement(By.cssSelector("#frametext"));
        System.out.println(BrowserUtils.getText(text1));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement category3 = driver.findElement(By.linkText("Category3"));
        category3.click();
        BrowserUtils.switchByTitle(driver, "SoftwareTesting");
        WebElement header3 = driver.findElement(By.tagName("h1"));
        System.out.println(BrowserUtils.getText(header3));

        /*
TASK 3:
1-Go back mainPage
2-print out I am inside Frame under category1
3-Click Category3
4-Print out the header
 */
    }
}
