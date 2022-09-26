package StepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.Login;
import Utilities.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps  {
	private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    Login login;
    
    public LoginSteps() throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }
	
	
	 @Given("The user open the login page")
	 public void the_user_open_the_login_page() {
		 login = new Login(driver, wait);
	 }
	 
	 @Then("The page title should be is {string}")
	 public void the_page_title_should_be_is(String string) {
		 Assert.assertEquals(driver.getTitle(), "Erwaaaa");
	 }
	 
	 @When("The user enter an email not registered before {string}")
	 public void the_user_enter_an_email_not_registered_before(String string) {
		 login.userNameSetData ("s.mahallel99999@gmail.com");

	 }
	 @When("The user enter an invalid password {string}")
	 public void the_user_enter_an_invalid_password(String string) {
		 login.PasswordSetData ("0123456");

	 }
	 @Then("The system appear an error message {string}")
	 public void the_system_appear_an_error_message(String string) {
		 login.loginButtonClick();
	 }
}
