package saucelabs.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DiscountTiresTest {
	
	static RemoteWebDriver driver;


	  public static final String USERNAME = System.getenv("SAUCE_USERNAME");
	  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
	  public static final String BROWSER_VERSION = System.getenv("SELENIUM_VERSION");
	  public static final String PLATFORM_NAME = System.getenv("SELENIUM_PLATFORM");

	  	  
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";


    
@Test
public void testWithFirefox() throws MalformedURLException {

	System.out.println("Browser Version from Sauce JenkinsPlug-In: "+BROWSER_VERSION);
	System.out.println("Platform Name from Sauce JenkinsPlug-In: " +PLATFORM_NAME);

	
    	FirefoxOptions caps = new FirefoxOptions();
        caps.setCapability("version", BROWSER_VERSION);
        caps.setCapability("platform", PLATFORM_NAME);

        driver = new RemoteWebDriver(new java.net.URL(URL), caps);        
        driver.get("https://www.saucedemo.com");
 	
}   	
    	
    	
@AfterMethod
public void tearDown() {
    ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (driver.getTitle().equalsIgnoreCase("Swag Labs") ? "passed" : "failed"));

    driver.quit();
	
    }
}

