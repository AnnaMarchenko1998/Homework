package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CSSLocator {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");

        WebElement searchArea = driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        searchArea.sendKeys("watch");
        WebElement searchBttn = driver.findElement(By.cssSelector(".wt-nudge-r-1"));
        searchBttn.click();
        System.out.println(driver.getCurrentUrl().equals("https://www.etsy.com/search?q=watch&ref=search_bar") ? "Correct URL!" : "Wrong URL!");
        driver.quit();


    }
}
