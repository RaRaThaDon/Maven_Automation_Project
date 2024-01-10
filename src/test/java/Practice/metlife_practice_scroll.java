package Practice;

import Day_10_Shumon.ReusableMethod;
import org.openqa.selenium.WebDriver;

public class metlife_practice_scroll {
    public static void main(String[] args) throws InterruptedException {
        //initiate the driver
        WebDriver driver = ReusableMethod.setUpDriver();
        //navigate to metlife
        driver.navigate().to("https://www.metlife.com/");
        //click on the solutions tab
        ReusableMethod.clickMethod(driver, "//*[@aria-controls = 'section1']", "Solutions Tab");
        //click on the dental menu
        ReusableMethod.clickMethod(driver, "//*[text() = 'Dental']", "Solutions Tab");
        Thread.sleep(5000);
        ReusableMethod.scroll(driver, 0, 1500);
        Thread.sleep(5000);
        //quit the driver

        driver.quit();
    }
}
