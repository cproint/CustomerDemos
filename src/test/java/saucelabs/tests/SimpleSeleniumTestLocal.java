package saucelabs.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleSeleniumTestLocal {
    static WebDriver driver;

    public static void main(final String[] args) throws InterruptedException {

    	System.setProperty("webdriver.chrome.driver", "/Users/muralitulugu/Documents/ams/armada-test/Drivers/chromedriver");

        driver = new ChromeDriver();

        driver.get("https://www.google.com");
        
        //driver.findElement(By.id("SearchButton")).isDisplayed();
        
        System.out.println("Page Title:" + driver.getTitle());
        System.out.println("Page Title:" + driver.getTitle());
        System.out.println("Page Title:" + driver.getTitle());

        //System.out.println("Page Title:" + driver.getTitle());

        //System.out.println("Page Title:" + driver.getTitle());

        //System.out.println("Page Title:" + driver.getTitle());
        //System.out.println("Page Title:" + driver.getTitle());
        //System.out.println("Page Title:" + driver.getTitle());

        


        driver.quit();
    }
}

