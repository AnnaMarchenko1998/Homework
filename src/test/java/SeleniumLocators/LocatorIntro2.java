package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorIntro2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/anyam/Downloads/Techtorial.html");

        //LINKTEXT LOCATOR:
        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        Thread.sleep(2000);
        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        String actualHeader = javaHeader.getText().trim();
        String expectedHeader = "Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "Correct!" : "False!");
        driver.navigate().back();

        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        Thread.sleep(2000);
        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));
        String actualSeleniumHeader = seleniumHeader.getText().trim();
        String expectedSeleniumHeader = "Selenium automates browsers. That's it!";
        System.out.println(actualSeleniumHeader.equals(expectedSeleniumHeader) ? "Selenium header Correct!" : "Selenium header is wrong");
        driver.navigate().back();
        Thread.sleep(2000);

        WebElement cucumberLink = driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        Thread.sleep(2000);
        WebElement cucumberHeader = driver.findElement(By.tagName("h1"));
        String actualCucumberHeader = cucumberHeader.getText().trim();
        String expectedCucumberHeader = "Tools & techniques that elevate teams to greatness";
        System.out.println(actualCucumberHeader.equals(expectedCucumberHeader) ? "Cucumber header Correct!" : "Cucumber header is wrong");
        driver.navigate().back();
        Thread.sleep(2000);

        WebElement testNgLink = driver.findElement(By.linkText("TestNG"));
        testNgLink.click();
        Thread.sleep(2000);
        WebElement testNhHeader = driver.findElement(By.tagName("h2"));
        String actualTestNgHeader = testNhHeader.getText().trim();
        String expectedTestNgHeader = "TestNG";
        System.out.println(actualTestNgHeader.equals(expectedTestNgHeader) ? "TestNG header Correct!" : "TestNG header is wrong");
        driver.navigate().back();
        Thread.sleep(2000);

        System.out.println( driver.getCurrentUrl().equals("file:///C:/Users/anyam/Downloads/Techtorial.html") ? "CORRECT URL" : "WRONG URL");

        //LOCATOR PARTIALLINKTEXT

        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());



    }
}
