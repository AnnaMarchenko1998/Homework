package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest1 {
    /*
    Navigate to "https://demoqa.com/text-box"
Enter your full name, email, current and permanent address
Click submit button.
Validate that all of your information is displayed and
matching correctly.
TIPS:Think about if conditions.
Example:
Name:John
Email: john@gmail.com
Current Address :Random Address
Permanent  Address : different address

     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        fullName.sendKeys("Anna March");
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
        email.sendKeys("a@gmail.com");
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        currentAddress.sendKeys("92 Aster dr, Schaumburg, Il 60173");
        WebElement permanentAdress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAdress.sendKeys("110 Columbia St, Chicago, IL 60126");
        WebElement submitBttn = driver.findElement(By.xpath("//button[@id='submit']"));
        submitBttn.click();

        WebElement name = driver.findElement(By.xpath("//p[@id='name']"));
        if (name.isDisplayed()){
            System.out.println(name.getText() + " --> Is Displayed and correct");
        }else{
            System.out.println("Name is NOT displayed");
        }

        WebElement emailChecker = driver.findElement(By.xpath("//p[@id='email']"));
        if (emailChecker.isDisplayed()){
            System.out.println(emailChecker.getText() + " --> Is Displayed and correct");
        }else {
            System.out.println("Email is NOT displayed");
        }

        WebElement currentAddressChecker = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        if (currentAddressChecker.isDisplayed()){
            System.out.println(currentAddressChecker.getText() + " --> Is Displayed and correct");
        }else{
            System.out.println("Current address is NOT displayed");
        }

        WebElement permanentAddressChecker = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        if (permanentAddressChecker.isDisplayed()){
            System.out.println(permanentAddressChecker.getText() + " --> Is Displayed and correct");
        }else{
            System.out.println("Permanent address is NOT displayed");
        }

    }
}
