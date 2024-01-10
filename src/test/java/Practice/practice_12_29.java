package Practice;

import Day_10_Shumon.ReusableMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class practice_12_29 {
    public static void main(String[] args) throws InterruptedException {
        //setup the chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare the chrome options
        ChromeOptions options = new ChromeOptions();
        //add some options for chromeoptions
        options.addArguments("start-maximized");
        //open in incognito mode
        options.addArguments("incognito");
        //define the webdriver and pass the options argument
        WebDriver driver = new ChromeDriver(options);
        //navigate to fidelis care site
        driver.navigate().to("https://www.fideliscare.org");
        Thread.sleep(3000);
        //click on shop for a plan
        driver.findElement(By.xpath("//*[text()='Shop For a Plan']")).click();
        //click on shop for a plan again inside the menu
        Thread.sleep(2000); //adding additional wait because we are getting element not interactable exception
        driver.findElements(By.xpath("//*[text()='Shop for a Plan']")).get(0).click();
        //click on find a doctor button
        driver.findElements(By.xpath("//*[@href='/Find-A-Doctor']")).get(0).click();
        Thread.sleep(1500);
        ReusableMethod.switchToTabByIndex(driver,1, "second tab");
        //enter a zipcode on search location field
        driver.findElement(By.xpath("//*[@id='searchLocation']")).sendKeys("11218");
        Thread.sleep(1500);
        //close this new tab
        driver.close();
       ReusableMethod.switchToTabByIndex(driver,0,"tab 1");
        //click on find a doctor link from the bottom
        driver.findElements(By.xpath("//*[@href='/Find-A-Doctor']")).get(1).click();
        //
        ReusableMethod.scroll(driver,0,1500);
        //quit the driver
        driver.quit();
    }//end of main
}
