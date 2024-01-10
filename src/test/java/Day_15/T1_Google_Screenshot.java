package Day_15;

import Day_10_Shumon.ReusableMethod;
import Day_13.Testparent;
import Day_14_YahooBoolean.Reusable_Method_Loggers;
import org.testng.annotations.Test;

public class T1_Google_Screenshot extends Testparent {
        @Test
        public void tc001_searchForACar() throws InterruptedException {
            //navigate to google web page
            driver.navigate().to("https://www.google.com");
            //search for BMW
            Reusable_Method_Loggers.sendKeysMethod(driver, "//*[@name= 'q']", "BMW",logger , "SearchField");
            //hit submit on the google search button
            Reusable_Method_Loggers.submitMethod(driver, "//*[@name= 'btnKlp']", logger, "Submit");
            Thread.sleep(1000);
        }//end of test case 1

    @Test
    public void 
}
