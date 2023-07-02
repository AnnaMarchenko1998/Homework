package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YouTubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");

        WebElement searchArea = driver.findElement(By.xpath("//input[@name='search_query']"));
        searchArea.sendKeys("Imagine Dragons");
        WebElement searchBttn = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        searchBttn.click();
        List<WebElement> songHeaders = driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement song : songHeaders){
            Thread.sleep(1500);
            song.sendKeys(Keys.ARROW_DOWN);
            if (song.getAttribute("title").equals("Imagine Dragons - Radioactive")){
                song.click();
                break;
            }
        }
        //Thread.sleep(2000);
        //song.sendKeys(Keys.ARROW_DOWN) --> put this inside the loop
    }
}
