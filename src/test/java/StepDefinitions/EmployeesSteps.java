package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PropertiesReader;

public class EmployeesSteps {
	private WebDriver driver = Hooks.driver;
    private WebDriverWait wait = Hooks.wait;
    
	 public EmployeesSteps() throws Exception {
	        PropertiesReader propertiesReader = new PropertiesReader();
	        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
	    }
}
