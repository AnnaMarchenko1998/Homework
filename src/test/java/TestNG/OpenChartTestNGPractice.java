package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.jar.JarOutputStream;

public class OpenChartTestNGPractice {

    @Test
    public void successfulLogin() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        Thread.sleep(1500);
        Assert.assertEquals(driver.getTitle(),"Dashboard");
        driver.quit();

    }

    @Test
    public void negativeLogin(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("123");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        WebElement alertMessage =driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        String actualMessage = alertMessage.getText().trim();
        String expectedMessage = "No match for Username and/or Password.";
        Assert.assertEquals(actualMessage,expectedMessage);
        driver.quit();
    }

    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        Thread.sleep(1500);
        WebElement catalog = driver.findElement(By.xpath("//a[.=' Catalog']"));
        catalog.click();
        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(product.isDisplayed());
        Assert.assertTrue(product.isEnabled());
        Thread.sleep(1500);
        driver.quit();

    }

    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        Thread.sleep(1500);
        WebElement catalog = driver.findElement(By.xpath("//a[.=' Catalog']"));
        catalog.click();
        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i < checkBoxes.size(); i++){
            Thread.sleep(1500);
            Assert.assertTrue(checkBoxes.get(i).isDisplayed());
            Assert.assertTrue(checkBoxes.get(i).isEnabled());
            Assert.assertFalse(checkBoxes.get(i).isSelected());
                checkBoxes.get(i).click();
            Assert.assertTrue(checkBoxes.get(i).isSelected());
            checkBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }
        driver.quit();
    }



    @Test
    public void validateProductNameFunctionalityAscending() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        Thread.sleep(1500);
        WebElement catalog = driver.findElement(By.xpath("//a[.=' Catalog']"));
        catalog.click();
        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();

         /*
TEST CASE:

1-You will click the productName button
2-You should create 2 arraylist
  *-One of them will be actualData
  *-Another will be expectedData
3-For(int i=1)
  *store all the names for both of the list.Please use at the end .toUpperCase or toLowerCase
4-For expected List -->you will use Collections.sort(expectedList)
                    -->Collections.reverse(expected)
                    Assert.equals(actualList,expectedlist)
 */
//        WebElement productNameSortBttn = driver.findElement(By.xpath("//a[.='Product Name']"));
//        productNameSortBttn.click();
        List<WebElement> allProductNames = driver.findElements(By.xpath("//td[@class='text-start']"));

        List<String> actualProductOrder = new ArrayList<>();
        List<String> expectedProductOrder = new ArrayList<>();
        for (int i=1; i<allProductNames.size(); i++){
            actualProductOrder.add(allProductNames.get(i).getText().toLowerCase());
            expectedProductOrder.add(allProductNames.get(i).getText().toLowerCase());
        }
        Collections.sort(expectedProductOrder);
        System.out.println(actualProductOrder);
        System.out.println(expectedProductOrder);
        Assert.assertEquals(actualProductOrder,expectedProductOrder);
        driver.quit();
    }

    @Test
    public void validateDescendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        Thread.sleep(1500);
        WebElement catalog = driver.findElement(By.xpath("//a[.=' Catalog']"));
        catalog.click();
        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();
        WebElement productNameSortBttn = driver.findElement(By.xpath("//a[.='Product Name']"));
         productNameSortBttn.click();
        Thread.sleep(3000);
        List<WebElement> allProductNames = driver.findElements(By.xpath("//td[@class='text-start']"));

        List<String> actualProductOrder = new ArrayList<>();
        List<String> expectedProductOrder = new ArrayList<>();

        for (int i=1; i<allProductNames.size(); i++){
            actualProductOrder.add(allProductNames.get(i).getText().toLowerCase());
            expectedProductOrder.add(allProductNames.get(i).getText().toLowerCase());
        }
        Collections.sort(expectedProductOrder);
        Collections.reverse(expectedProductOrder);
        System.out.println(actualProductOrder);
        System.out.println(expectedProductOrder);
        Assert.assertEquals(actualProductOrder,expectedProductOrder);
        driver.quit();
    }
}

