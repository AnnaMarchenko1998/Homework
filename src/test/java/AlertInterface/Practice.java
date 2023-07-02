package AlertInterface;

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

import java.time.Duration;

public class Practice {

    @Test
    public void practiceJSAlert() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement popupBox = driver.findElement(By.xpath("//b[.='Popup box output']"));
        BrowserUtils.scrollWithJS(driver,popupBox);

        WebElement alertBoxClick = driver.findElement(By.xpath("//button[contains(@onclick,'alertFunction()')]"));
        alertBoxClick.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String actualText1 = alert.getText();
        Assert.assertEquals(actualText1,"I am an alert box!");
        alert.accept();
        WebElement message1 = driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowserUtils.getText(message1), "You selected alert popup");

        WebElement confirmBoxClick = driver.findElement(By.xpath("//button[contains(@onclick,'confirmFunction()')]"));
        confirmBoxClick.click();
        String actualText2 = alert.getText();
        Assert.assertEquals(actualText2,"Press a button!");
        alert.dismiss();
        WebElement message2 = driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowserUtils.getText(message2), "You pressed Cancel in confirmation popup");

        WebElement promptBoxClick = driver.findElement(By.cssSelector("#promptBox"));
        Thread.sleep(2000);
        promptBoxClick.click();
        alert.sendKeys("Anna");
        alert.accept();
        WebElement message3 = driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowserUtils.getText(message3), "You entered text Anna in prompt popup");
    }
}
