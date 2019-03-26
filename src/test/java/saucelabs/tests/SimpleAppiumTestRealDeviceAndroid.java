package saucelabs.tests;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.android.*;

public class SimpleAppiumTestRealDeviceAndroid {
	
	    
	static String URL= "https://us1.appium.testobject.com/wd/hub";

    public static void main(final String[] args) throws InterruptedException, MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("testobject_api_key", "CDAA401708C84754A27500099B762547");
        caps.setCapability("deviceName", "Google_Pixel_8_real_us");
        caps.setCapability("platformVersion", "9");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appiumVersion", "1.10.1");
        caps.setCapability("automationName", "UiAutomator2");

        AppiumDriver<MobileElement> driver = new AndroidDriver<>(new java.net.URL(URL), caps); 

         driver.get("https://www.cisco.com");
         System.out.println("Title: " + driver.getTitle());
        driver.quit();
    }
    

}

