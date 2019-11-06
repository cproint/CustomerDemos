package saucelabs.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.RemoteWebDriver;

public class SimpleSeleniumTestRemote {
	
	static RemoteWebDriver driver;


	  public static final String USERNAME = System.getenv("SAUCE_USERNAME");  
	  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY"); 
	  
       public static void main(final String[] args) throws MalformedURLException, InterruptedException {


    	String URL = "https://ondemand.saucelabs.com/wd/hub";
    	
    	ChromeOptions caps = new ChromeOptions();
        caps.setCapability("browserVersion", "latest");
        caps.setCapability("platform", "macOS 10.14");
        caps.setCapability("username", USERNAME);
        caps.setCapability("accessKey", ACCESS_KEY);
        caps.setCapability("name", "myTestCase"); 
        
        driver = new RemoteWebDriver(new java.net.URL(URL), caps); 
                
        driver.get("https://www.saucedemo.com/");
        
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (driver.getTitle().equalsIgnoreCase("Swag Labs") ? "passed" : "failed"));
        driver.quit();
        
        
        //  api.jobPassed(sessionID);
        //driver.executeScript(“sauce:job-result=passed”);  


    }
}

