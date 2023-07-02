package ActionClass;

import Utils.BrowserUtils;
import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDrop {

    @Test
    public void dragAndDrop() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Actions actions = new Actions(driver);
        actions.scrollByAmount(200, 200).perform();
        WebElement orangeBoxMessage = driver.findElement(By.xpath("//div[@class='test2']"));
        Assert.assertEquals(BrowserUtils.getText(orangeBoxMessage), "... Or here.");
        String actualBackgroundColor = orangeBoxMessage.getCssValue("background-color");
        String expectedBackgroundColor = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualBackgroundColor, expectedBackgroundColor);
        WebElement blueCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
        Thread.sleep(2000);
        actions.dragAndDrop(blueCircle, orangeBoxMessage).perform();
        Thread.sleep(2000);
        orangeBoxMessage = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualNewText = orangeBoxMessage.getText();
        Assert.assertEquals(actualNewText, "You did great!");


    }

    @Test
    public void DragAndDropPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Actions actions = new Actions(driver);
        actions.scrollByAmount(200, 200).perform();
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessage = BrowserUtils.getText(blueBox);
        String expectedMessage = "Drag the small circle here ...";
        Assert.assertEquals(actualMessage,expectedMessage);
        String actualColor = blueBox.getCssValue("background-color").trim();
        String expectedColor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColor, expectedColor);
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Thread.sleep(2000);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();
        Thread.sleep(2000);
        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualAfterAction = BrowserUtils.getText(blueBox);
        String expectedAfterAction = "You did great!";
        Assert.assertEquals(actualAfterAction, expectedAfterAction);

    }


}
