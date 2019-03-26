package saucelabs.tests;


import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class SauceW3CCiscoExample {
	
	static RemoteWebDriver driver;


	  public static final String USERNAME = System.getenv("SAUCE_USERNAME");
	  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
	  
	  
	  public static final String URL = "https://ondemand.saucelabs.com:443/wd/hub";


    
    public static void main(final String[] args) throws InterruptedException, MalformedURLException {

	    //firefox64();
	    //safari12();
	    //firefox63();
	    chrome72();
	    //edge17();
	    //ie11();
    	//safariOnEmulator();
    }
    
    public static void chrome72() throws MalformedURLException {
    	
        ChromeOptions caps = new ChromeOptions();        
        caps.setExperimentalOption("w3c", true);
        
        caps.setCapability("browserVersion", "72.0");
        caps.setCapability("platformName", "macOS 10.14");

        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("name", "TestW3C-Chrome-72-Performance");
        sauceOpts.setCapability("seleniumVersion", "3.141.59");
        sauceOpts.setCapability("user", USERNAME);
        sauceOpts.setCapability("accessKey", ACCESS_KEY);
        sauceOpts.setCapability("tags", "performance-tests");
        sauceOpts.setCapability("extendedDebugging", "true");


        caps.setCapability("sauce:options", sauceOpts);


        driver = new RemoteWebDriver(new java.net.URL(URL), caps);        
        driver.get("https://www.saucedemo.com");
        
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (driver.getTitle().equalsIgnoreCase("Swag Labs") ? "passed" : "failed"));

        driver.quit();
    }
    
    public static void firefox63() throws MalformedURLException {
        FirefoxOptions caps = new FirefoxOptions();

        caps.setCapability("browserVersion", "63.0");
        caps.setCapability("platformName", "Windows 10");

        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("name", "TestW3C-Firefox63");
        sauceOpts.setCapability("seleniumVersion", "3.141.59");
        sauceOpts.setCapability("user", USERNAME);
        sauceOpts.setCapability("accessKey", ACCESS_KEY);
        sauceOpts.setCapability("tags", "w3c-firefox-tests");

        caps.setCapability("sauce:options", sauceOpts);


        driver = new RemoteWebDriver(new java.net.URL(URL), caps);        
        driver.get("https://www.cisco.com");
        
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (driver.getTitle().equalsIgnoreCase("Cisco - Global Home Page") ? "passed" : "failed"));

        driver.quit();
    }
    
    public static void safari12() throws MalformedURLException {
        SafariOptions caps = new SafariOptions();

        caps.setCapability("browserVersion", "12.0");
        caps.setCapability("platformName", "macOS 10.14");
        
        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("name", "TestW3C-Safari12");
        sauceOpts.setCapability("seleniumVersion", "3.141.59");
        sauceOpts.setCapability("user", USERNAME);
        sauceOpts.setCapability("accessKey", ACCESS_KEY);
        sauceOpts.setCapability("tags", "w3c-safari-tests");

        caps.setCapability("sauce:options", sauceOpts);


        driver = new RemoteWebDriver(new java.net.URL(URL), caps);        
        driver.get("https://www.cisco.com");
  
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (driver.getTitle().equalsIgnoreCase("Cisco - Global Home Page") ? "passed" : "failed"));

        driver.quit();
    }
    public static void firefox64() throws MalformedURLException {
        FirefoxOptions caps = new FirefoxOptions();

        caps.setCapability("browserVersion", "64.0");
        caps.setCapability("platformName", "Windows 10");

        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("name", "TestW3C-Firefox64");
        sauceOpts.setCapability("seleniumVersion", "3.141.59");
        sauceOpts.setCapability("user", USERNAME);
        sauceOpts.setCapability("accessKey", ACCESS_KEY);
        sauceOpts.setCapability("tags", "w3c-firefox-tests");

        caps.setCapability("sauce:options", sauceOpts);


        driver = new RemoteWebDriver(new java.net.URL(URL), caps);        
        driver.get("https://www.cisco.com");
  
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (driver.getTitle().equalsIgnoreCase("Cisco - Global Home Page") ? "passed" : "failed"));

        driver.quit();
    }
    
    public static void ie11() throws MalformedURLException {
    	
    	InternetExplorerOptions caps = new InternetExplorerOptions();
    	
        caps.setCapability("browserVersion", "11.285");
        caps.setCapability("platformName", "Windows 10");
        
        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("name", "TestW3C-IE11");
        sauceOpts.setCapability("seleniumVersion", "3.141.59");
        sauceOpts.setCapability("user", USERNAME);
        sauceOpts.setCapability("accessKey", ACCESS_KEY);
        sauceOpts.setCapability("tags", "w3c-ie11.285-tests");


        caps.setCapability("sauce:options", sauceOpts);


        driver = new RemoteWebDriver(new java.net.URL(URL), caps);        
        driver.get("https://www.cisco.com");
        
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (driver.getTitle().equalsIgnoreCase("Cisco - Global Home Page") ? "passed" : "failed"));

        driver.quit();
    }
    
    public static void edge17() throws MalformedURLException {
    	
    	EdgeOptions caps = new EdgeOptions();

    	caps.setCapability("browserVersion", "17.17134");
        caps.setCapability("platformName", "Windows 10");
        
        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("name", "TestW3C-Edge17");
        sauceOpts.setCapability("seleniumVersion", "3.141.59");
        sauceOpts.setCapability("user", USERNAME);
        sauceOpts.setCapability("accessKey", ACCESS_KEY);
        sauceOpts.setCapability("tags", "w3c-edge17-tests");


        caps.setCapability("sauce:options", sauceOpts);


        driver = new RemoteWebDriver(new java.net.URL(URL), caps);        
        driver.get("https://www.cisco.com");
        
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (driver.getTitle().equalsIgnoreCase("Cisco - Global Home Page") ? "passed" : "failed"));

        driver.quit();
    }
    
    public static void safariOnEmulator() throws MalformedURLException {
        SafariOptions caps = new SafariOptions();

        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("platformName", "iOS");
      	 caps.setCapability("deviceName", "iPhone X Simulator");
       	 //caps.setCapability("browserName", "safari");


        
        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("name", "TestW3C-SafariOnEmulator");
        sauceOpts.setCapability("seleniumVersion", "3.141.59");
        sauceOpts.setCapability("user", USERNAME);
        sauceOpts.setCapability("accessKey", ACCESS_KEY);

        caps.setCapability("sauce:options", sauceOpts);

        
   	 
        AppiumDriver<MobileElement> driver = new IOSDriver<>(new java.net.URL(URL), caps); 

        driver.get("https://www.cisco.com");
   
       ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (driver.getTitle().equalsIgnoreCase("Cisco - Global Home Page") ? "passed" : "failed"));

       driver.quit();
        
        
        
        

    }
    
    
}




