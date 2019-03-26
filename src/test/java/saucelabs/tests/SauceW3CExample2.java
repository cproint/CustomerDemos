package saucelabs.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceW3CExample2 {

    private WebDriver driver;

    /**
     * Parameters used here represent options for W3C compliant
     * browsers (Chrome is currently not compliant)
     * @return
     */
    @DataProvider(parallel = true)
    public static Object[][] data() {
     return new Object[][] {
             //{new ChromeOptions()},
         	 {new ChromeOptions(), "latest", "Windows 10"},
             {new FirefoxOptions(), "latest", "Windows 10"},
             {new FirefoxOptions(), "latest", "macOS 10.13"},
             {new InternetExplorerOptions(), "latest", "Windows 10"},
             {new EdgeOptions(), "latest", "Windows 10"},
             {new SafariOptions(), "latest", "macOS 10.13"}
        };
    }

    /**
     * Utility function that makes use of W3C Options classes.
     *
     * @param options
     * @param browserVersion
     * @param platformName
     * @throws MalformedURLException
     */
    public void createDriverOptions(MutableCapabilities options, String browserVersion, String platformName) throws MalformedURLException{
        String userName = System.getenv("SAUCE_USERNAME");
        String accessKey = System.getenv("SAUCE_ACCESS_KEY");

        options.setCapability("browserVersion", browserVersion);
        options.setCapability("platformName", platformName);

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", userName);
        sauceOptions.setCapability("accesskey", accessKey);
        sauceOptions.setCapability("seleniumVersion", "3.141.59");
        sauceOptions.setCapability("recordVideo", "false");

        sauceOptions.setCapability("name", options.getBrowserName().toLowerCase()+"-"+options.getPlatform());
        sauceOptions.setCapability("build", "Cisco");
        if (options.getBrowserName().toLowerCase().contains("chrome")) {        	
            ChromeOptions chromeOpts = new ChromeOptions();
            chromeOpts.setExperimentalOption("w3c", true);
            sauceOptions.setCapability(ChromeOptions.CAPABILITY,  chromeOpts);
        }
        options.setCapability("sauce:options", sauceOptions);

        driver = new RemoteWebDriver(new URL("https://ondemand.saucelabs.com/wd/hub"), options);
    }

    @AfterMethod
    public void teardown(ITestResult result){
        driver.quit();
    }

    @Test(dataProvider = "data")
    public void simpleCase(MutableCapabilities options, String browserVersion, String platformName) throws MalformedURLException {
        this.createDriverOptions(options, browserVersion, platformName);

        driver.get("https://www.saucedemo.com");
        
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (driver.getTitle().equalsIgnoreCase("Swag Labs") ? "passed" : "failed"));


    }
}

