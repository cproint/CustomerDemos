package com.saucelabs.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.automation.base.TestBase;
import com.saucelabs.automation.util.TestUtil;

/**
 * @author mtulugu
 *
 */
public class HomePage extends TestBase{
		
	@FindBy(xpath = "//a[contains(@data-test,'home')]")
	@CacheLookup		//homePageLink will be stored in cache memory for the subsequent calls rather than using Browser/DOM/css etc. More useful when we use xpath etc. Note that if the element is changed dynamically then it gices StaleElementException
	private WebElement homePageLink;

	@FindBy(xpath = "//a[contains(@data-test,'sign-in')]")
	@CacheLookup		//signInLink will be stored in cache memory for the subsequent calls rather than using Browser/DOM/css etc. More useful when we use xpath etc. Note that if the element is changed dynamically then it gices StaleElementException
	private WebElement signInLink;

	@FindBy(css = "h1")
	@CacheLookup
	private WebElement welcomeToAddressBookHeader;

	@FindBy(css = "h4")
	@CacheLookup
	private WebElement addressBookDescriptionHeader;


	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean isHomePageLinkDisplayed(){
		return homePageLink.isDisplayed();
	}
	
	public boolean isSignInLinkDispayed(){
		return signInLink.isDisplayed();
	}
	
	public boolean isWelcomeToAddressBookHeaderDisplayed(){
		return welcomeToAddressBookHeader.isDisplayed();
	}
	
	public boolean isAddressBookDescriptionHeaderDispayed(){
		return addressBookDescriptionHeader.isDisplayed();
	}
}