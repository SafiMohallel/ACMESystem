package StepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.Dashboard;
import Pages.Register;
import Utilities.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {
	private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    Register register;
    Dashboard dashboard;
    
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
    	register.recaptchaCheckBoxClick(driver,wait);
    	Thread.sleep(5000);
    }
    
    @When("The user check the terms ofuse and privacy policy")
    public void the_user_check_the_terms_ofuse_and_privacy_policy() throws InterruptedException {
    	register.termsOfUseCheckBoxClick(wait);
    }

    @When("The user click on register button")
    public void the_user_click_on_register_button() throws InterruptedException {
    	//Thread.sleep(5000);
    	register.registerButtonClick(driver,wait);
    }
    
    @When("The user does not enter any data")
    public void the_user_does_not_enter_any_data() {
    	register.setEmailData ("");
		register.setPasswordData ("");
	    register.setRetypePasswordData ("");
    }
    
    @Then("The label text should be is {string}")
    public void the_label_text_should_be_is(String string) {
		 Assert.assertEquals(register.getEmailLabel(), "Email:");
		 Assert.assertEquals(register.getPasswordLabel(), "Password:");
		 Assert.assertEquals(register.getReTpePasswordLabel(), "Retype Password:");
		 Assert.assertEquals(register.getTermsOfUseAndPrivacyPolicyLabelLabel(), "I agree to the updated Terms of Use and Privacy Policy.");
		 Assert.assertEquals(register.getRegisterQuestionnaireLabel(), "Register by filling the below questionnaire.");
		 Assert.assertEquals(register.getRegisterHeaderLabel(), "Register");
    }

    @Then("The terms ofuse and privacy polic check box is unchecked")
    public void the_terms_ofuse_and_privacy_polic_check_box_is_unchecked() {
		 Assert.assertEquals(register.getRememberMeCheckBoxStatus(), false);
    }
    
    @Then("The captcha check box is unchecked")
    public void the_captcha_check_box_is_unchecked() {
		 Assert.assertEquals(register.getRecaptchaheckBoxStatus(driver), false);
    }

    @When("The user uncheck the captcha")
    public void the_user_uncheck_the_captcha() throws InterruptedException, IOException {
    	if(register.getRecaptchaheckBoxStatus(driver))
        	register.recaptchaCheckBoxClick(driver,wait);
    }
    
    @Then("The system appear an error message in registration page under captcha {string}")
    public void the_system_appear_an_error_message_in_registration_page_under_captcha(String string) {
		Assert.assertEquals(register.getErrorMessageLabel(), string);
    }
    
    @When("The user enter a valid email exists before {string}")
    public void the_user_enter_a_valid_email_exists_before(String string) {
    	register.setEmailData (string);
    }

    @Then("The system appear an error message in registration page under email {string}")
    public void the_system_appear_an_error_message_in_registration_page_under_email(String string) {
		Assert.assertEquals(register.getErrorMessageLabel(), string);
    }
    
    @Then("The system appear an error message in registration page under password {string}")
    public void the_system_appear_an_error_message_in_registration_page_under_password(String string) {
		Assert.assertEquals(register.getErrorMessageLabel(), string);
    }
    
    @When("The user enter an invalid Email {string}")
    public void the_user_enter_an_invalid_email(String string) {
    	//WORK HERE NOW !!
    }
}
