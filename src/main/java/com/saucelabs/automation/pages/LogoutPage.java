package com.saucelabs.automation.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.automation.base.TestBase;
import com.saucelabs.automation.util.TestUtil;

public class LogoutPage extends TestBase{
	
	@FindBy(css = ".login.p4.theme--light>form")
	private WebElement loginForm;

	@FindBy(css = ".username.form__input")
	private WebElement emailTextBox;

	@FindBy(css = ".password.form__input")
	private WebElement passwordTextBox;

	@FindBy(css = "button[type='submit']")
	private WebElement loginButton;

	@FindBy(css = ".show-reset-modal")
	private WebElement forgotPasswordLink;
	
	public LogoutPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions



	public boolean isLoginPageDisplayed() {

		if (TestUtil.isElementPresent(driver, loginForm) 
				&& TestUtil.isElementPresent(driver, emailTextBox) 
				&& TestUtil.isElementPresent(driver, passwordTextBox)
				&& TestUtil.isElementPresent(driver, loginButton) 
				&& TestUtil.isElementPresent(driver, forgotPasswordLink)) {
			return true;
		}
		return false;
	}

}
