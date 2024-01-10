package Day_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_GoogelSearchTest {

    public static void main(String[] args) throws InterruptedException {
            //setup the chromedriver with webdrivermanager
            WebDriverManager.chromedriver().setup();
            //define the webdriver
            WebDriver driver = new ChromeDriver();
            //navigate to google web page
            driver.navigate().to("https://www.google.com");
            //maximize the window
            driver.manage().window().maximize();
            //search for cars (using relative xpath)
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
            //hit submit on google search button
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            //wait for 3 seconds
            Thread.sleep(3000);
            //store the results in a string variable
            String searchResult = driver.findElement(By.xpath("//*[@id = 'result-stats']")).getText();
            //Print out the result to console
            System.out.println("Search result is " + searchResult);
            //split result using split command
            String[] searchResultArray = searchResult.split(" ");
            //print out only the search result number
            System.out.println("Search Result Number is " + searchResultArray[1]);

            //quit the browser
            driver.quit();
        }//end of main

    }

