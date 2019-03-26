package saucelabs.tests;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SauceLabsBasic {

// enter your saucelabs user name here
public static final String USERNAME = "muralitulugu";

//enter your access key here
public static final String ACCESS_KEY = "a82b8eed-57dd-43f1-a10e-496ebdf2f3e8";
public static final String SauceLabsURL = "https://"+USERNAME + ":"+ ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
private WebDriver driver;

@Test(priority = 1, enabled=false)
public void test_Windows_Firefox() throws Exception {
	FirefoxOptions	options = new FirefoxOptions();
	options.setCapability("platform", "Windows 7");
	options.setCapability("version", "38");
	options.setCapability("name", "Testing on Firefox 38");
	this.driver = new RemoteWebDriver(new URL(SauceLabsURL), options);
	driver.get("https://app.saucelabs.com/login");
	Assert.assertEquals("Sauce Labs | Login", driver.getTitle());
	System.out.println("BrowserName :" + options.getBrowserName() + " – " + "Version : " + options.getVersion());
	System.out.println("————————————————————————————");
}

// ******* Note: On Sauce Labs  first 4 test would fail since driver.quit() not present and hence shows 
//Your test errored. Test did not see a new command for 90 seconds. Timing out
@Test(priority = 2, enabled=true)
public void test_Windows_IE() throws Exception {

	InternetExplorerOptions options = new InternetExplorerOptions();
	options.setCapability("platform", "Windows 8.1");
	options.setCapability("version", "11");
	options.setCapability("name", "Testing on IE 11");

	this.driver = new RemoteWebDriver(new URL(SauceLabsURL), options);
	//driver.get("https://app.saucelabs.com/login");
	driver.get("http://www.cleartheshelters.com");

	
	Assert.assertEquals("Clear the Shelters", driver.getTitle());
	System.out.println("BrowserName :" + options.getBrowserName() + " – " + "Version : " + options.getVersion());
	System.out.println("————————————————————————————");

}

@Test(priority = 3, enabled=false)
public void test_Windows_Chrome() throws Exception {

	DesiredCapabilities caps = DesiredCapabilities.chrome();
	caps.setCapability("platform", "Windows 10");
	caps.setCapability("version", "latest");
	caps.setCapability("name", "Testing on Chrome latest");
	
	this.driver = new RemoteWebDriver(new URL(SauceLabsURL), caps);
	driver.get("https://app.saucelabs.com/login");
	Assert.assertEquals("Sauce Labs | Login", driver.getTitle());
	System.out.println("BrowserName :" + caps.getBrowserName() + " – " + "Version : " + caps.getVersion());
	System.out.println("————————————————————————————");

}

@Test(priority = 4, enabled=false)
public void test_Mac_Safari() throws Exception {

	DesiredCapabilities caps = DesiredCapabilities.safari();
	caps.setCapability("platform", "macOS 10.13");
	caps.setCapability("version", "11.1");
	caps.setCapability("name", "Testing on Safari");
	
	this.driver = new RemoteWebDriver(new URL(SauceLabsURL), caps);
	driver.get("https://app.saucelabs.com/login");
	Assert.assertEquals("Sauce Labs | Login", driver.getTitle());
	System.out.println("BrowserName :" + caps.getBrowserName() + " – "+ "Version : " + caps.getVersion());
	System.out.println("————————————————————————————");

}

@Test(priority = 5, enabled=false)
public void test_Linux_Firefox() throws Exception {

	FirefoxOptions options = new FirefoxOptions();
	options.setCapability("platform", "Linux");
	options.setCapability("version", "latest-1");
	options.setCapability("name", "Testing on Linux firefox");
	
	this.driver = new RemoteWebDriver(new URL(SauceLabsURL), options);
	driver.get("https://app.saucelabs.com/login");
	Assert.assertEquals("Sauce Labs | Login", driver.getTitle());
	System.out.println("BrowserName :" + options.getBrowserName() + " – "+ "Version : " + options.getVersion());
	System.out.println("————————————————————————————");

}

@AfterTest
public void tearDown() throws Exception {
driver.quit();
System.out.println("driver was closed");
}
}
