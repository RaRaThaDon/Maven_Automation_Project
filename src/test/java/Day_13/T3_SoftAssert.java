package Day_13;

import Day_10_Shumon.ReusableMethod;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class T3_SoftAssert extends Testparent{
    @Test(priority = 1)
    public void tc001_verifyGoogleTitle() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //store the title of google page
        String actualTitle = driver.getTitle();
        //store the expected title
        String expectedTitle = "Google";
        SoftAssert softie = new SoftAssert();
        softie.assertEquals(actualTitle, expectedTitle);
        softie.assertAll();
    }//end of test case 1
    @Test(priority = 2)
    public void tc002_searchForACar() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //search for BMW
        ReusableMethod.sendKeysMethod(driver, "//*[@name= 'q']", "BMW", "SearchField");
        //hit submit on the google search button
        ReusableMethod.submitMethod(driver, "//*[@name= 'btnK']", "Submit");
        Thread.sleep(1000);

    }//end of test case 1
    @Test(priority = 3)
    public void tc003_captureSearchResult() {
        //store the search result into a string variable
        String result = ReusableMethod.captureText(driver, "//*[@id = 'result-stats']", "SearchResult");
        //split the result
        String[] searchResultArray = result.split(" ");
        //print out the number only
        System.out.println("Search Result Number is " + searchResultArray[1]);
        String actualSearchNumber = searchResultArray[1];
        String expectedSearchNumber = "1,450,000,000";
        SoftAssert softie = new SoftAssert();
        softie.assertEquals(actualSearchNumber, expectedSearchNumber);
        softie.assertAll();
    }//end of test case 3
}
