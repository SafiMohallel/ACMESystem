package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.*;
import Utilities.PropertiesReader;
import io.cucumber.java.en.Given;

public class WorkItemsSteps {
	private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    WorkItems workItems;
    Login login;
    Dashboard dashboard;
    
    public WorkItemsSteps() throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }
    
    @Given("The user open the Work Items")
    public void the_user_open_the_work_items() throws InterruptedException {
    	dashboard = new Dashboard (driver, wait);
    	dashboard.worItemsClick();
    	workItems = new WorkItems (driver, wait);
    	

    }
    @Given("check that only {int} items of type {string} is presented")
    public void check_that_only_items_of_type_is_presented(Integer int1, String string) {
        int W13Count=0;

    	for (int i = 0 ; i<workItems.getTypesLenght();i++)
    	{
    		if (workItems.getTypeData(i).equals("WI3"))
    			W13Count++;
    	}
		Assert.assertEquals(4,W13Count);
		
		//Need check in pagination
    }
}