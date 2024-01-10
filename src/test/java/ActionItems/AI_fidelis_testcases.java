package ActionItems;

import Day_10_Shumon.ReusableMethod;
import Day_13.Testparent;
import org.testng.annotations.Test;

public class AI_fidelis_testcases extends Testparent {
    @Test(priority = 1)
    public static void fidelis001() throws InterruptedException {
        //go to fidelis
        driver.navigate().to("https://www.fideliscare.org/");
        //click on search element
        ReusableMethod.clickByIndexMethod(driver, "//*[@class= 'dropdown-toggle']", 1, "search button");
        ReusableMethod.clickMethod(driver, "//*[@aria-label='Search']", "search click");
        //eneter dental coverage
        ReusableMethod.sendKeysMethod(driver, "//*[@aria-label='Search']", "Dental Coverage", "Dental coverage send keys");
        //click on search icon
        ReusableMethod.clickMethod(driver, "//*[@aria-label='Execute Search']", "click search button");
        //capture results and put into a string
        String results = new String(ReusableMethod.captureText(driver, "//*[@id='resInfo-0']", "search results"));
        //split results
        String[] split = results.split(" ");
        //print
        System.out.println(split[1]);
        //click general coverage
        ReusableMethod.clickMethod(driver, "//*[contains(text(), 'Dental Coverage')]", "General Coverage");
    }//end of test case 1

    @Test(dependsOnMethods = "fidelis001")
    public static void fidelis002() throws InterruptedException {
        //switch to second tabs
        ReusableMethod.switchToTabByIndex(driver, 1, "dental coverage tab");
        //enter first name
        ReusableMethod.sendKeysMethod(driver, "//*[@id= 'firstName']", "Bobby", "first name");
        //enter last name
        ReusableMethod.sendKeysMethod(driver, "//*[@id= 'lastName']", "Williams", "last name");
        //enter zip code
        ReusableMethod.sendKeysMethod(driver, "//*[@id= 'zipCode']", "11218", "zip code");
        //click kings county
        ReusableMethod.selectByVisibleTextMethod(driver, "//*[@id='county']", "Kings", "county select");
        //enter phone number
        ReusableMethod.sendKeysMethod(driver, "//*[@id= 'phoneNumber']", "3478629667", "phone");
        //enter email
        ReusableMethod.sendKeysMethod(driver, "//*[@id= 'email']", "zazaland786@yahoo.com", "email");
        //click checkbox
        ReusableMethod.mouseActionsClickMethod(driver, "//*[contains(text(),'By checking')]", "Checkbox");
        //click contact me button
        ReusableMethod.clickByIndexMethod(driver, "//*[text()='Contact Me']", 2, "Contact Me button");
        //capture the thank you for submission
        String success = new String(ReusableMethod.captureText(driver, "//*[@role= 'alert']", "success"));
        //print
        System.out.println(success);
        //close tab
        driver.close();
    }//end of test case 2

    @Test(dependsOnMethods = "fidelis002")
    public static void fidelis003() throws InterruptedException {
        //swithc back to first tab
        ReusableMethod.switchToTabByIndex(driver, 0, "first tab");
        //click login
        ReusableMethod.clickMethod(driver, "//*[@class = 'tool dropdown login']", "Login Button");
        //sleep
        Thread.sleep(3000);
        //click member login
        ReusableMethod.clickMethod(driver, "//*[@class = 'link-external']", "member login portal");
        //sleep
        Thread.sleep(3000);
        //switch to second tab
        ReusableMethod.switchToTabByIndex(driver, 1, "second tab");
        //capture the text from hints
        String hints = new String(ReusableMethod.captureText(driver, "//*[contains(@id,'dnn_ctr5328_H')]", "helpful hints"));
        //print
        System.out.println(hints);
        //close
        driver.close();
    }//end of test case 3
}//end of class
