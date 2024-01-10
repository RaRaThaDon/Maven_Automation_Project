package Day_10_Shumon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class T1_MouseActions {
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
        //navigate to usps site
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(3000);
        //declare mouse actions
        Actions mouseAction = new Actions(driver);
        //hover to quick tools module
        WebElement quickTool = driver.findElement(By.xpath("//*[text()='Quick Tools']"));
        mouseAction.moveToElement(quickTool).perform();
        //clikc on track package using a mouse cloic
        WebElement tracPackage = driver.findElement(By.xpath("//*[text()='Track a Package']"));
        mouseAction.moveToElement(tracPackage).click().perform();
        //type in invalid tracking number on tracking field
        Thread.sleep(3000);
        WebElement searchField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        mouseAction.moveToElement(searchField).click().sendKeys("101231231241").perform();

    }//end of main
}//end of class
