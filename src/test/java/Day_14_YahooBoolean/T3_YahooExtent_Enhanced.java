package Day_14_YahooBoolean;

import Day_13.Testparent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T3_YahooExtent_Enhanced extends Testparent {
    @Test
    public void tc001_verifyStaySignedInIsChecked() {
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com/");
        //click on sign in button
        Reusable_Method_Loggers.clickMethod(driver, "//*[text() = 'Sign in']", logger, "Sign In Button");
        //store checked option into a boolean variable
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if condition is true
        Reusable_Method_Loggers.isConditionTrue(isStaySignedInChecked, logger);
    }//end of tc 01
}
