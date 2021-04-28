package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {
	public static WebDriver driver;

	@Before
	public void beforeScenario() {
		System.setProperty("webdriver.chrome.driver", "C:\\SDET-Shravya\\SDET\\chromedriver_win32\\chromedriver.exe");
		System.out.println("This will run before Scenario");
		driver = new ChromeDriver();

	}

	@After
	public void afterScenario() {
		System.out.println("This will run after Scenario");
		driver.quit();
	}

}
