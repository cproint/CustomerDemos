package saucelabs.tests;

import java.net.MalformedURLException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class SimpleSeleniumTestRemoteEmuSimu {
	
	  public static final String USERNAME = System.getenv("SAUCE_USERNAME");
	  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
	  
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    public static void main(final String[] args) throws InterruptedException, MalformedURLException {

    	 DesiredCapabilities caps = new DesiredCapabilities();
/*    	 caps.setCapability("platformName", "Android");
    	 caps.setCapability("platformVersion", "6.0");
    	 caps.setCapability("deviceName", "Android Emulator");
    	 caps.setCapability("browserName", "chrome");
    	 
         AppiumDriver<MobileElement> driver = new AndroidDriver<>(new java.net.URL(URL), caps); */
    	 
    	 
    	 
    	 caps.setCapability("platformName", "iOS");
    	 caps.setCapability("platformVersion", "12.0");
    	 caps.setCapability("deviceName", "iPhone X Simulator");
    	 caps.setCapability("browserName", "safari");
    	 caps.setCapability("name", "myFirstAppiumScript");

    	 
         AppiumDriver<MobileElement> driver = new IOSDriver<>(new java.net.URL(URL), caps); 

         driver.get("https://www.cisco.com");
    
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (driver.getTitle().equalsIgnoreCase("Cisco - Global Home Page") ? "passed" : "failed"));

        driver.quit();
    }
}

