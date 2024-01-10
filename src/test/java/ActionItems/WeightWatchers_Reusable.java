package ActionItems;

import Day_10_Shumon.ReusableMethod;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class WeightWatchers_Reusable {
    public static void main(String[] args) throws InterruptedException {
        //declare an array list variable
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("06108");
        zipCode.add("11215");
        //initiate the driver
        WebDriver driver = ReusableMethod.setUpDriver();
        //start for loop
        for (int i = 0; i < zipCode.size(); i++) {
//navigate to weightwatchers
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop");
            //click find a workshop
            ReusableMethod.clickMethod(driver, "//*[text()='Find a Workshop']", "Find A Workshop");
            //click in person
            ReusableMethod.clickMethod(driver, "//*[text()='In-Person']", "In-Person");
            //clear zipcode box
            ReusableMethod.clearMethod(driver, "//*[@id= 'location-search']", "location search bar");
            //search zipcode
            ReusableMethod.sendKeysMethod(driver, "//*[@id= 'location-search']", zipCode.get(i), "location search");
            // click submit
            ReusableMethod.clickMethod(driver, "//*[contains(@class,'rightArrow-daPRP')]", "right arrow");
            //click different studio links
            if (i == 0) {
                ReusableMethod.clickByIndexMethod(driver, "//*[contains(@class,'linkUnderline')]", 1, "studio");
            } else if (i == 1) {
                ReusableMethod.clickByIndexMethod(driver, "//*[contains(@class,'linkUnderline')]", 2, "studio");
            } else if (i == 2) {
                ReusableMethod.clickByIndexMethod(driver, "//*[contains(@class,'linkUnderline')]", 0, "studio");
                //print address
                //ReusableMethod.captureText(driver, "//*[@class ='address-2PZwW']", "address");
                String address = ReusableMethod.captureText(driver, "//*[@class ='address-2PZwW']", "address");
                System.out.println(address);
                // scroll to in person workshops
                ReusableMethod.scrollMethod(driver, "//*[@class ='title-bEfSM']", "in person workshops");
                // capture schedule
                String schedule = ReusableMethod.captureText(driver, "//*[contains(@class,'scheduleContainer')]", "schedule text");
                System.out.println(schedule);
            }//end of if else
        }//end of loop
        driver.quit();
    }//end of main
}//end of class

