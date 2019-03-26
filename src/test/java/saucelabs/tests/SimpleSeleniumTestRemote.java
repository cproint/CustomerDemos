package saucelabs.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SimpleSeleniumTestRemote {
	
	static RemoteWebDriver driver;


	  public static final String USERNAME = System.getenv("SAUCE_USERNAME");
	  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
	  	  
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";


    
    public static void main(final String[] args) throws InterruptedException, MalformedURLException {

       // caps.setExperimentalOption("w3c", true);
/*        ChromeOptions caps = new ChromeOptions();
        caps.setCapability("version", "71");
        caps.setCapability("platform", "macOS 10.14");
        caps.setCapability("extendedDebugging", "true");
        caps.setCapability("capturePerformance", "true");
        caps.setCapability("name", "MyFirstPerformanceTest");*/

        //caps.setCapability("sauce:options", sauceOpts);

    	FirefoxOptions caps = new FirefoxOptions();
        caps.setCapability("version", "latest");
        caps.setCapability("platform", "Windows 2008");
        
    	

        driver = new RemoteWebDriver(new java.net.URL(URL), caps);        
        driver.get("https://www.saucedemo.com");
        
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (driver.getTitle().equalsIgnoreCase("Swag Labs") ? "passed" : "failed"));

        driver.quit();
    	
    	
    	
    	
    	
    	
/*    	DesiredCapabilities caps = DesiredCapabilities.chrome();
    	caps.setCapability("platform", "macOS 10.14");
    	caps.setCapability("version", "dev");
        
        
        driver = new RemoteWebDriver(new java.net.URL(URL), caps);

        driver.get("https://www.google.com");
    
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (driver.getTitle().equalsIgnoreCase("Google") ? "passed" : "failed"));

        
        System.out.println("Page Title:" + driver.getTitle());

        driver.quit();*/
    }
}

