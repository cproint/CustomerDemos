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
public class ForgotPasswordPage extends TestBase{
		
	/**CacheLookup: WebElement will be stored in cache memory for the subsequent calls rather than using Browser/DOM/css etc. 
	 * More useful when we use xpath etc. 
	 * Note that if the element is changed dynamically then it gives StaleElementException
	 */
	@FindBy(css = ".username.form__input")
	@CacheLookup
	private WebElement resetEmailTextBox;

	@FindBy(css = "button[type='submit']")
	@CacheLookup
	private WebElement resetButton;
	
	@FindBy(css = ".show-reset-modal")
	@CacheLookup
	private WebElement cancelResetLink;
	
	@FindBy(css = ".mt2.typ--error")
	@CacheLookup
	private WebElement errorMessageWithEmptyResetEmail;
	
	@FindBy(css = "div.mt2:nth-of-type(2)")
	@CacheLookup
	private WebElement emailSentConfirmationMessage;
	
	public ForgotPasswordPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean verifyResetEmailTextBoxIsDispayed() {
		return resetEmailTextBox.isDisplayed();
	}
	
	public boolean verifyResetEmailTextBoxIsEnabled() {
		return resetEmailTextBox.isEnabled();
	}
	
	public boolean verifyResetEmailTextBoxIsEmpty() {
		return resetEmailTextBox.getText().isEmpty();
	}

	public boolean verifyResetButtonIsDisplayed() {
		return resetButton.isDisplayed();
	}
	
	public boolean verifyResetButtonIsEnabled() {
		return resetButton.isEnabled();
	}
	
	public String verifyResetButtonText() {
		return resetButton.getText();
	}
	
	public boolean isForgotPasswordLinkDisplayed() {
		return cancelResetLink.isDisplayed();
	}
	
	public boolean isForgotPasswordLinkEnabled() {
		return cancelResetLink.isEnabled();
	}
	
	public String getErrorMessageWithEmptyResetEmail() {
		return errorMessageWithEmptyResetEmail.getText();
	}
	
	public String getEmailSentConfirmationMessage() {
		TestUtil.fluentWaitForElement(emailSentConfirmationMessage);
		return emailSentConfirmationMessage.getText();
	}
	
	public void clickResetButtonWithNoResetEmail() {
		resetButton.click();
	}

	public LoginPage clickResetButtonWithResetEmail() {
		resetEmailTextBox.sendKeys("test@ams.com");
		cancelResetLink.click();
		return new LoginPage();
	}
	
}