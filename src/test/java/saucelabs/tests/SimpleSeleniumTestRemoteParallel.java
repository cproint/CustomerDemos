package saucelabs.tests;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;

public class SimpleSeleniumTestRemoteParallel {
	
    public String buildTag = System.getenv("BUILD_TAG");

    public String sauceUserName = System.getenv("SAUCE_USERNAME");
    public String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");
 
    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    private ThreadLocal<String> sessionId = new ThreadLocal<String>();

    @DataProvider(name = "hardCodedBrowsers", parallel = true)
    public static Object[][] sauceBrowserDataProvider(Method testMethod) {
        return new Object[][]{
                new Object[]{"MicrosoftEdge", "14.14393", "Windows 10"},
                new Object[]{"internet explorer", "11.0", "Windows 7"},
                new Object[]{"safari", "10.0", "OS X 10.11"},
                new Object[]{"chrome", "latest", "OS X 10.10"},
                new Object[]{"MicrosoftEdge", "14.14393", "Windows 10"},
                new Object[]{"internet explorer", "11.0", "Windows 7"},
                new Object[]{"safari", "10.0", "OS X 10.11"}
        };
    }


    public WebDriver getWebDriver() {
        return webDriver.get();
    }

    public String getSessionId() {
        return sessionId.get();
    }

    protected void createDriver(String browser, String version, String os, String methodName, String tagName)
            throws MalformedURLException, UnexpectedException {
    	
      DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
        capabilities.setCapability(CapabilityType.VERSION, version);
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, os);
        capabilities.setCapability("name", methodName);
        capabilities.setCapability("tags", tagName);
 
        if (buildTag != null) {
            capabilities.setCapability("build", buildTag);            
        }

        // Launch remote browser and set it as the current thread
        webDriver.set(new RemoteWebDriver(
                new URL("https://" + sauceUserName + ":" + sauceAccessKey + "@ondemand.saucelabs.com:443/wd/hub"),
                capabilities));
    
        // set current sessionId
        String id = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
        sessionId.set(id);
              
        // Testing using Jenkins Plug-in       	 
            String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
            (((RemoteWebDriver) getWebDriver()).getSessionId().toString()), methodName.getClass().getName());
            System.out.println(message);
    }

    @Test(dataProvider = "hardCodedBrowsers", enabled = true)
    public void verifyTitleTest(String browser, String version, String os, Method method)
            throws MalformedURLException, UnexpectedException {

        //create webdriver session
        createDriver(browser, version, os, method.getName(), "SmokeTest");
        
        WebDriver driver = getWebDriver();

       driver.get("https://www.saucedemo.com/");
       
       Assert.assertTrue(getWebDriver().getTitle().equalsIgnoreCase("Swag Labs"));
       
     }
		
    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
 
        ((JavascriptExecutor)getWebDriver()).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));

    	getWebDriver().quit();
    	
    }

}