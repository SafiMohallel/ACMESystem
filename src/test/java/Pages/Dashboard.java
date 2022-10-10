package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BaseClass;

public class Dashboard extends BaseClass{
	
	public Dashboard(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
        PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[normalize-space()='Work Items']")
	private WebElement workItems;

	public void worItemsClick() throws InterruptedException {
		workItems.click();
		Thread.sleep(200);
	}
	
}
