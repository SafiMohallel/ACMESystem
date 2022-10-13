package StepDefinitions;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.*;
import Utilities.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WorkItemsSteps {
	private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    WorkItems workItems;
    Login login;
    Dashboard dashboard;
    static String wIID,description,type,status,date;
    static int randomNumber;
	
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
    public void check_that_only_items_of_type_is_presented(Integer int1, String string) throws InterruptedException {
        int W13Count=0;

		for (int pagesCounter = 0 ; pagesCounter<workItems.getpageNumberLenght()-1;pagesCounter++)
    	{
    		workItems.clickPgeNumberData(pagesCounter);
    		for (int cellsCounter = 0 ; cellsCounter<workItems.getTypesLenght();cellsCounter++)
        	{
        		if (workItems.getTypeData(cellsCounter).equals("WI3"))
        			W13Count++;
        	}
    		Thread.sleep(200);
    	}
		Assert.assertEquals(4,W13Count);
    }

    @Given("Choose a random item and save the data of random item")
    public void choose_a_random_item_and_save_the_data_of_random_item() throws InterruptedException {
    	Random random = new Random();
    	randomNumber=random.nextInt(10);

    	wIID=description=type=status=date ="";
    	 
    	wIID= workItems.getWIIDData(randomNumber);
    	description= workItems.getDescriptionData(randomNumber);
    	type= workItems.getTypeData(randomNumber);
    	status= workItems.getStatusData(randomNumber);
    	date= workItems.getDateData(randomNumber);
    	Thread.sleep(700);
    }
    
    @When("Click symbol search")
    public void click_symbol_search() throws InterruptedException {
    	Thread.sleep(300);
    	workItems.clickSearchIcon(randomNumber);
    }
    
    @Then("Work Item details appear with the header {string}")
    public void work_item_details_appear_with_the_header(String string) {
    	Assert.assertEquals(workItems.getWorkItemsHeaderTitleData(), string); 
    }

    @Then("The url contain the the WIID of the seleced random item")
    public void the_url_contain_the_the_wiid_of_the_seleced_random_item() {
    	Assert.assertEquals(driver.getCurrentUrl().substring(driver.getCurrentUrl().lastIndexOf("/")+1).trim(), wIID); 
    }
    
    @Then("Under Work Item Details section shows the right data \\(WIID_Type_Status_Date) of selected random item")
    public void under_work_item_details_section_shows_the_right_data_wiid_type_status_date_of_selected_random_item() throws InterruptedException {
    	Thread.sleep(300);
    	Assert.assertEquals(workItems.getDetailWIIDData(), wIID); 
    	Assert.assertEquals(workItems.getDetailTypeData(), description); 
    	Assert.assertEquals(workItems.getDetailStatusData(), status); 
    	Assert.assertEquals(workItems.getDetailDateData(), date); 
    }
    
    @When("User click on button Update Work Item")
    public void user_click_on_button_update_work_item() {
    }
    
    @Then("A new windows pop Up")
    public void a_new_windows_pop_up() {
    }
    @Given("The User change the status of the item to rejected")
    public void the_user_change_the_status_of_the_item_to_rejected() {
    }
    
    @When("The user click on Update Work Item")
    public void the_user_click_on_update_work_item() {
    }
    
    @Then("Then an alert with following appears {string}")
    public void then_an_alert_with_following_appears(String string) {
    }
    
    @Given("The user add comment and click again on Update Work Item")
    public void the_user_add_comment_and_click_again_on_update_work_item() {
    }
    
    @Given("The user navigate back to work item table and check the status of random selected item")
    public void the_user_navigate_back_to_work_item_table_and_check_the_status_of_random_selected_item() {
    }
    
    @Then("The item status is changed to {string}")
    public void the_item_status_is_changed_to(String string) {
    }
}
