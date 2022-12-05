package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BaseClass;

public class Dashboard extends BaseClass{
	static Actions action;
	
	public Dashboard(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
        PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[normalize-space()='Work Items']")
	private WebElement workItems;

	public void worItemsClick (WebDriverWait wait) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(workItems));
		workItems.click();
		Thread.sleep(200);
	}
	
	@FindBy(xpath = "//*[@class='btn btn-default btn-lg dropdown-toggle'][1]")
	private WebElement  UserOptionsButton;
	
	@FindBy(xpath = "//a[normalize-space()='Reset test data']")
	private WebElement  ResetTestDataLink;
	
	public void hooverUserOptionsButton(WebDriverWait wait,WebDriver driver) throws InterruptedException {
		action = new Actions(driver);
		action.moveToElement(UserOptionsButton).perform();
		wait.until(ExpectedConditions.elementToBeClickable(UserOptionsButton));
	}
	
	public void clickResetTestDataLink(WebDriverWait wait) throws InterruptedException {
		action.moveToElement(ResetTestDataLink);
		wait.until(ExpectedConditions.elementToBeClickable(ResetTestDataLink));
		action.click().build().perform();
	}
	
	@FindBy(xpath = "//strong")
	private WebElement  userName;
	
	public String getUserName() {
		return userName.getText();
	}
	
	@FindBy(xpath = "(//h1)[2]")
	private WebElement  welcomeWord;
	
	public String getWelcomeWord() {
		return welcomeWord.getText();
	}
}
