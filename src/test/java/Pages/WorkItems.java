package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BaseClass;

public class WorkItems extends BaseClass{

	public WorkItems(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
        PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='page-numbers']")
	private List<WebElement> pageNumber;

	public void clickPgeNumberData(int index) throws InterruptedException {
		pageNumber.get(index).click();
		Thread.sleep(500);
	}
	
	public int getpageNumberLenght() {
		return pageNumber.size();
	}
	
	@FindBy(xpath = "//*[@class='table']/tbody/tr/td[2]")
	private List<WebElement> wIID;

	public String getWIIDData(int index) {
		return wIID.get(index).getText();
	}
	
	@FindBy(xpath = "//*[@class='table']/tbody/tr/td[3]")
	private List<WebElement> description;

	public String getDescriptionData(int index) {
		return description.get(index).getText();
	}
	
	@FindBy(xpath = "//*[@class='table']/tbody/tr/td[4]")
	private List<WebElement> type;

	public String getTypeData(int index) {
		return type.get(index).getText();
	}
	
	public int getTypesLenght() {
		return type.size();
	}
	
	@FindBy(xpath = "//*[@class='table']/tbody/tr/td[5]")
	private List<WebElement> status;

	public String getStatusData(int index) {
		return status.get(index).getText();
	}
	
	@FindBy(xpath = "//*[@class='table']/tbody/tr/td[6]")
	private List<WebElement> date;

	public String getDateData(int index) {
		return date.get(index).getText();
	}
	
	@FindBy(xpath = "//*[@class='table']/tbody/tr/td[1]/a[1]/button[1]/i[1]")
	private List<WebElement> searchIcon;

	public void clickSearchIcon(int index) throws InterruptedException {
		searchIcon.get(index).click();
		Thread.sleep(500);
	}
	
	@FindBy(xpath = "//*[@class='page-header']")
	private WebElement workItemsHeaderTitle;
	
	public String getWorkItemsHeaderTitleData() {
		return workItemsHeaderTitle.getText();
	}
	
	@FindBy(xpath = "//*[@class='panel-body']//div[2]//p[1]")
	private WebElement workItemDetailsString;
	
	public String getDetailWIIDData() {
		return workItemDetailsString.getText().substring(workItemDetailsString.getText().indexOf("WIID: ")+6,workItemDetailsString.getText().indexOf("Type: ")).trim();
	}
	
	public String getDetailTypeData() {
		return workItemDetailsString.getText().substring(workItemDetailsString.getText().indexOf("Type: ")+6,workItemDetailsString.getText().indexOf("Status: ")).trim();
	}
	
	public String getDetailStatusData() {
		return workItemDetailsString.getText().substring(workItemDetailsString.getText().indexOf("Status: ")+8,workItemDetailsString.getText().indexOf("Date: ")).trim();
	}
	
	public String getDetailDateData() {
		return workItemDetailsString.getText().substring(workItemDetailsString.getText().indexOf("Date: ")+6).trim();
	}
	
	@FindBy(xpath = "//*[@class='btn btn-default']")
	private WebElement  updateWorkItemButton;

	public void clickUpdateWorkItemButton() throws InterruptedException {
		updateWorkItemButton.click();
		Thread.sleep(500);
	}
	
	@FindBy(xpath = "//*[@class='btn dropdown-toggle bs-placeholder btn-default']")
	private WebElement  ddlStatus;

	public void clickDdlStatus() throws InterruptedException {
		ddlStatus.click();
		Thread.sleep(500);
	}
	
	@FindBy(xpath = "//*[@class='dropdown-menu inner']/li")
	private List<WebElement> stausOptions;

	public void clickStausOptions(int index) throws InterruptedException {
		stausOptions.get(index).click();
		Thread.sleep(500);
	}
	
	@FindBy(id = "newComment")
	private WebElement  txtComment;

	public void setComment(String comment){
		txtComment.sendKeys(comment);
	}
	
	@FindBy(id = "buttonUpdate")
	private WebElement  clickUpdateWorkItemInnerButton;

	public void clickUpdateWorkItemInnerButton() throws InterruptedException {
		clickUpdateWorkItemInnerButton.click();
		Thread.sleep(500);
	}
}
