package saucelabs.tests;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class SimpleAppiumTestRealDeviceiOS {
	
	    
	static String URL= "https://us1.appium.testobject.com/wd/hub";

    public static void main(final String[] args) throws InterruptedException, MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("testobject_api_key", "7094430DAFCC445FA35486EAE7692DCD");
        caps.setCapability("deviceName", "iPhone SE");
        caps.setCapability("platformVersion", "10.1");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appiumVersion", "1.10.1");

        AppiumDriver<MobileElement> driver = new IOSDriver<>(new java.net.URL(URL), caps); 


         driver.get("https://www.google.com");
         
         System.out.println("Title: " + driver.getTitle());


        driver.quit();
    }
    

}

