package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.CustomerService;
import Pages.Dashboard;
import Pages.Employees;
import Pages.Login;
import Pages.WorkItems;
import Utilities.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps {
	private WebDriver driver = Hooks.driver;
	private WebDriverWait wait;
	Dashboard dashboard = new Dashboard(driver, wait);;
	static int buttonsCounter;
	
	public DashboardSteps() throws Exception {
		PropertiesReader propertiesReader = new PropertiesReader();
		this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
	}

	@Then("The label text should be {string} plus {string} plus {string}")
	public void the_label_text_should_be_plus_plus(String string, String string2, String string3) {
		Assert.assertEquals(
				dashboard.getWelcomeWord().substring(0, dashboard.getWelcomeWord().indexOf(dashboard.getUserName())),
				string);
		Assert.assertEquals(dashboard.getUserName(), string2);
		Assert.assertEquals(dashboard.getWelcomeWord()
				.substring((dashboard.getWelcomeWord().substring(0,
						dashboard.getWelcomeWord().indexOf(dashboard.getUserName())) + dashboard.getUserName())
						.length()),
				string3);
	}

	@Then("The system appear the button text {string}")
	public void the_system_appear_the_button_text(String string) throws InterruptedException {
		int correctLInks = 0;

		for (int mainLinksCounter = 0; mainLinksCounter < dashboard.getMainLinksLenght(); mainLinksCounter++) {
			if (string.equalsIgnoreCase(dashboard.getMainLinksData(mainLinksCounter, wait)))
				correctLInks++;
		}

		for (int mainButtonsCounter = 0; mainButtonsCounter < dashboard.getMainButtonsLenght(); mainButtonsCounter++) {
			if (string.equalsIgnoreCase(dashboard.getMainButtonsData(mainButtonsCounter, wait)))
				correctLInks++;
		}

		Assert.assertEquals(1, correctLInks);
	}

	@Then("The system appear First tool tip link {string} for the button {string}")
	public void the_system_appear_first_tool_tip_link_for_the_button(String string, String string2) throws InterruptedException {
		
		dashboard.hoverMainLinksData(0, wait,driver);
		dashboard.getToolTipLinksData(0, wait);
		
		//CONT. WORK FROM HERE
	}

	@When("The user clicks on the specific button {string}")
	public void the_user_clicks_on_the_specific_button(String string) throws InterruptedException {
		buttonsCounter = 0;
		for (int mainButtonsCounter = 0; mainButtonsCounter < dashboard.getMainButtonsLenght(); mainButtonsCounter++) {
			if (string.equalsIgnoreCase(dashboard.getMainButtonsData(mainButtonsCounter, wait))) {
				dashboard.clickMainButtonsData(mainButtonsCounter, wait);
				buttonsCounter = mainButtonsCounter;
				break;
			}
		}
	}

	@Then("The system redirect to a page with the title {string}")
	public void the_system_redirect_to_a_page_with_the_title( String string) {
		switch(buttonsCounter) {
		  case 0:
			  Assert.assertEquals(driver.getTitle(), string);
		    break;
		  case 1:
			  Assert.assertEquals(driver.getTitle(), string);
		    break;
		  case 2:
			  Assert.assertEquals(driver.getTitle(), string);
			 break;
		}
	}
	
	@When("The user clicks on the logout link")
	public void the_user_clicks_on_the_logout_link() {
		dashboard.clickLogOut();
	}
	
	@Then("The system sign out")
	public void the_system_sign_out() {
		driver.manage().deleteAllCookies();
		Assert.assertEquals(0, driver.manage().getCookies().size());
	}

	@Then("The system redirect to the login page  with the title {string}")
	public void the_system_redirect_to_the_login_page_with_the_title(String string) throws InterruptedException {
		Login login = new Login(driver, wait);
		Assert.assertEquals(driver.getTitle(), string);
	}
}
