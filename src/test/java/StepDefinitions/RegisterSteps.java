package StepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.Register;
import Utilities.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {
	private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    Register register;
    
    public RegisterSteps() throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }
    
    @Given("The user open the registration page")
    public void the_user_open_the_registration_page() throws InterruptedException {
    	register = new Register(driver, wait);
    	register.registerLinkClick(wait);
    }
    
	 @When("The user enter a valid username in registration page {string}")
	 public void the_user_enter_a_valid_username_in_registration_page(String string) {
		   	register.setEmailData (string);
	 }
	 
	 @When("The user enter a valid password in registration page  {string}")
	 public void the_user_enter_a_valid_password_in_registration_page(String string) {
		 register.setPasswordData (string);
	 }
	 
	 @When("The user enter a valid retypepassword in registration page {string}")
	 public void the_user_enter_a_valid_retypepassword_in_registration_page(String string) {
	    	register.setRetypePasswordData (string);
	 }
    
    @When("The user check the captcha")
    public void the_user_check_the_captcha() throws InterruptedException, IOException {
    	register.recaptchaCheckBoxClick(driver);
    }
    
    @When("The user check the terms ofuse and privacy policy")
    public void the_user_check_the_terms_ofuse_and_privacy_policy() throws InterruptedException {
    	register.termsOfUseCheckBoxClick(wait);
    }

    @When("The user click on register button")
    public void the_user_click_on_register_button() throws InterruptedException {
    	register.registerButtonClick(wait);
    }
}
