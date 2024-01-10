package Day_9_Fahad_Bhai;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Group_Action_Item {
    public static void main(String[] args) throws InterruptedException {
        //declare an array list variable
        ArrayList<String> firstNames = new ArrayList<>();
        //add some values to the countries array list
        firstNames.add("Steve");
        firstNames.add("Mike");

        ArrayList<String> lastNames = new ArrayList<>();
        lastNames.add("Michaels");
        lastNames.add("Jacobs");

        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("11218");
        zipCodes.add("11385");

        ArrayList<String> DOB = new ArrayList<>();
        DOB.add("10161999");
        DOB.add("08211956");

        ArrayList<String> vehicleYear = new ArrayList<>();
        vehicleYear.add("2021");
        vehicleYear.add("2023");

        ArrayList<String> vehicleMake = new ArrayList<>();
        vehicleMake.add("Audi");
        vehicleMake.add("Mercedes");

        ArrayList<String> vehicleModel = new ArrayList<>();
        vehicleModel.add("A3");
        vehicleModel.add("A Class");

        ArrayList<String> daysPerWeek = new ArrayList<>();
        daysPerWeek.add("4");
        daysPerWeek.add("5");

        ArrayList<String> miles = new ArrayList<>();
        miles.add("14");
        miles.add("22");

        ArrayList<String> address1 = new ArrayList<>();
        address1.add("90 Prospect Park Sw");
        address1.add("70 Prospect Park Sw");

        ArrayList<String> address2 = new ArrayList<>();
        address2.add("101 prospect park sw");
        address2.add("598 16th street");

        for (int i = 0; i < 2; i++) {


            //setup the chromedriver with webdrivermanager
            WebDriverManager.chromedriver().setup();
            //declare the chrome options
            ChromeOptions options = new ChromeOptions();
            //add some options for chromeoptions
            options.addArguments("start-maximized");
            //open in incognito mode
            options.addArguments("incognito");
            //define the webdriver and pass the options argument
            WebDriver driver = new ChromeDriver(options);
            //navigate to geico site
            driver.navigate().to("https://www.geico.com");
            //click on auto checkbox
            try {
                //enter a home value
                WebElement checkBox = driver.findElement(By.xpath("//*[@class='product-checkbox']"));
                //check the box
                checkBox.click();
            } catch (Exception e) {
                System.out.println("Unable to check box " + e);
            }//end of check box try catch
            //click on start my quote
            try {
                WebElement startQuote = driver.findElement(By.xpath("//*[@id='bundleModalBtn']"));
                startQuote.click();
            } catch (Exception e) {
                System.out.println("problem with start quote" + e);
            }//end of start quote try catch
            //click zipcode box
            try {
                WebElement zipCodeBox = driver.findElement(By.xpath("//*[@id='bundle-modal-zip']"));
                zipCodeBox.click();
                zipCodeBox.clear();
                //enter zip in box
                zipCodeBox.sendKeys(zipCodes.get(i));
            } catch (Exception e) {
                System.out.println("problem with Zip Code Box" + e);
            }//end of zipcode box try catch
            //sleep
            Thread.sleep(3000);
            //click on homeowners
            try {
                ArrayList<WebElement> homeOwner = new ArrayList<>(driver.findElements(By.xpath("//*[@data-product='homeowners']")));
                homeOwner.get(1).click();
            } catch (Exception e) {
                System.out.println("problem with home owners" + e);
            }//end of homeowners try catch
            //sleep
            Thread.sleep(3000);
            //click continue
            try {
                ArrayList<WebElement> Continue = new ArrayList<>(driver.findElements(By.xpath("//*[@value='Continue']")));
                Continue.get(1).click();
                //driver.findElements(By.xpath("//*[@value='Continue']")).get(0).click();
            } catch (Exception e) {
                System.out.println("problem with Continue    " + e);
                Thread.sleep(3000);
            }//end of continue try catch
            try {
                driver.findElements(By.xpath("//*[@value='Continue']")).get(0).click();
                //create web element for datebox
            } catch (Exception e) {
                System.out.println("problem with second continue +" + e);
            }//end of continue try catch
            Thread.sleep(3000);
            //input date of birth
            try {
                WebElement dateBox = driver.findElement(By.xpath("//*[@aria-label='Date of Birth']"));
                //enter date of birth
                dateBox.sendKeys(DOB.get(i));
            } catch (Exception e) {
                System.out.println("problem with datebox" + e);
            }//end of date of birth try catch
            //sleep
            Thread.sleep(3000);
//click next
            try {
                WebElement next = driver.findElement(By.xpath("//*[text()='Next']"));
                next.submit();
            } catch (Exception e) {
                System.out.println("problem with next" + e);
            }//end of next try catch
            Thread.sleep(3000);
            //enter first name
            try {
                WebElement firstName = driver.findElements(By.xpath("//*[contains(@id,'Id_GiveFirstName')]")).get(1);
                firstName.click();
                firstName.sendKeys(firstNames.get(i));
            } catch (Exception e) {
                System.out.println("problem with first name" + e);
            }//end of first name try catch
            try {
                WebElement lastName = driver.findElements(By.xpath("//*[contains(@id,'Id_GiveLastName')]")).get(1);
                lastName.click();
                lastName.sendKeys(lastNames.get(i));
            } catch (Exception e) {
                System.out.println("problem with last name" + e);
            }//end of last name try catch
            try {
                WebElement next = driver.findElement(By.xpath("//*[text()='Next']"));
                next.submit();
            } catch (Exception e) {
                System.out.println("problem with next" + e);
            }
            Thread.sleep(4000);
//            //fill out address
            try {
                WebElement address = driver.findElement(By.xpath("//*[@type='search']"));
                Thread.sleep(3000);
                address.sendKeys(address1.get(i));
                //address.submit();
            } catch (Exception e) {
                System.out.println("problem with address" + e);
            }//end of try catch for address
            Thread.sleep(3000);
            try {
                ArrayList<WebElement> apartment = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'address-search')]")));
                apartment.get(1).click();
                //apartment.get(1).clear();
                apartment.get(1).sendKeys("5A");
            } catch (Exception e) {
                System.out.println("problem with apartment" + e);
                Thread.sleep(3000);
            }//end of try catch for address
            //now hit next (1)
            try {
                WebElement next = driver.findElement(By.xpath("//*[text()='Next']"));
                next.submit();
            } catch (Exception e) {
                System.out.println("problem with next" + e);
            }//end of next try catch
            //hit the yes button (1)
            try {
                // yes radio button
                ArrayList<WebElement> radioButton = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@id,'labelFor')]")));
                radioButton.get(0).click();
            } catch (Exception e) {
                System.out.println("problem with first radio button" + e);
            }//end of first yes button try catch
