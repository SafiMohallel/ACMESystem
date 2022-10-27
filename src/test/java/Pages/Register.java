package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BaseClass;

public class Register extends BaseClass {

	public Register(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='btn bg-warning'][2]")
	private WebElement registerLink;

	public void registerLinkClick(WebDriverWait wait) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(registerLink));
		registerLink.click();
		Thread.sleep(200);
	}

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "password-confirm")
	private WebElement retypePassword;

	@FindBy(xpath = "//*[@class='btn btn-primary']")
	private WebElement registerButton;
	
	@FindBy(name = "checkTerms")
	private WebElement termsOfUseCheckBox;

	@FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
	private WebElement recaptchaCheckBox;
	
	public void setEmailData(String emailData) {
		email.clear();
		email.sendKeys(emailData);
	}

	public void setPasswordData(String passwordData) {
		password.clear();
		password.sendKeys(passwordData);
	}

	public void setRetypePasswordData(String emailData) {
		retypePassword.clear();
		retypePassword.sendKeys(emailData);
	}
	
	public boolean getRememberMeCheckBoxStatus() {
		return termsOfUseCheckBox.isSelected();
	}

	public void termsOfUseCheckBoxClick(WebDriverWait wait) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(termsOfUseCheckBox));
		termsOfUseCheckBox.click();
		Thread.sleep(200);
	}
	
	public void recaptchaCheckBoxClick(WebDriver driver) throws InterruptedException, IOException {
		//STILL NOT WORKING
		new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((By.cssSelector("iframe[title='reCAPTCHA']"))));
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((By.cssSelector( "div.recaptcha-checkbox-border")))).click();
	}
	
	public void registerButtonClick(WebDriverWait wait) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(registerButton));
		registerButton.click();
		Thread.sleep(200);
	}
}
