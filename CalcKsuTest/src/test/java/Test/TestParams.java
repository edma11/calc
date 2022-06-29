 package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestParams {

	protected static WebDriver driver;
	
	@BeforeTest
	public static void SetUp() {
		driver = new FirefoxDriver();
	}
	
	  @AfterTest
      public void afterTest() {
	// System.out.println("Closing the browser ");
		  driver.quit();
	}
	
	
	
		}