//next (2)
            try {
                WebElement next = driver.findElement(By.xpath("//*[contains(@class,'btn btn--primary')]"));
                next.submit();
            } catch (Exception e) {
                System.out.println("problem with next" + e);
            }//end of next button try catch
            try {
                // radio button no (1)
                ArrayList<WebElement> radioButton = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@id,'labelFor')]")));
                radioButton.get(1).click();
            } catch (Exception e) {
                System.out.println("problem with first no radio button" + e);
            }//end of first no button try catch
            //next (2)
            try {
                WebElement next = driver.findElement(By.xpath("//*[contains(@class,'btn btn--primary')]"));
                next.submit();
            } catch (Exception e) {
                System.out.println("problem with next" + e);
            }//end of next button try catch
            //yes(2)
            try {
                // radio button
                ArrayList<WebElement> radioButton = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@id,'labelFor')]")));
                radioButton.get(0).click();
            } catch (Exception e) {
                System.out.println("problem with 2nd yes radio button" + e);
            }//end of second yes button try catch
            try {
                WebElement next = driver.findElement(By.xpath("//*[contains(@class,'btn btn--primary')]"));
                next.submit();
            } catch (Exception e) {
                System.out.println("problem with next" + e);
            }//end of next button try catch
            //enter prior address
            try {
                WebElement address = driver.findElement(By.xpath("//*[@type='search']"));
                Thread.sleep(3000);
                address.sendKeys(address2.get(i));
                //address.submit();
            } catch (Exception e) {
                System.out.println("problem with prior address " + e);
            }//end of try catch for address2
            try {
                WebElement aptPrior = driver.findElement(By.xpath("//*[@aria-label='Apt #']"));
                aptPrior.sendKeys("5a");
            } catch (Exception e) {
                System.out.println("problem with prior apt");
            }
//enter zipcode
            try {
                WebElement zipCodePrior = driver.findElement(By.xpath("//*[@aria-label='5-Digit ZIP Code']"));
                zipCodePrior.sendKeys(zipCodes.get(i));
            } catch (Exception e) {
                System.out.println("print problem with prior zipcode" + e);
            }//end of prior zipcode
            //click next
            try {
                WebElement next = driver.findElement(By.xpath("//*[contains(@class,'btn btn--primary')]"));
                next.submit();
            } catch (Exception e) {
                System.out.println("problem with 3rd next" + e);
            }//end of next button try catch
            //click no
            try {
                // radio button no (1)
                ArrayList<WebElement> radioButton = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@id,'labelFor')]")));
                radioButton.get(1).click();
            } catch (Exception e) {
                System.out.println("problem with third no radio button" + e);
            }//end of first no button try catch
            //hit next
            try {
                WebElement next = driver.findElement(By.xpath("//*[contains(@class,'btn btn--primary')]"));
                next.submit();
            } catch (Exception e) {
                System.out.println("problem with next" + e);
            }//end of next button try catch
