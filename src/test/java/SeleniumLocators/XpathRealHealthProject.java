package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathRealHealthProject {
    public static void main(String[] args) {

        /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/          -->DONE
2-Click Make an Appointment                                         -->DONE
3-Login the username and password provided and Login successfully   -->DONE
4-Choose the facility either HongKong or Seoul -->send keys         -->DONE
5-Click apply for hospital admission box if it is displayed and validate it is selected -->DONE
6-Healthcare program 'Medicaid'                                     -->DONE
7-Visit date should be provided -->send keys                        -->DONE
8-Put your comment for this box -->send keys                        -->DONE
9-Book your appointment                                             -->DONE
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement) -->DONE
11-Print out the headers and values(only values) on your console.   -->DONE
12)Click go to homepage and print out url                           -->DONE
13)Driver.quit or close.                                            -->DONE

           */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        // WebElement appButton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        //appButton.click();

       //CSS WITH ID

       WebElement appButtonCss = driver.findElement(By.cssSelector("#btn-make-appointment"));
       appButtonCss.click();

        WebElement username = driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement loginBttn = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginBttn.click();
        WebElement facility = driver.findElement(By.xpath("//select[@name='facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");
        WebElement hospReadmBox = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        if(hospReadmBox.isDisplayed() && !hospReadmBox.isSelected()){
            hospReadmBox.click();
            System.out.println("Hospital Readmission is selected");
        } else if (hospReadmBox.isDisplayed() && hospReadmBox.isSelected()) {
            System.out.println("Hospital Readmission is selected");
        } else{
            System.out.println("Hospital Readmission is NOT selected");
        }
        WebElement medicaid = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        medicaid.click();
        WebElement date = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("02/10/2022");
        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("I want to make appointment");

        //WebElement bookApptButtn = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        //bookApptButtn.click();

        //CSS WITH CLASS

        WebElement bookApptBttnCSS = driver.findElement(By.cssSelector(".btn-default"));
        bookApptBttnCSS.click();

        WebElement appConfText = driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
        if (appConfText.getText().equals("Appointment Confirmation")){
            System.out.println("The header is - Appointment Confirmation");
        }
        WebElement facilityText = driver.findElement(By.xpath("//p[contains(text(),'Hongkong')]"));
        System.out.println(facilityText.getText());
        WebElement applForHospText = driver.findElement(By.xpath("//p[contains(text(),'Yes')]"));
        System.out.println(applForHospText.getText());
        WebElement healthProgrText = driver.findElement(By.xpath("//p[contains(text(),'Medicaid')]"));
        System.out.println(healthProgrText.getText());
        WebElement visitDateText = driver.findElement(By.xpath("//p[.='02/10/2022']"));
        System.out.println(visitDateText.getText());
        WebElement commentText = driver.findElement(By.xpath("//p[.='I want to make appointment']"));
        System.out.println(commentText.getText());
        WebElement goToHomeButtn = driver.findElement(By.xpath("//a[.='Go to Homepage']"));
        goToHomeButtn.click();
        System.out.println(driver.getCurrentUrl());
        driver.close();




    }
}
