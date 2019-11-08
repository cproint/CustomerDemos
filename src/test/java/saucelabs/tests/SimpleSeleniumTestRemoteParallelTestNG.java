package saucelabs.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;

public class SimpleSeleniumTestRemoteParallelTestNG {
	
    public String buildTag = System.getenv("BUILD_TAG");

    public String sauceUserName = System.getenv("SAUCE_USERNAME");
    public String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");
 
    WebDriver driver;
    
    public static RemoteWebDriver getWebDriver(String browserName, String browserVersion, String platformName) throws MalformedURLException {

			String sauceUserName     = System.getenv("SAUCE_USERNAME");
		    String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");
			
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(CapabilityType.BROWSER_NAME, browserName);
	        caps.setCapability(CapabilityType.VERSION, browserVersion);
	        caps.setCapability(CapabilityType.PLATFORM_NAME, platformName);
	        caps.setCapability("username", sauceUserName);
	        caps.setCapability("accessKey", sauceAccessKey);
	        
			return new RemoteWebDriver(new URL("https://ondemand.saucelabs.com/wd/hub"), caps);
    }

    @Parameters({"browserName", "browserVersion", "platformName"})
    @BeforeMethod
    public void createDriver(String browserName, String browserVersion, String platformName ) throws MalformedURLException {
        driver = getWebDriver( browserName, browserVersion, platformName);
    }
    
    
    @Test
    public void verifyTitleTest() throws MalformedURLException, UnexpectedException {
 
    	driver.get("https://www.saucedemo.com/");
       
       Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Swag Labs"));
       
     }
    
    
    @Test
    public void verifyUserNameTest() throws MalformedURLException, UnexpectedException {

       driver.get("https://www.saucedemo.com/");
       
       Assert.assertTrue(driver.findElement(By.id("user-name")).isDisplayed());
       
     }
     
    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
 
        ((JavascriptExecutor)driver).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));

        driver.quit();
    	
    }

}