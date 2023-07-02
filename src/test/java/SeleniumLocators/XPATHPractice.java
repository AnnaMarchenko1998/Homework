package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Anna");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("March");
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("marchecdjs@gmail.com");
        WebElement telephone = driver.findElement(By.xpath("//input[@name='telephone']"));
        telephone.sendKeys("7177895642");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("QWE123");
        WebElement passConf = driver.findElement(By.xpath("//input[@name='confirm']"));
        passConf.sendKeys("QWE123");
        WebElement agreementTerms = driver.findElement(By.xpath("//input[@name='agree']"));
        agreementTerms.click();
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();
       String header = driver.getTitle().trim();
        System.out.println(header.equals("Your Account Has Been Created!") ? "Correct header" : "Wrong header");
        WebElement continueBttn = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        continueBttn.click();
        System.out.println(driver.getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=account/account") ? "Correct URL!" : "Wrong URL");



    }
}
