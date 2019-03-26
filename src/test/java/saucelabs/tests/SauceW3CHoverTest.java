package saucelabs.tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceW3CHoverTest {
	
	static RemoteWebDriver driver;


	  public static final String USERNAME = System.getenv("SAUCE_USERNAME");
	  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
	  
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    
    public static void main(final String[] args) throws InterruptedException, MalformedURLException {

        ChromeOptions chromeOpts = new ChromeOptions();
        chromeOpts.setExperimentalOption("w3c", true);

        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("name", "SauceW3CHoverTest");
        sauceOpts.setCapability("seleniumVersion", "3.141.59");
        sauceOpts.setCapability("user", USERNAME);
        sauceOpts.setCapability("accessKey", ACCESS_KEY);

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY,  chromeOpts);
        caps.setCapability("sauce:options", sauceOpts);
        caps.setCapability("browserVersion", "71.0");
        caps.setCapability("platformName", "macOS 10.13");

        driver = new RemoteWebDriver(new java.net.URL(URL), caps);        
        driver.get("http://newtours.demoaut.com/");
  
        WebElement link_home = driver.findElementByLinkText("Home");
        WebElement td_home = driver.findElementByXPath("/html/body/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]");

        
        
        
        Actions builder = new Actions(driver);
        builder.click().moveToElement(link_home).build().perform();
        
        
        
        	    
        	    
/*
        	    background_color_before = td_home.value_of_css_property("background-color");

        	    builder.perform();

        	    background_color_after = td_home.value_of_css_property("background-color");

        	    print background_color_before
        	    print background_color_after
        
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (driver.getTitle().equalsIgnoreCase("Google") ? "passed" : "failed"));
*/
        driver.quit();
    }
}

