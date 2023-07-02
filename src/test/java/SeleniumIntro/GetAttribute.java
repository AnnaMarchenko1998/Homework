package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement appButtonCss = driver.findElement(By.cssSelector("#btn-make-appointment"));
        appButtonCss.click();
        WebElement johnDoe = driver.findElement(By.xpath("//input[@value='John Doe']"));
        System.out.println(johnDoe.getAttribute("value")); // John Doe
        System.out.println(johnDoe.getAttribute("type")); // text

    }
}
