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

public class LocalW3CHoverTest {
	
	private static final String URL = null;
	static RemoteWebDriver driver;


    public static void main(final String[] args) throws InterruptedException, MalformedURLException {

    	System.setProperty("webdriver.chrome.driver", "/Users/muralitulugu/Documents/ams/armada-test/Drivers/chromedriver");

        ChromeOptions chromeOpts = new ChromeOptions();
        chromeOpts.setExperimentalOption("w3c", true);

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY,  chromeOpts);



    	
		driver = new ChromeDriver(chromeOpts); 
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

