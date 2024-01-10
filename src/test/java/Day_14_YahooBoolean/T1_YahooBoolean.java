package Day_14_YahooBoolean;

import Day_10_Shumon.ReusableMethod;
import Day_13.Testparent;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_YahooBoolean extends Testparent {
    @Test
    public void tc001_verifyStaySignedInIsChecked() {
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com/");
        //click on sign in button
        ReusableMethod.clickMethod(driver, "//*[text() = 'Sign in']", "Sign In Button");
        //store checked option into a boolean variable
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if its true
        Assert.assertTrue(isStaySignedInChecked);
    }//end of tc 01
    @Test
    public void tc002_verifySignInOptionIsUnchecked(){
        //click on the checkbox to uncheck it
        ReusableMethod.clickMethod(driver, "//*[@class= 'stay-signed-in checkbox-container']", "checkbox");
        //should store false value since checkbox is not checked
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if its true
        Assert.assertFalse(isStaySignedInChecked);
    }//end of tc002
}
