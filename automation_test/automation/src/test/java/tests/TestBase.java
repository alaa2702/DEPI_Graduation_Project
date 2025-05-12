package tests;

import data.LoadDriverProperties;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class TestBase {
	String browserName ;
	protected WebDriver driver;
	protected String baseURL;
	
	TestBase(){
		baseURL = LoadDriverProperties.driverData.getProperty("baseURL");
		browserName = LoadDriverProperties.driverData.getProperty("browserName");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
	}
	
    @BeforeTest
    public void openBrowser() {
    	long timeout = Long.parseLong(LoadDriverProperties.driverData.getProperty("timeout")); 
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    	driver.manage().window().maximize();
    	driver.navigate().to(baseURL);
    }

    @AfterTest
    public void closeBrowser() {
    	driver.quit();
    }

}
