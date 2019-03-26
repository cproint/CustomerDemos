package saucelabs.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HDSupplyWriteContentToLocalFile {
	
	  static RemoteWebDriver driver;
	  public static final String USERNAME = System.getenv("SAUCE_USERNAME");
	  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
	  	  
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	  static BufferedWriter writer;

	public static void main (String[] args) throws InterruptedException, IOException {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		
		chromeOptions.setCapability("version", "72");
		chromeOptions.setCapability("platform", "macOS 10.14");
		
		driver = new RemoteWebDriver(new java.net.URL(URL), chromeOptions);
		
		driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Selenium");

		
		driver.findElement(By.name("btnK")).click();
	
		String testResults = driver.findElement(By.cssSelector("div#resultStats")).getText();
		writeToFile(testResults);
		
	}
	
	
	public static void writeToFile(String resultStats) throws IOException {
		
		writer = new BufferedWriter(new FileWriter("/Users/muralitulugu/Documents/google.txt",true));
		writer.newLine();
		writer.write(resultStats);
		writer.flush();
	}

}
