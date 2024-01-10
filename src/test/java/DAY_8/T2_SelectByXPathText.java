package DAY_8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T2_SelectByXPathText {
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

        //navigate to mortgage calculator site
        driver.navigate().to("https://www.mortgagecalculator.org");
        //wait a few seconds to load
        Thread.sleep(3000);
        //
        WebElement homeVal = driver.findElement(By.xpath("//*[@id='homeval']"));
        homeVal.clear();
        homeVal.sendKeys("450000");
        //clear and enter the down payment
        WebElement dPayment = driver.findElement(By.xpath("//*[@id='downpayment']"));
        dPayment.clear();
        dPayment.sendKeys("9000");
        Thread.sleep(3000);
        //click on drop down
       driver.findElement(By.xpath("//*[@name='param[start_month]']")).click();
        //click by xpath visible text for january
        driver.findElement(By.xpath("//*[text()='Jan']"));
        Thread.sleep(1000);
        //verify that it selects back the Dec which is the default month
        driver.findElement(By.xpath("//*[text()='Dec']"));

        Thread.sleep(4000);
        driver.quit();

    }
}
