package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementPractice {


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");

        //TASK 1
        //Print out each element and count it
        List<WebElement> allElements = driver.findElements(By.xpath("//li"));
        int n = 0;
        for (WebElement element : allElements){
            System.out.println(element.getText());
            n++;
        }
        System.out.println(n);
        System.out.println(allElements.size());

        //TASK 2
        //Print it if the length is equal or more than 12, and count

        int count2 = 0;
        for (WebElement element : allElements){
            if (element.getText().length() >= 12){
                System.out.println(element.getText());
                count2++;}
        }
        System.out.println(count2);




    }
}
