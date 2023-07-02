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

public class HTMLandJSPractice {

    @Test
    public void practiceBoth() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://sweetalert.js.org/");

        WebElement jsPreviewBttn = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        jsPreviewBttn.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Oops, something went wrong!");
        System.out.println(alert.getText().trim());
        alert.accept();

        WebElement htmlPreviewBttn = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        htmlPreviewBttn.click();
        Thread.sleep(1500);
        WebElement message = driver.findElement(By.xpath("//div[@class='swal-modal']"));
        String actualMessage = BrowserUtils.getText(message);
        System.out.println(BrowserUtils.getText(message));
        String expectedMessage = "Something went wrong!";
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        WebElement ok = driver.findElement(By.xpath("//button[.='OK']"));

        ok.click();
        driver.quit();
    }
}
