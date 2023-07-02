package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.sound.midi.Soundbank;

public class SeleniumTask2 {
    /*
    Navigate to "https://www.saucedemo.com/"
Enter username "Java"
Enter password "Selenium"
Click Login button
Validate "Epic sadface: Username and password do not
match any user in this service" message
TIPS:to be able to see this message you need to first see this
message then try to inspect it. (it means at least run one time
with the username and password you provided above to see
the message then inspect the message.*be careful with it is
fully copied or not.
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("Java");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");
        WebElement loginBttn = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginBttn.click();
        WebElement wrongInfoNotification = driver.findElement(By.xpath("//h3[contains(text(),'sadface')]"));

        String expectedOutput = "Epic sadface: Username and password do not match any user in this service";
        System.out.println(wrongInfoNotification.getText().equals(expectedOutput) ? "CORRECT MESSAGE!" : "WRONG MESSAGE!");

    }
}
