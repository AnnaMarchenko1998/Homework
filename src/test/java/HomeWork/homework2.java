package HomeWork;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homework2 {

    /*
    Navigate to
"http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"
Validate the title is equals to "Web Orders Login"
Input username "Tester"
Input password "test"
Click login button
Validate the title is equals to "Web Orders"
Validate header is equals to "List of All Orders"
     */

    @Test
    public void task1() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
        WebElement username = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();
        Assert.assertEquals(driver.getTitle(), "Web Orders");
        WebElement header = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(BrowserUtils.getText(header), "List of All Orders");
    }


    /*
    Navigate to
"http://secure.smartbearsoftware.com/samples/TestCo
mplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "View all products" button
Validate "View all products" is selected
Validate header is equals to "List of Products"
Validate the url has "Products" keyword
     */

    @Test
    public void task2() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
        WebElement username = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();

        WebElement viewAllProductsBtn = driver.findElement(By.linkText("View all products"));
        viewAllProductsBtn.click();
        WebElement viewAllProductSelect = driver.findElement(By.cssSelector(".selected"));
        String atribute = viewAllProductSelect.getAttribute("class");

        Assert.assertEquals(atribute, "selected");

        WebElement header = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(BrowserUtils.getText(header), "List of Products");
        Assert.assertTrue(driver.getCurrentUrl().contains("Products"));
    }

    /*
    Navigate to
"http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Find the links for:
 -> View all orders
 -> View all products
 -> Orders
Validate their href values are equals to :
 -> "Default.aspx"
 -> "Products.aspx"
 -> "Process.aspx
     */
    @Test
    public void test3(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
        WebElement username = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();
        WebElement viewAllOrders = driver.findElement(By.linkText("View all orders"));
        String viewAllOrdersLink = viewAllOrders.getAttribute("href");
        WebElement viewAllProducts = driver.findElement(By.linkText("View all products"));
        String viewAllProductsLink = viewAllProducts.getAttribute("href");
        WebElement order = driver.findElement(By.linkText("Order"));
        String orderLink = order.getAttribute("href");

        //String a = viewAllOrders.getAttribute("href").trim();
        System.out.println(viewAllOrdersLink);
        System.out.println(viewAllProductsLink);
        System.out.println(orderLink);

        Assert.assertTrue(viewAllOrdersLink.contains("Default.aspx"), "Default.aspx");
        Assert.assertTrue(viewAllProductsLink.contains("Products.aspx"), "Products.aspx");
        Assert.assertTrue(orderLink.contains("Process.aspx"),"Process.aspx" );
    }


    /*
    Navigate to
"http://secure.smartbearsoftware.com/samples/TestComplete11
/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "Order" button
Select product "Screen Saver"
Input quantity 5
Input Customer name "CodeFish IT School"
Input Street "2200 E devon"
Input City "Des Plaines"
Input State "Illinois"
Input Zip "60018"
Select MasterCard
Input card number "444993876233"
Input expiration date "03/24"
Click Process button
Validate text "New order has been successfully added." is displayed below the Process button.
Click View all orders button
Validate new order is added and all inputs are matching with new order
     */

    @Test
    public void test4(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
        WebElement username = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();
        WebElement order = driver.findElement(By.linkText("Order"));
        order.click();
        WebElement products = driver.findElement(By.xpath("//select[@onchange='productsChanged()']"));
        Select product = new Select(products);
        product.selectByVisibleText("ScreenSaver");
        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys("5");
        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys("Illinois");
        WebElement zip = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zip.sendKeys("60018");
        WebElement card = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        card.click();
        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys("444993876233");
        WebElement expirationDate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expirationDate.sendKeys("03/24");
        WebElement process = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        process.click();
        WebElement message = driver.findElement(By.xpath("//strong"));
        Assert.assertEquals(BrowserUtils.getText(message),"New order has been successfully added.");
        WebElement viewAllOrders = driver.findElement(By.linkText("View all orders"));
        viewAllOrders.click();
        WebElement checkBoxCodefisf = driver.findElement(By.xpath("//td[.='CodeFish IT School']"));
        System.out.println(BrowserUtils.getText(checkBoxCodefisf));
        Assert.assertTrue(BrowserUtils.getText(checkBoxCodefisf).contains( "CodeFish IT School"));
    }
}
