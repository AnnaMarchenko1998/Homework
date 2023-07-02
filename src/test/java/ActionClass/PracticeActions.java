package ActionClass;

import Utils.BrowserUtils;
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

public class PracticeActions {

    @Test
    public void practiceDragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        WebElement droppableBox = driver.findElement(By.xpath("//div[@id='droppable']//p"));
        Assert.assertEquals(BrowserUtils.getText(droppableBox),"Drop here");
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable,droppableBox).perform();
        Thread.sleep(2000);
        droppableBox = driver.findElement(By.xpath("//div[@id='droppable']"));
        Assert.assertEquals(BrowserUtils.getText(droppableBox),"Dropped!");
        Thread.sleep(2000);
        String actualColorAfterAction = droppableBox.getCssValue("background-color");
        String expectedColorAfterAction = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColorAfterAction,expectedColorAfterAction );
    }

    @Test
    public void practiceClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        WebElement acceptBttn = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        acceptBttn.click();
        WebElement dropHereBox = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
        WebElement notAcceptedBox = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        Assert.assertEquals(BrowserUtils.getText(notAcceptedBox),"Not Acceptable");
        Assert.assertEquals(BrowserUtils.getText(dropHereBox),"Drop here");
        Actions actions = new Actions(driver);
        actions.clickAndHold(notAcceptedBox).moveToElement(dropHereBox).release().perform();
        Thread.sleep(2000);
        dropHereBox = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
        Assert.assertEquals(BrowserUtils.getText(dropHereBox),"Drop here");


    }
}
