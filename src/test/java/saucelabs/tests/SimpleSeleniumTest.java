package saucelabs.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleSeleniumTest {
    static WebDriver driver;

    public static void main(final String[] args) throws InterruptedException {

    	System.setProperty("webdriver.chrome.driver", "/Users/muralitulugu/Documents/ams/armada-test/Drivers/chromedriver");

        driver = new ChromeDriver();

        driver.get("http://www.newtours.demoaut.com/");
        
        System.out.println("Current URL: " + driver.getCurrentUrl());
        driver.findElement(By.linkText("your destination")).click();
        System.out.println("Current URL: " + driver.getCurrentUrl());


        driver.quit();
    }
}

