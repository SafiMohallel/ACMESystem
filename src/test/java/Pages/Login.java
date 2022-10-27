package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BaseClass;

public class Login extends BaseClass {

	 public Login(WebDriver driver, WebDriverWait wait) {
	        super(driver, wait);
	        PageFactory.initElements(driver, this);
	    }
	 
	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//*[@class='invalid-feedback']/strong")
	private WebElement alertLabel;
	
	@FindBy(xpath = "//*[@Class='form-check-input']")
	private WebElement rememberMeCheckBox;
	
	@FindBy(xpath = "//p[1]")
	private WebElement copyrightText;
	
	public void setEmailData(String emailData) {
		email.clear();
		email.sendKeys(emailData);
	}

	public void setPasswordData(String passwordData) {
		password.clear();
		password.sendKeys(passwordData);
	}

	public String getAlretData() {
		return alertLabel.getText();
	}

	public String getEmailTooltipData() {
		return email.getAttribute("validationMessage");
	}
	
	public boolean getRememberMeCheckBoxStatus() {
		return rememberMeCheckBox.isSelected();
	}
	
	public void rememberMeCheckBoxClick(WebDriverWait wait) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckBox));
		rememberMeCheckBox.click();
		Thread.sleep(200);
	}
	
	public String getCopyrightText(){
		return copyrightText.getText();
	}
	
	public void loginButtonClick(WebDriverWait wait) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
		Thread.sleep(200);
	}
}

