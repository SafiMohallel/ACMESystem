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
	
	@FindBy(xpath = "//*[@class='table']/tbody/tr/td[4]")
	private List<WebElement> type;

	public String getTypeData(int index) {
		return type.get(index).getText();
	}
	
	public int getTypesLenght() {
		return type.size();
	}
	
	@FindBy(xpath = "//*[@class='page-numbers']")
	private List<WebElement> pageNumber;

	public void clickPgeNumberData(int index) throws InterruptedException {
		pageNumber.get(index).click();
		Thread.sleep(200);
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
	
	@FindBy(xpath = "//*[@class='table']/tbody/tr/td[1]/a/button")
	private List<WebElement> searchIcon;

	public void clickSearchIcon(int index) throws InterruptedException {
		searchIcon.get(index).click();
		Thread.sleep(200);
	}
}
