package StepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PropertiesReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before()
    public void openBrowser() throws Exception {

		if (PropertiesReader.getValue("browser").equalsIgnoreCase("chrome")) {
		    WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (PropertiesReader.getValue("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
        PropertiesReader propertiesReader = new PropertiesReader();
        driver.manage().timeouts().implicitlyWait(propertiesReader.getTimeout(), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(propertiesReader.getTimeout(), TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(PropertiesReader.getValue("url"));
        wait = new WebDriverWait(driver,30);
    }

    @After
	public void takeScreenShotOnFailure(Scenario scenario) throws IOException { 
		if (scenario.isFailed()) {
            
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","");
        }

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
