package Day_10_Shumon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T4_Google_ReuseableMethod {
    public static void main(String[] args) {
        //declare webdrivermanager to set up the chromedriver
        WebDriverManager.chromedriver().setup();
        //set chromeoptions for preset of arguments for the driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        //declare your web driver and pass the options variable inside the chromedriver
        WebDriver sumonDriver = new ChromeDriver(options);
        //navigate to google site
        sumonDriver.navigate().to("https://www.google.com");

        //click on Google Search button
        ReusableMethod.submitMethod(sumonDriver,"//*[@name='btnK']","Search Button");

        ReusableMethod.clickMethod(sumonDriver,"//*[text()='About']","About Link");
    }//end of main
}//end of class
