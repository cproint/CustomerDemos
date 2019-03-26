package com.saucelabs.automation.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.automation.base.TestBase;
import com.saucelabs.automation.util.TestUtil;

public class AddUserPage extends TestBase {
	
// Watch Video 4 (Time 27:10) https://www.youtube.com/watch?v=H2-3w-GQZ3g for creating users in User Management Page
	//
	@FindBy(css = "div[class='user-edit-row']:nth-of-type(1)> .typ--dark")
	private WebElement userName;

	@FindBy(css = "div[class='user-edit-row']:nth-of-type(2)> .typ--dark")
	private WebElement email;

	@FindBy(css = "div[class='user-edit-row']:nth-of-type(3)> .typ--dark")
	private WebElement title;

	@FindBy(css = "div[class='user-edit-row']:nth-of-type(4)> .typ--dark")
	private WebElement password;
	
	@FindBy(css = "div[class='user-edit-row']:nth-of-type(5)> .typ--dark")
	private WebElement demo;

	@FindBy(css = "div[class='user-edit-row']:nth-of-type(6)> .typ--dark")
	private WebElement admin;

	@FindBy(css = "div[class='user-edit-row']:nth-of-type(8)> .typ--dark")
	private WebElement sitesLabel;

	@FindBy(css = "div:nth-of-type(1) > .user-input")
	private WebElement userNameTextBox;

	@FindBy(css = "div:nth-of-type(1) > .user-input")
	private WebElement emailTextBox;

	@FindBy(css = "div:nth-of-type(1) > .user-input")
	private WebElement titleTextBox;

	@FindBy(css = "div:nth-of-type(1) > .user-input")
	private WebElement passwordTextBox;

	@FindBy(css = "div:nth-of-type(5)>span:nth-of-type(2) > input")
	private WebElement canAdministerUserCheckbox;

	@FindBy(css = "div:nth-of-type(8)>span:nth-of-type(2) > input")
	private WebElement canAccessAllServiceAccountsCheckbox;

	@FindBy(css = ".btn")
	private WebElement createButton;

	@FindBy(css = "a:nth-of-type(1) > .typ--dark")
	private WebElement closeAddUserWindowIcon;

	@FindBy(css = ".typ--bold")
	private WebElement logoutLink;
	
	@FindBy(css = "button[type='submit']")
	private WebElement loginButton;
	
	public AddUserPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions

	public boolean isUserNameDisplayed() {

		if (TestUtil.isElementPresent(driver, userName)) {
			return true;
		}
		return false;
	}

	public boolean isEmailDisplayed() {

		if (TestUtil.isElementPresent(driver, email)) {
			return true;
		}
		return false;
	}

	public boolean isTitleDisplayed() {

		if (TestUtil.isElementPresent(driver, title)) {
			return true;
		}
		return false;
	}

	public boolean isPasswordDisplayed() {

		if (TestUtil.isElementPresent(driver, password)) {
			return true;
		}
		return false;
	}

	public boolean isAdminDisplayed() {

		if (TestUtil.isElementPresent(driver, admin)) {

			return true;
		}
		return false;
	}

	public boolean isSitesLabelDisplayed() {

		if (TestUtil.isElementPresent(driver, sitesLabel)) {

			return true;
		}
		return false;
	}

	public boolean isUserNameTextBoxDisplayed() {

		if (TestUtil.isElementPresent(driver, userNameTextBox)) {

			return true;
		}
		return false;
	}

	public boolean isEmailTextBoxDisplayed() {

		if (TestUtil.isElementPresent(driver, emailTextBox)) {

			return true;
		}
		return false;
	}

	public boolean isCanAdministerUserCheckboxDisplayed() {

		if (TestUtil.isElementPresent(driver, canAdministerUserCheckbox)) {

			return true;
		}
		return false;
	}

	public boolean isPasswordTextBoxDisplayed() {

		if (TestUtil.isElementPresent(driver, passwordTextBox)) {

			return true;
		}
		return false;
	}

	public boolean isCanAccessAllServiceAccountsCheckboxDisplayed() {

		if (TestUtil.isElementPresent(driver, canAccessAllServiceAccountsCheckbox)) {

			return true;
		}
		return false;
	}

	public boolean isCreateButtonDisplayed() {

		if (TestUtil.isElementPresent(driver, createButton)) {

			return true;
		}
		return false;
	}

	public boolean isCloseAddUserWindowIconDisplayed() {

		if (TestUtil.isElementPresent(driver, closeAddUserWindowIcon)) {

			return true;
		}
		return false;
	}

/*	//TODO
	public void clickCreateNewUser(){
		
		userNameTextBoxIsDisplayed.sendKeys("Test User");
		emailTextBoxIsDisplayed.sendKeys("testuser"+Math.random()+"@test.com");
	}
*/	

}
