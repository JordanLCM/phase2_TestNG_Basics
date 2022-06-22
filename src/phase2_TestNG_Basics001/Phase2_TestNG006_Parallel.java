package phase2_TestNG_Basics001;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Phase2_TestNG006_Parallel {

	WebDriver driver;

	@Test
	public void parallelMethod() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jordan Liu\\eclipse-workspace\\phase1_selenium_WD\\Chrome\\chromedriver.exe");

		driver = new ChromeDriver();
		Point a = driver.manage().window().getPosition();
		driver.manage().window().setPosition(a.moveBy(1500, 9)); 
		driver.manage().window().maximize();
		driver.get("http://www.youtube.com");
	}

	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
