package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class AI_WeightWatchers {
    public static void main(String[] args) throws InterruptedException {
        //declare an array list variable
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("06108");
        zipCode.add("11215");
        for (int i = 0; i < zipCode.size(); i++) {
            //setup the chromedriver with web driver manager
            WebDriverManager.chromedriver().setup();
            //declare the chrome options
            ChromeOptions options = new ChromeOptions();
            //add some options for chrome options
            options.addArguments("start-maximized");
            //open in incognito mode
            options.addArguments("incognito");
            //define the web driver and pass the options argument
            WebDriver driver = new ChromeDriver(options);
            //navigate to Weight watchers
            driver.navigate().to("https://www.weightwatchers.com/");
            //wait 2 seconds
            Thread.sleep(2000);
            //store the home value in web element variable
            WebElement Workshop = driver.findElement(By.xpath("//*[text()='Find a Workshop']"));
            //click find a workshop
            Workshop.click();
            //create web element for in person
            WebElement inPerson = driver.findElement(By.xpath("//*[text()='In-Person']"));
            //click on in person
            inPerson.click();
            //make search a web element
            WebElement search = driver.findElement(By.xpath("//*[@id= 'location-search']"));
            //clear search box
            search.clear();
            //then put in a zipcode
            search.sendKeys(zipCode.get(i));
            //then hit the arrow to search
            driver.findElement(By.xpath("//*[contains(@class,'rightArrow-')]")).submit();
            //sleep
            Thread.sleep(2000);
            //define an arraylist of web elements
            ArrayList<WebElement> studio = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'linkUnderline')]")));
            //create if condition
            if (i == 0) {
                studio.get(1).click();
            } else if (i == 1) {
                studio.get(2).click();
            } else if (i == 2) {
                studio.get(0).click();

            }//end of condition
            //sleep
            Thread.sleep(2000);
            //define address web element
            WebElement address = driver.findElement(By.xpath("//*[@class ='address-2PZwW']"));
            // print address
            System.out.println(address.getText());
            //sleep
            Thread.sleep(2000);
            //define in person workshops web element
            WebElement inPersonWorkshops = driver.findElement(By.xpath("//*[@class ='title-bEfSM']"));
            //add the java driver
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //now scroll to the workshops
            jse.executeScript("arguments[0].scrollIntoView(true);",inPersonWorkshops);
            //now get entire schedule
            WebElement schedule = driver.findElement(By.xpath("//*[contains(@class,'scheduleContainer')]"));
            //print schedule
            System.out.println(schedule.getText());
            //quit driver
            driver.quit();
        }//end of loop
    }//end of main
}//end of class


