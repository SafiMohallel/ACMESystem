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
}
