package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BaseClass;

public class Account extends BaseClass {

	public Account(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "buttonRTD")
	private WebElement  resetTestDataButton;

	public void clicResetTestDataButton(WebDriverWait wait) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(resetTestDataButton));
		resetTestDataButton.click();
		Thread.sleep(500);
	}
	
	
	@FindBy(xpath = "//h1[@class='page-header']")
	private WebElement  resetTestDataPageHeader;

	public String getResetTestDataPageHeader() {
		return resetTestDataPageHeader.getText();
	}
	
	@FindBy(xpath = "//div[@id='loadingProgress']")
	private WebElement  loadingProgressDiv;

	public String getloadingProgressDivDispaly() {
		return loadingProgressDiv.getAttribute("style");
	}
}
