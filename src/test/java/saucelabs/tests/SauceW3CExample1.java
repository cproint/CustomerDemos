package saucelabs.tests;


import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceW3CExample1 {
	
	static RemoteWebDriver driver;


	  public static final String USERNAME = System.getenv("SAUCE_USERNAME");
	  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
	  
	  
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";


    
    public static void main(final String[] args) throws InterruptedException, MalformedURLException {

        ChromeOptions chromeOpts = new ChromeOptions();
        chromeOpts.setExperimentalOption("w3c", true);

        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("name", "TestW3C");
        sauceOpts.setCapability("seleniumVersion", "3.141.59");
        sauceOpts.setCapability("user", USERNAME);
        sauceOpts.setCapability("accessKey", ACCESS_KEY);
        sauceOpts.setCapability("tags", "w3c-chrome-tests");

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY,  chromeOpts);
        caps.setCapability("sauce:options", sauceOpts);
        caps.setCapability("browserName", "googlechrome");
        caps.setCapability("browserVersion", "71.0");
        caps.setCapability("platformName", "macOS 10.13");

        driver = new RemoteWebDriver(new java.net.URL(URL), caps);        
        driver.get("https://www.google.com");
  
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (driver.getTitle().equalsIgnoreCase("Google") ? "passed" : "failed"));

        driver.quit();
    }
}




