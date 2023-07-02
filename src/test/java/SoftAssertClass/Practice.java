package SoftAssertClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Practice {

    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement alertBox = driver.findElement(By.cssSelector("#alertBox"));
        alertBox.click();
        Alert alert = driver.switchTo().alert();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(alert.getText().trim(), "I am an alert box!");
        alert.accept();
        WebElement message = driver.findElement(By.cssSelector("#output"));

        softAssert.assertEquals(BrowserUtils.getText(message), "You selected alert popup");

        WebElement confirmBox = driver.findElement(By.cssSelector("#confirmBox"));
        confirmBox.click();

        softAssert.assertEquals(alert.getText().trim(), "Press a button!");

        alert.dismiss();

        softAssert.assertEquals(BrowserUtils.getText(message), "You pressed Cancel in confirmation popup");

        WebElement promptBox = driver.findElement(By.cssSelector("#promptBox"));
        Thread.sleep(2000);
        promptBox.click();
        alert.sendKeys("Homework is important");
        alert.accept();

        softAssert.assertEquals(BrowserUtils.getText(message), "You entered text Homework is important in propmt popup");
        softAssert.assertAll();
    }
}
