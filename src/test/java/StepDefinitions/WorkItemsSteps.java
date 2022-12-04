package StepDefinitions;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.*;
import Utilities.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WorkItemsSteps {
	private WebDriver driver = Hooks.driver;
    private WebDriverWait wait = Hooks.wait;
    
    static Alert alert;
    WorkItems workItems;
    Login login;
    Dashboard dashboard;
    Account account;
    
    static String wIID,description,type,status,date;
    static int randomNumber;
    static String MainWindow,ChildWindow;
    
    public WorkItemsSteps() throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }
    
    @Given("The user open the Work Items")
    public void the_user_open_the_work_items() throws InterruptedException {
    	dashboard = new Dashboard (driver, wait);
    	dashboard.worItemsClick(wait);
    	workItems = new WorkItems (driver, wait);
    }
    
    @Given("check that only {int} items of type {string} is presented")
    public void check_that_only_items_of_type_is_presented(Integer int1, String string) throws InterruptedException {
        int W13Count=0;

		for (int pagesCounter = 0 ; pagesCounter<workItems.getpageNumberLenght()-1;pagesCounter++)
    	{
    		workItems.clickPgeNumberData(pagesCounter,wait);
    		for (int cellsCounter = 0 ; cellsCounter<workItems.getTypesLenght();cellsCounter++)
        	{
        		if (workItems.getTypeData(cellsCounter).equals("WI5"))
        			W13Count++;
        	}
    		Thread.sleep(200);
    	}
		Assert.assertEquals(17,W13Count);
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
    	workItems.clickSearchIcon(randomNumber,wait);
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
    public void user_click_on_button_update_work_item() throws InterruptedException {
    	workItems.clickUpdateWorkItemButton(wait);
    }
   
    @Then("A new windows pop Up with the header {string}")
    public void a_new_windows_pop_up_with_the_header(String string) {
    	 MainWindow=driver.getWindowHandle();						
         Set<String> stWindowHandles=driver.getWindowHandles();		
         Iterator<String> istWindowHandles=stWindowHandles.iterator();		
         		
         while(istWindowHandles.hasNext())			
         {		
             ChildWindow=istWindowHandles.next();			
             if(!MainWindow.equalsIgnoreCase(ChildWindow))			  		
                     driver.switchTo().window(ChildWindow);	 	
         }	
       	 Assert.assertEquals(driver.getTitle(), string); 
    }
    
    @Given("The User change the status of the item to rejected")
    public void the_user_change_the_status_of_the_item_to_rejected() throws InterruptedException {
    	workItems.clickDdlStatus(wait);
    	workItems.clickStausOptions(2,wait);//1 Open, 3 Completed , we should use 2 to Rejected
    }
        
    @When("The user click on Update Work Item")
    public void the_user_click_on_update_work_item() throws InterruptedException {
    	workItems.clickUpdateWorkItemInnerButton(wait);
    }
    
    @Then("An alert with following appears {string}")
    public void an_alert_with_following_appears(String string) {
    	WebDriverWait wait = new WebDriverWait(driver, 2);
    	wait.until(ExpectedConditions.alertIsPresent());
    	alert = driver.switchTo().alert();
      	Assert.assertEquals(alert.getText(), string); 
    	alert.accept();
    }
    
    @Given("The user add comment {string} and click again on Update Work Item")
    public void the_user_add_comment_and_click_again_on_update_work_item(String string) throws InterruptedException {
    	workItems.setComment(string);
    	workItems.clickUpdateWorkItemInnerButton(wait);
    }

    @Given("The user navigate back to work item table and check the status of random selected item")
    public void the_user_navigate_back_to_work_item_table_and_check_the_status_of_random_selected_item() {
    	driver.close();
    	driver.switchTo().window(MainWindow);
    	driver.navigate().back();
    	driver.navigate().refresh();
    }
    
    @Then("The item status is changed to {string}")
    public void the_item_status_is_changed_to(String string) {
    	status= workItems.getStatusData(randomNumber);
      	Assert.assertEquals(status, string); 
    }
    
    @Given("The user choose item  {string}")
    public void the_user_choose_item(String string) throws InterruptedException {
    	//The first Method 
    	randomNumber=-1;

    	for (int pagesCounter = 0 ; pagesCounter<workItems.getpageNumberLenght()-1;pagesCounter++)
    	{
    		workItems.clickPgeNumberData(pagesCounter,wait);

    		for (int cellsCounter = 0 ; cellsCounter<workItems.getTypesLenght();cellsCounter++)
        	{
        		if (workItems.getWIIDData(cellsCounter).equals(string))
        		{
        			randomNumber = cellsCounter;
        			break;
        		}
        	}
    		
    		Thread.sleep(200);
    		if (randomNumber !=-1)
    			break;
    	}
    	
    	wIID=description=type=status=date ="";
   	 
		if (randomNumber !=-1)
		{
	    	wIID= workItems.getWIIDData(randomNumber);
	    	description= workItems.getDescriptionData(randomNumber);
	    	type= workItems.getTypeData(randomNumber);
	    	status= workItems.getStatusData(randomNumber);
	    	date= workItems.getDateData(randomNumber);
	    	Thread.sleep(700);
		}
		else 
			Assert.assertFalse("-----------------------Since the element is not present hence marking the test case as FAIL !!!", randomNumber==-1);
    	
    	
    	/*The second method
		/////////////////////////////////////////////////////////
    	randomNumber=-1;

    	for (int pagesCounter = 0 ; pagesCounter<workItems.getpageNumberLenght()-1;pagesCounter++)
    	{
    	workItems.clickPgeNumberData(pagesCounter,wait);

    		for (int cellsCounter = 2 ; cellsCounter<=workItems.getTypesLenght()+1;cellsCounter++)
        	{
    			
        		if (workItems.getTypesLenght()>=cellsCounter && workItems.getWIIDSecondMethodData(driver,cellsCounter).equals(string))
        		{
        			randomNumber = cellsCounter-2;
        			break;
        		}
        	}
    		
    		Thread.sleep(200);
    		if (randomNumber !=-1)
    			break;
    	}
    	
    	wIID=description=type=status=date ="";
   	 
		if (randomNumber !=-1)
		{
	    	wIID= workItems.getWIIDSecondMethodData(driver,randomNumber);
	    	description= workItems.getDescriptionSecondMethodData(driver,randomNumber);
	    	type= workItems.getTypeSecondMethodData(driver,randomNumber);
	    	status= workItems.getStatusSecondMethodData(driver,randomNumber);
	    	date= workItems.getDateSecondMethodData(driver,randomNumber);
	    	Thread.sleep(700);
		}
		else 
			Assert.assertFalse("-----------------------Since the element is not present hence marking the test case as FAIL !!!", randomNumber==-1);
		/////////////////////////////////////////////////////////
		*/
    }
    
    @Given("The User change the status of the item to {string} and add comment and click on Update Work Item")
    public void the_user_change_the_status_of_the_item_to_and_add_comment_and_click_on_update_work_item(String string) throws InterruptedException {
    	workItems.clickDdlStatus(wait);
    	workItems.clickStausOptions(3,wait);//1 Open, 3 Completed , we should use 2 to Rejected
    	workItems.setComment(string);
    	workItems.clickUpdateWorkItemInnerButton(wait);
    }
    
    @Then("Then an alert with following appears {string}")
    public void then_an_alert_with_following_appears(String string) {
    	wait.until(ExpectedConditions.alertIsPresent());
    	alert = driver.switchTo().alert();
      	Assert.assertEquals(alert.getText(), string); 
    	alert.accept();
    }
    
    @Given("The user click on reset data")
    public void the_user_click_on_reset_data() throws InterruptedException {
    	workItems.clickHomeLink(wait);
    	dashboard.hooverUserOptionsButton(wait,driver);
    	dashboard.clickResetTestDataLink(wait);
    }
    
    @Then("{string} appear")
    public void appear(String string) {
    	account = new Account (driver, wait);
      	Assert.assertEquals(account.getResetTestDataPageHeader(), string); 
    }
    
    @When("The user click on Reset Test Data")
    public void the_user_click_on_reset_test_data() throws InterruptedException {
    	account.clicResetTestDataButton(wait);
    }
    
    @Then("Progress bar appear")
    public void progress_bar_appear() {
      	Assert.assertEquals("display: block;", account.getloadingProgressDivDispaly()); 
    }
    
    @Then("Alert with the following appear {string}")
    public void alert_with_the_following_appear(String string) {
    	wait.until(ExpectedConditions.alertIsPresent());
    	alert = driver.switchTo().alert();
      	Assert.assertEquals(alert.getText(), string);
    }
    
    @When("The user click OK")
    public void the_user_click_ok() {
    	alert.accept();
    }
    
    @Then("The alert disappear and the progress bar")
    public void the_alert_disappear_and_the_progress_bar() {
      	Assert.assertEquals("display: none;", account.getloadingProgressDivDispaly()); 
    }
    
    @Then("The data in Work item table is reseted")
    public void the_data_in_work_item_table_is_reseted() throws InterruptedException {
    	workItems.clickHomeLink(wait);
    	dashboard.worItemsClick(wait);

    	randomNumber=-1;

    	for (int pagesCounter = 0 ; pagesCounter<workItems.getpageNumberLenght()-1;pagesCounter++)
    	{
    		workItems.clickPgeNumberData(pagesCounter,wait);

    		for (int cellsCounter = 0 ; cellsCounter<workItems.getTypesLenght();cellsCounter++)
        	{
        		if (workItems.getWIIDData(cellsCounter).equals(wIID))
        		{
        			randomNumber = cellsCounter;
        			break;
        		}
        	}
    		
    		Thread.sleep(200);
    		if (randomNumber !=-1)
    			break;
    	}
		Assert.assertTrue("-----------------------Since the element is not present hence marking the test case as PASS !!!", randomNumber==-1);
    }
}
