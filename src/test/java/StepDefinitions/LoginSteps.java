package StepDefinitions;


import java.util.Calendar;
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
		 Assert.assertEquals(driver.getTitle(), string);
	 }
	 
	 @When("The user enter an email not registered before {string}")
	 public void the_user_enter_an_email_not_registered_before(String string) {
		 login.setEmailData (string);

	 }
	 @When("The user enter an invalid password {string}")
	 public void the_user_enter_an_invalid_password(String string) {
		 login.setPasswordData (string);

	 }
	 @Then("The system appear an error message {string}")
	 public void the_system_appear_an_error_message(String string) throws InterruptedException {
		 login.loginButtonClick();
		 Assert.assertEquals( login.getAlretData(), string);
	 }

	 @When("The user enter empty value in email field {string}")
	 public void the_user_enter_empty_value_in_email_field(String string) {
		 login.setEmailData (string);
	 }
	 
	 @Then("The system appear an error email tooltip {string}")
	 public void the_system_appear_an_error_tooltip(String string) throws InterruptedException {
		 login.loginButtonClick();
		 Assert.assertEquals( login.getEmailTooltipData(), string);
	 }
	 
	 @Then("The remember me  check box is unchecked")
	 public void the_remember_me_check_box_is_unchecked() {
		 Assert.assertEquals(login.getRememberMeCheckBoxStatus(), false);
	 }
	 
	 @Then("The Copyright year should be {string}+the actual year +{string}")
	 public void the_copyright_year_should_be_the_actual_year(String string, String string2) {
		 Assert.assertEquals(login.getCopyrightText().substring(0, login.getCopyrightText().indexOf("©")+2), string);
		 Assert.assertEquals(login.getCopyrightText().substring(login.getCopyrightText().indexOf("©")+2,login.getCopyrightText().indexOf("©")+6),Calendar.getInstance().get(Calendar.YEAR)+"");
		 Assert.assertEquals(login.getCopyrightText().substring(login.getCopyrightText().indexOf("©")+6), string2);
	 }
}
