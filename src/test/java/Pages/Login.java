package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	public void loginButtonClick() {
		loginButton.click();
	}
}

