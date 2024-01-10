package Day_11_ReuseableMetlife;

import Day_10_Shumon.ReusableMethod;
import org.openqa.selenium.WebDriver;

public class T2_ReusableYahoo {
    public static void main(String[] args) {
        //instantiate the driver
        WebDriver driver = ReusableMethod.setUpDriver();
        //navigate to metlife
        driver.navigate().to("https://www.yahoo.com/");
        //click on the sports menu (third tab, index 2)
       ReusableMethod.clickByIndexMethod(driver, "//*[contains(@class,'_yb_q22uj')]", 2, "yahoo headers");
        //quit driver
        driver.quit();
    }//end of main
}
