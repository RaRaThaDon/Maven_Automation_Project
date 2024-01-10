package Day_10_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class practice {
    public static void main(String[] args) {
        //setup the chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare the chrome options
        ChromeOptions options = new ChromeOptions();
        //add some options for chromeoptions
        options.addArguments("start-maximized");
        //open in incognito mode
        options.addArguments("incognito");
        //run in headless mode (runs in the background)
//        options.addArguments("headless");
        //define the webdriver and pass the options argument
        WebDriver driver = new ChromeDriver(options);
        //navigate to equinox
        driver.navigate().to("https://www.equinox.com");
        //capture size number of nav bar options
        ArrayList <WebElement> EquinoxHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'GlobalHeader_main-nav-item__evs91')]")));
        System.out.println(EquinoxHeaders.size());
        // get title
        driver.findElement(By.xpath("//*[@title='Get Started']")).click();

    }
}