//select vehicle year
            try {
                WebElement vehicleYearD = driver.findElement(By.xpath("//*[@aria-label='Year']"));
                //set the select function for the start month dropdown
                Select vehicleYearDropdown = new Select(vehicleYearD);
                //select by visible text
                vehicleYearDropdown.selectByVisibleText(vehicleYear.get(i));
            } catch (Exception e) {
                System.out.println("problem with vehicle year dropdown " + e);
            }//end of vehicle year try catch
//select vehicle make
            try {
                WebElement vehicleMakeD = driver.findElement(By.xpath("//*[@aria-label='Make']"));
                //set the select function for the start month dropdown
                Select vehicleMakeDropdown = new Select(vehicleMakeD);
                //select by visible text
                vehicleMakeDropdown.selectByVisibleText(vehicleMake.get(i));
            } catch (Exception e) {
                System.out.println("problem with vehicle make dropdown " + e);
            }//end of vehicle make try catch
//select vehicle model
            try {
                WebElement vehicleModelD = driver.findElement(By.xpath("//*[@aria-label='Model']"));
                //set the select function for the start month dropdown
                Select vehicleModelDropdown = new Select(vehicleModelD);
                //select by visible text
                vehicleModelDropdown.selectByVisibleText(vehicleModel.get(i));
            } catch (Exception e) {
                System.out.println("problem with vehicle make dropdown " + e);
            }
            //next 5
            try {
                WebElement next = driver.findElement(By.xpath("//*[contains(@class,'btn btn--primary')]"));
                next.submit();
            } catch (Exception e) {
                System.out.println("problem with next" + e);
            }//end of next 5 button try catch
            try {
                WebElement next = driver.findElement(By.xpath("//*[contains(@class,'btn btn--primary')]"));
                next.submit();
            } catch (Exception e) {
                System.out.println("problem with next" + e);
            }//end of next button try catch
            //now click leased
            try {
                WebElement leased = driver.findElement(By.xpath("//*[@id='labelForL']"));
                leased.click();
            } catch (Exception e) {
                System.out.println("problem with leased button" + e);
            }//end of leased try catch
            //next 6
            try {
                WebElement next = driver.findElement(By.xpath("//*[contains(@class,'btn btn--primary')]"));
                next.submit();
            } catch (Exception e) {
                System.out.println("problem with next 6" + e);
            }//end of next 6 button try catch
            // choose commute
            try {
                WebElement leased = driver.findElement(By.xpath("//*[@id='labelForC']"));
                leased.click();
            } catch (Exception e) {
                System.out.println("problem with commute button" + e);
            }//end of leased try catch
//next 7
            try {
                WebElement next = driver.findElement(By.xpath("//*[contains(@class,'btn btn--primary')]"));
                next.submit();
            } catch (Exception e) {
                System.out.println("problem with next 7" + e);
            }//end of next 7 button try catch
            //select days per week
            try {
                WebElement daysPerWeekD = driver.findElement(By.xpath("//*[@aria-label='Days per Week']"));
                //set the select function for days per week
                Select daysPerWeekDropdown = new Select(daysPerWeekD);
                //select by visible text
                daysPerWeekDropdown.selectByVisibleText(daysPerWeek.get(i));
            } catch (Exception e) {
                System.out.println("problem with vehicle make dropdown " + e);
            }//end of days per week try catch
            //enter miles
            try {
                WebElement milesBox = driver.findElement(By.xpath("//*[@type = 'tel']"));
                milesBox.sendKeys(miles.get(i));
            } catch (Exception e) {
                System.out.println("problem with miles box" + e);
            }//end of miles box try catch
            //next 8
            try {
                WebElement next = driver.findElement(By.xpath("//*[contains(@class,'btn btn--primary')]"));
                next.submit();
            } catch (Exception e) {
                System.out.println("problem with next 8" + e);
            }//end of next 8 try catch
            //next 9
            try {
                WebElement next = driver.findElement(By.xpath("//*[contains(@class,'btn btn--primary')]"));
                next.submit();
            } catch (Exception e) {
                System.out.println("problem with next 9" + e);
            }//end of next 9 button try catch
            //next 10
            try {
                WebElement next = driver.findElement(By.xpath("//*[contains(@class,'btn btn--primary')]"));
                next.submit();
            } catch (Exception e) {
                System.out.println("problem with next 10" + e);
            }//end of next 10 button try catch
            //select gender
            try {
                WebElement genderD = driver.findElement(By.xpath("//*[@aria-label='Gender']"));
                //set the select function for gender
                Select genderDropdown = new Select(genderD);
                //select by visible text
                genderDropdown.selectByVisibleText("Male");
            } catch (Exception e) {
                System.out.println("problem with vehicle make dropdown " + e);
            }//end of gender try catch
            //hit agree and continue
            try {
                WebElement agreeContinue = driver.findElement(By.xpath("//*[@type='submit']"));
                agreeContinue.click();
            } catch (Exception e) {
                System.out.println("problem with agree and continue" + e);
            }//end of try catch for agree and continue
        }//end of loop
    }//end of main
}//end of class
