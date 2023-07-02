package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHLocator {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        //RELATIVE XPATH
        WebElement abTest = driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]"));
        abTest.click();
        //ABSOLUTE XPATH
        WebElement header = driver.findElement(By.xpath("html/body/div[2]/div/div/h3"));
        System.out.println(header.getText());

        WebElement paragraph1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(paragraph1.getText());
        WebElement paragraph = driver.findElement(By.xpath("//p[contains(text(),'Also known')]"));
        System.out.println(paragraph.getText());
        WebElement element = driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        element.click();

    }
}
