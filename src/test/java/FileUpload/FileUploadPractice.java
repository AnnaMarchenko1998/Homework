package FileUpload;

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

public class FileUploadPractice {

    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("C:\\Users\\anyam\\Desktop\\usa.png");
        WebElement uploadBttn = driver.findElement(By.cssSelector(".button"));
        uploadBttn.submit();
        WebElement text = driver.findElement(By.cssSelector("#uploaded-files"));
        Assert.assertEquals(BrowserUtils.getText(text),"usa.png");
    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");

        WebElement chooseFile = driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFile.sendKeys("C:\\Users\\anyam\\Desktop\\usa.png");
        WebElement text = driver.findElement(By.xpath("//b[contains(text(),'Select file')]"));
        Assert.assertEquals(BrowserUtils.getText(text), "Select file to send(max 196.45 MB)");
        WebElement checkBoxTermOfUse = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if (!checkBoxTermOfUse.isSelected() && checkBoxTermOfUse.isDisplayed() && checkBoxTermOfUse.isEnabled()){
            checkBoxTermOfUse.click();
        }
        WebElement submitBttn = driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitBttn.click();
        Thread.sleep(2000);

        WebElement message = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals(BrowserUtils.getText(message),"1 file\n" +
                "has been successfully uploaded. ");
    }
}
