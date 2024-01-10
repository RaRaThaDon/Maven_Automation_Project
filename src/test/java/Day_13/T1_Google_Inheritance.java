package Day_13;

import Day_10_Shumon.ReusableMethod;
import org.testng.annotations.Test;

public class T1_Google_Inheritance extends Testparent{
    @Test
    public void tc001_searchForACar() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //search for BMW
        ReusableMethod.sendKeysMethod(driver, "//*[@name= 'q']", "BMW", "SearchField");
        //hit submit on the google search button
        ReusableMethod.submitMethod(driver, "//*[@name= 'btnK']", "Submit");
        Thread.sleep(1000);
    }//end of test case 1
    @Test(dependsOnMethods = "tc001_searchForACar")
    public void tc002_captureSearchResult() {
        //store the search result into a string variable
        String result = ReusableMethod.captureText(driver, "//*[@id = 'result-stats']", "SearchResult");
        //split the result
        String[] searchResultArray = result.split(" ");
        //print out the number only
        System.out.println("Search Result Number is " + searchResultArray[1]);
    }//end of test case 2
}
