package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.Dashboard;
import Utilities.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps {
	private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    Dashboard dashboard= new Dashboard(driver, wait);;
    
    public DashboardSteps() throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }

	@Then("The label text should be {string} plus {string} plus {string}")
	public void the_label_text_should_be_plus_plus(String string, String string2, String string3) {
		 Assert.assertEquals(dashboard.getWelcomeWord().substring(0,dashboard.getWelcomeWord().indexOf(dashboard.getUserName())), string);
		 Assert.assertEquals(dashboard.getUserName(), string2);
		 Assert.assertEquals(dashboard.getWelcomeWord().substring((dashboard.getWelcomeWord().substring(0,dashboard.getWelcomeWord().indexOf(dashboard.getUserName())) + dashboard.getUserName()).length()), string3);
	}
	@Then("The system appear the button text {string}")
	public void the_system_appear_the_button_text(String string) {
	}
	
	@Then("The system appear First tool tip link {string}")
	public void the_system_appear_first_tool_tip_link(String string) {
	}
}
