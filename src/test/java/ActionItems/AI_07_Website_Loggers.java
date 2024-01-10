package ActionItems;

import Day_10_Shumon.ReusableMethod;
import Day_13.Testparent;
import Day_14_YahooBoolean.Reusable_Method_Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AI_07_Website_Loggers extends Testparent {
    @Test
    public void TC_Use_Locate_Branch_Tool () throws InterruptedException {
        //go to website
        driver.navigate().to("https://www.enorthfield.com/");
        //click on find a branch
        Reusable_Method_Loggers.clickMethod(driver,"//*[@aria-label='Find a Branch']",logger,"find a branch");
        //scroll into view so you can see the zip code
        Thread.sleep(2000);
        Reusable_Method_Loggers.scrollMethod(driver,"//*[@aria-label='Learn More - Home']",logger,"Find a Branch");
        //enter zip code
        Reusable_Method_Loggers.sendKeysMethod(driver,"//*[@id='txtZipCode']","11218",logger,"zip code search");
        //select the zip code
        Reusable_Method_Loggers.mouseActionsClickbyIndexMethod(driver, "//*[text()='11218']", 1, logger,"11218");
        Thread.sleep(3000);
        //hit search
        Reusable_Method_Loggers.clickMethod(driver,"//*[@class='ctabutton']",logger,"search");
        //capture text from location 1
        String location1 = new String(Reusable_Method_Loggers.captureText(driver,"//*[@id='location-box-0']",logger,"first location"));
        //print the first location
        System.out.println(location1);
    }//end of branch tool test

    @Test
    public void TC_requestappointment () throws InterruptedException {
        //go to website
        driver.navigate().to("https://www.enorthfield.com/");
        //click commercial
        Reusable_Method_Loggers.clickByIndexMethod(driver,"//*[@class='first-level-link']",5,logger,"Commercial");
//click the tab you want
        Reusable_Method_Loggers.clickMethod(driver,"//*[@aria-label='Commercial Business Analysis Checking']",logger,"commerical analyst");
        //click request an appointment
        Reusable_Method_Loggers.clickMethod(driver,"//*[contains(@aria-label,' About Re')]",logger,"request an appt");
//enter first name
        Reusable_Method_Loggers.sendKeysByIndexMethod(driver,"//*[contains(@class,'text ')]","Bobby",2,logger,"first name");
        //enter last name
        Reusable_Method_Loggers.sendKeysByIndexMethod(driver,"//*[contains(@class,'text ')]","Williams",3,logger,"last name");
        //company name
        Reusable_Method_Loggers.sendKeysByIndexMethod(driver,"//*[contains(@class,'text ')]","Oscorp",4,logger,"company name");
        //email
        Reusable_Method_Loggers.sendKeysByIndexMethod(driver,"//*[contains(@class,'text ')]","zazaland456@gmail.com",5,logger,"email");
        //phone number
        Reusable_Method_Loggers.sendKeysByIndexMethod(driver,"//*[contains(@class,'text ')]","3478769856",6,logger,"phone");
        // select county
        Reusable_Method_Loggers.selectByVisibleTextMethod(driver,"//*[contains(@id,'214')]", "Middlesex County, NJ", logger, "country name");
        // select branch
        Reusable_Method_Loggers.selectByVisibleTextMethod(driver,"//*[contains(@id,'54f')]","Avenel",logger,"branch");
        //enter text in box
        Reusable_Method_Loggers.sendKeysMethod(driver,"//*[contains(@id,'34d')]","I would like to open an account asap",logger,"Help Box");
        //Business or consumer?
        Reusable_Method_Loggers.selectByVisibleTextMethod(driver,"//*[contains(@id,'f78')]","Business",logger,"business or consumer");
        //reason for appointment
        Reusable_Method_Loggers.selectByVisibleTextMethod(driver,"//*[contains(@id,'e68')]","Discuss Small Business Loan Options",logger,"reason");
        //Preferred meeting
        Reusable_Method_Loggers.selectByVisibleTextMethod(driver,"//*[contains(@id,'8fa')]","In-Person Meeting",logger,"In-Person Meeting");
        //hit submit
        Reusable_Method_Loggers.clickMethod(driver,"//*[@class='btn primary']",logger,"Submit");
    }//end of TC 2


    @Test
    public void TC_youtube () throws InterruptedException {
        //navigate to website
       driver.navigate().to("https://www.enorthfield.com/");
//click personal
        Reusable_Method_Loggers.clickByIndexMethod(driver,"//*[@class='first-level-link']",4,logger,"Personal");
        //click intrafi cash service
        Reusable_Method_Loggers.clickMethod(driver,"//*[@aria-label='Personal Intrafi Cash Service']",logger,"intrafi cash service");
        //scroll to youtube video
        Reusable_Method_Loggers.scrollMethod(driver,"//*[contains(text(),'And, as always, know that your')]",logger,"scroll to youtube");
        //click play
        Reusable_Method_Loggers.clickMethod(driver,"//*[@class='mceNonEditable embeditem']",logger,"yt play");
        //click pause after 5 seconds
        Thread.sleep(5000);
        Reusable_Method_Loggers.clickMethod(driver,"//*[@class='mceNonEditable embeditem']",logger,"yt play");
    }//end of Youtube Test case

    @Test
    public void Tc_004_Credit_Card_Info() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            //Navigate to the website
            driver.navigate().to("https://www.enorthfield.com/");
            //assert Boolean
       boolean tabSaysPersonal = driver.findElements(By.xpath("//*[@class='first-level-link']")).get(4).isDisplayed();
        Assert.assertTrue(tabSaysPersonal);
        Thread.sleep(3000);
            //click personal
            Reusable_Method_Loggers.clickByIndexMethod(driver, "//*[@class='first-level-link']", 4, logger, "Personal");
            //go through the menu
//            Thread.sleep(2000);
            //click by index for the different credit cards
            Reusable_Method_Loggers.clickByIndexMethod(driver, "//*[contains(text(),'Visa')]", i, logger, "credit cards");
            //capture text for credit cards and print it out
            String column = Reusable_Method_Loggers.captureText(driver, "//*[@class='leftcolumn']", logger, "left column");
            System.out.println(column);
//            Thread.sleep(3000);
        }//end of loop
    }//end of TC004

    @Test
    public void TC_005_Compare_Accounts() throws InterruptedException {
//navigate to website
        driver.navigate().to("https://www.enorthfield.com/");
        //click personal
        Reusable_Method_Loggers.clickByIndexMethod(driver, "//*[@class='first-level-link']", 4, logger, "Personal");
        //assert compare
        String actual = new String(Reusable_Method_Loggers.captureTextV(driver,"//*[@aria-label='Personal Compare Accounts-Checking']",logger,"compare"));
        Thread.sleep(3000);
String expected = "Compare Accounts";
        Assert.assertEquals(actual, expected);
        //click compare
        Reusable_Method_Loggers.clickMethod(driver,"//*[@aria-label='Personal Compare Accounts-Checking']",logger,"compare");
        //scroll through information
        Reusable_Method_Loggers.scrollMethod(driver,"//*[text()='Features']",logger,"top");
        //scroll down a bit
        Reusable_Method_Loggers.scrollMethod(driver,"//*[text()='$1,500.00']",logger,"top");
        // print everything
        String table = new String(Reusable_Method_Loggers.captureTextV(driver,"//*[contains(@class,'ratetablepanel')]",logger,"table"));
        System.out.println(table);
    }
    }//end of class




//        WebElement location = driver.findElement(By.xpath("//*[@title='param[selectcity]']"));
//        //set the select function for the start month dropdown
//        Select locationDropdown = new Select(location);
//        //select by visible text
//        locationDropdown.selectByVisibleText("Brooklyn,NY");
//        Reusable_Method_Loggers.selectByindexVisibleTextMethod(driver,"//*[@class='ui-selectmenu-text']","Brooklyn,NY",2,logger,"select menu");
//move slider
        //Thread.sleep(4000);
//Reusable_Method_Loggers.moveByOffsetX(driver,"//*[@class='ytp-scrubber-container']",200,0,logger,"scrubber button");