package Day_14_YahooBoolean;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Reusable_Method_Loggers {
    //create a click method to click on any web element
    public static void clickMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS,"Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL,"unable to click on " + elementName);
            //attach screenshot if send keys fails
            getScreenShot(driver,elementName,logger);
        }
    }//end of click method

        //create a click method to click on any web element using visibility
        public static void clickMethodV(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
                logger.log(LogStatus.PASS,"Successfully clicked on " + elementName);
            } catch (Exception e) {
                System.out.println("Unable to click on element " + elementName + ":" + e);
                logger.log(LogStatus.FAIL,"unable to click on " + elementName);
            }
        }//end of click method
    //create a submit method to submit on any web element
    public static void submitMethod(WebDriver driver,String xpath,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            logger.log(LogStatus.PASS,"Successfully submitted " + elementName);
        }catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + e);
            logger.log(LogStatus.FAIL,"unable to submit " + elementName);
            //attach screenshot if send keys fails
            getScreenShot(driver,elementName,logger);
        }
    }//end of submit method

    //return method
    public static String captureText (WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
            logger.log(LogStatus.PASS,"Successfully captured " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text " + ":" + e);
            logger.log(LogStatus.FAIL,"unable to capture " + elementName);
        }
        return result;
    }//end of capture text method

    public static String captureTextV (WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText();
            logger.log(LogStatus.PASS,"Successfully captured " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text " + ":" + e);
            logger.log(LogStatus.FAIL,"unable to capture " + elementName);
        }
        return result;
    }//end of capture text method
    //create a click method to click on any web element by index
    public static void clickByIndexMethod(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            logger.log(LogStatus.PASS,"Successfully used click by index for " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL,"unable to use click by index for " + elementName);
        }
    }//end of click method

    //create a send keys method
    public static void sendKeysMethod(WebDriver driver, String xpath, String userValue, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully used send keys for " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL,"unable to use send keys for " + elementName);
            //attach screenshot if send keys fails
            getScreenShot(driver,elementName,logger);
        }
    }//end of sendkeys method

    public static void sendKeysByIndexMethod(WebDriver driver, String xpath, String userValue, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully used send keys for " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL,"unable to use send keys for " + elementName);
        }
    }//end of sendkeys method
//
    //create method for scroll into view
    public static void scrollMethod (WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement scroll = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true);", scroll);
            logger.log(LogStatus.PASS,"Successfully used scroll into view for " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL,"unable to use scroll into view for " + elementName);
        }
    }//end of scroll method
    public static void selectByVisibleTextMethod(WebDriver driver,String xpath, String visibleText, ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select select = new Select(element);
            select.selectByVisibleText(visibleText);
            logger.log(LogStatus.PASS,"Successfully selected by visible text for " + elementName);
        }catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + e);
            logger.log(LogStatus.FAIL,"unable to select by visible text for " + elementName);
        }
    }//end of select by visible text method

    //create a submit method to submit on any web element
    public static void clearMethod(WebDriver driver,String xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).clear();
            logger.log(LogStatus.PASS,"Successfully cleared " + elementName);
        }catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + e);
            logger.log(LogStatus.FAIL,"unable to clear for " + elementName);
        }
    }//end of clear method

    //switch to tab by index reusable method
    public static void switchToTabByIndex(WebDriver driver, int tabIndex, ExtentTest logger,String tabName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabIndex));
            logger.log(LogStatus.PASS,"Successfully switched to " + tabName);
        }catch (Exception e) {
            System.out.println("Unable to switch tabs" + tabName + e);
            logger.log(LogStatus.FAIL,"Unable to switch to " + tabName);
        }
    }//end of switch tabs by index method
    public static void mouseActionsClickMethod(WebDriver driver, String xpath, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            mouseAction.moveToElement(quickTool).click().perform();
            logger.log(LogStatus.PASS,"Successfully used mouse action to click" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
            logger.log(LogStatus.FAIL,"Unable to click " + elementName);
        }
    }//end of mouse actions click method
    public static void mouseActionsClickbyIndexMethod(WebDriver driver, String xpath, int index, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            mouseAction.moveToElement(quickTool).click().perform();
            logger.log(LogStatus.PASS,"Successfully used mouse action to click" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
            logger.log(LogStatus.FAIL,"Unable to click " + elementName);
        }
    }//end of mouse actions click method
    public static void selectByindexVisibleTextMethod(WebDriver driver,String xpath, String visibleText, int index, ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select select = new Select(element);
            select.selectByVisibleText(visibleText);
            logger.log(LogStatus.PASS,"Successfully selected by visible text for " + elementName);
        }catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + e);
            logger.log(LogStatus.FAIL,"unable to select by visible text for " + elementName);
        }
    }//end of select by visible text method

    public static void selectByVisibleTextMethodV(WebDriver driver,String xpath, String visibleText, ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Select select = new Select(element);
            select.selectByVisibleText(visibleText);
            logger.log(LogStatus.PASS,"Successfully selected by visible text for " + elementName);
        }catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + e);
            logger.log(LogStatus.FAIL,"unable to select by visible text for " + elementName);
        }
    }//end of select by visible text method
    //jse click
    public static void clickElementWithJs(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jsExecutor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to click element using JavascriptExecutor");
        }
    }//end of jse clikc
    //move by offset
    public static void moveByOffsetX(WebDriver driver, String xpath,int target, int yOffset,ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            WebElement sliderHandle = driver.findElement(By.xpath(xpath));
            // Calculate the target offset (adjust this value based on your requirements)
            int targetOffset = target;
            // Use the Actions class to perform the drag-and-drop operation
            Actions builder = new Actions(driver);
            // Click and hold on the slider handle
            builder.clickAndHold(sliderHandle).perform();
            // Move the slider handle to the desired location
            builder.moveByOffset(targetOffset, 0).perform();
            // Release the slider handle
            builder.release().perform();
            // Pause for a moment (you may adjust this based on your needs)
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        }catch(Exception e){
            System.out.println("Unable to move " + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
        }
    }//end of move by offset
    public static void isConditionTrue(boolean bool, ExtentTest logger){
        if(bool == true) {
            logger.log(LogStatus.PASS, "Boolean Condition is " + bool);
        }else {
            logger.log(LogStatus.FAIL, "Boolean Condition is " + bool);
        }
    }//end of isConditionTrue method

    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error occurred while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method




//    public static void captureHrefAndClick(WebDriver driver, String xpath, int Index, String elementName,ExtentTest logger) {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        try {
//            WebElement newMailingLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
//            String hrefAttributeValue = newMailingLink.getAttribute("href");
//            System.out.println("Href Attribute Value: " + hrefAttributeValue);
//            openNewTab(driver);
//            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//            driver.switchTo().window(tabs.get(Index));
//            driver.get(hrefAttributeValue);
//            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
//        } catch (Exception e) {
//            System.out.println("Unable to capture href and Open tab" + elementName);
//            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
//        }
//    }
//    public static void openNewTab(WebDriver driver) {
//        // Execute JavaScript to open a new tab
//        ((JavascriptExecutor) driver).executeScript("window.open();");
//    }
}
