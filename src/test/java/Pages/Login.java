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
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//*[@class='invalid-feedback']/strong")
	private WebElement alertLabel;
	
	public void userNameSetData(String userNameData) {
		userName.clear();
		userName.sendKeys(userNameData);
	}

	public void PasswordSetData(String passwordData) {
		password.clear();
		password.sendKeys(passwordData);
	}

	public String alretGetData() {
		return alertLabel.getText();
	}

	public void loginButtonClick() {
		loginButton.click();
	}
}

