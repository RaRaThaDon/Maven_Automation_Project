package Day_11_ReuseableMetlife;

import Day_10_Shumon.ReusableMethod;
import org.openqa.selenium.WebDriver;

public class T1_ReusableMetlife {
    public static void main(String[] args) {
        //initiate the driver
        WebDriver driver = ReusableMethod.setUpDriver();
        //navigate to metlife
        driver.navigate().to("https://www.metlife.com/");
        //click on the solutions tab
        ReusableMethod.clickMethod(driver, "//*[@aria-controls = 'section1']", "Solutions Tab");
        //click on the dental menu
        ReusableMethod.clickMethod(driver, "//*[text() = 'Dental']", "Solutions Tab");
        //quit the driver
        driver.quit();
    }//end of main
}
