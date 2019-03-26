package saucelabs.tests;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.URL;


public class SauceConnect {


  public static final String USERNAME = "sso-toyota.tcoe-phartheeb.kandasamy";

  public static final String ACCESS_KEY = "d18d6fe9-36ed-472d-8af6-9788f5aaac5d";

  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";


  public static void main(String[] args) throws Exception {


    DesiredCapabilities caps = DesiredCapabilities.chrome();

    caps.setCapability("name","Q360POC");

    caps.setCapability("platform", "Windows 10");

    caps.setCapability("version", "latest");

    //caps.setCapability("parentTunnel", "");

    //caps.setCapability("tunnel-identifier", "");


    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);


    /**

     * Goes to Sauce Lab's guinea-pig page and prints title

     */


    driver.get("https://saucelabs.com/test/guinea-pig");

    System.out.println("title of page is: " + driver.getTitle());


    driver.quit();

  }

}
