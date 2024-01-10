package Day_10_Shumon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ReusableMethod {
    //create a click method to click on any web element
    public static void clickMethod(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
        }catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + e);
        }
    }//end of click method
    //create a submit method to submit on any web element
    public static void submitMethod(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
        }catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + e);
        }
    }//end of submit method

    //return method
    public static String captureText (WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
        } catch (Exception e) {
            System.out.println("Unable to get text " + ":" + e);
        }
        return result;
    }//end of capture text method

    public static WebDriver setUpDriver () {
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

        return driver;
    }//end of driver method

    //create a click method to click on any web element by index
    public static void clickByIndexMethod(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
        }
    }//end of click method

    //create a send keys method
    public static void sendKeysMethod(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
        }
    }//end of sendkeys method

    //create method for scroll into view
public static void scrollMethod (WebDriver driver, String xpath, String elementName) {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    try {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement scroll = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        jse.executeScript("arguments[0].scrollIntoView(true);", scroll);
    } catch (Exception e) {
        System.out.println("Unable to click on element " + elementName + ":" + e);
    }
}//end of scroll method

    //create a select by visible text method
    public static void selectByVisibleTextMethod(WebDriver driver,String xpath, String visibleText, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select select = new Select(element);
            select.selectByVisibleText(visibleText);

        }catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + e);
        }
    }//end of select by visible text method

    //create a submit method to submit on any web element
    public static void clearMethod(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).clear();
        }catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + e);
        }
    }//end of clear method

    //switch to tab by index reusable method
    public static void switchToTabByIndex(WebDriver driver, int tabIndex, String tabName){
          WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabIndex));
        }catch (Exception e) {
            System.out.println("Unable to switch tabs" + tabName + e);
        }
    }//end of switch tabs by index method

    //scroll by pixel method
//    public static void scrollByPixelMethod (WebDriver driver, int xPixels, int yPixels) {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        try {
//            JavascriptExecutor jse = (JavascriptExecutor) driver;
//            jse.executeScript("scroll(""  + "yPixels" )");
//        } catch (Exception e) {
//            System.out.println("Unable to scroll by pixels " + ":" + e);
//        }
//    }//end of scroll by pixel method

    //scroll by pixel method that works
    public static void scroll(WebDriver driver, int xPixels, int yPixels) {
        String script = String.format("scroll(%d,%d)", xPixels, yPixels);
        ((JavascriptExecutor) driver).executeScript(script);
    }// end of scroll by pixel method that works

    public static void mouseActionsClickMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            mouseAction.moveToElement(quickTool).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
        }
    }//end of mouse actions click method
}//end of class


