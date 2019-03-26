package com.saucelabs.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
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
public class LoginPage extends TestBase {
	
	@FindBy(css = ".is-active")
	@CacheLookup
	private WebElement loginLink;

	@FindBy(css = ".login.p4.theme--light>form")
	@CacheLookup
	private WebElement loginForm;

	@FindBy(css = ".username.form__input")
	@CacheLookup
	private WebElement emailTextBox;

	@FindBy(css = ".password.form__input")
	@CacheLookup
	private WebElement passwordTextBox;

	@FindBy(css = "button[type='submit']")
	@CacheLookup
	private WebElement loginButton;

	@FindBy(css = ".show-reset-modal")
	@CacheLookup
	private WebElement forgotPasswordLink;

	@FindBy(css = "div.mt2.typ--error")
	@CacheLookup
	private WebElement invalidCredentialsErrorMessage;
	
	@FindBy(xpath = "//img[@alt,'Advanced Microgrid Solutions']")
	@CacheLookup
	private WebElement amsLogo;
	

	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	

	public String verifyLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyLoginEmailTextboxIsDisplayed(){
		return emailTextBox.isDisplayed();
	}
	
	public boolean verifyLoginEmailTextboxIsEnabled(){
		return emailTextBox.isEnabled();
	}
	
	public boolean verifyLoginEmailTextboxIsEmpty(){
		return emailTextBox.getText().isEmpty();
	}
		
	public boolean verifyLoginPasswordTextboxIsDisplayed(){
		return passwordTextBox.isDisplayed();
	}
	
	public boolean verifyLoginPasswordTextboxIsEnabled(){
		return passwordTextBox.isEnabled();
	}
	
	public boolean verifyLoginPasswordTextboxIsEmpty(){
		return passwordTextBox.getText().isEmpty();
	}
	
	public boolean verifyLoginButtonIsDisplayed(){
		return loginButton.isDisplayed();
	}
	
	public boolean verifyLoginButtonIsEnabled(){
		return loginButton.isEnabled();
	}
	
	public String verifyLoginButtonText(){
		return loginButton.getText();
	}
	
	public boolean verifyAMSLogoIsDisplayed(){
		return amsLogo.isDisplayed();
	}
	
	
	public boolean isForgotPasswordLinkDisplayed(){
		return forgotPasswordLink.isDisplayed();
	}
	
	public boolean isForgotPasswordLinkEnabled(){
		return forgotPasswordLink.isEnabled();
	}
	
	public boolean isInvalidCredentialsErrorMessageDisplayed() {

		if (TestUtil.isElementPresent(driver, invalidCredentialsErrorMessage)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @param email
	 * @param pwd
	 * @return
	 */
	public HomePage login (String email, String pwd){
		emailTextBox.sendKeys(email);
		passwordTextBox.sendKeys(pwd);
		//loginButton.click();
		//Using JavascriptExecutor to click login button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginButton);
		
		
		return new HomePage();
	}
	
	public ForgotPasswordPage clickForgotPasswordLink() throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", forgotPasswordLink);

		return new ForgotPasswordPage();
	}
	
	

}
