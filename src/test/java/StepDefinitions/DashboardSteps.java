package StepDefinitions;

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
    Dashboard dashboard;
    
    public DashboardSteps() throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }
    
	@Given("The user open the dashboard page")
	public void the_user_open_the_dashboard_page() {
		dashboard = new Dashboard(driver, wait);
	}
	
	
	@Then("The label text should be is {string} and {string} plus {string} plus {string}")
	public void the_label_text_should_be_is_and_plus_plus(String string, String string2, String string3, String string4) {
	}
}
