package phase2_TestNG_Basics001;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Phase2_TestNG004_Paramaters2 {

	WebDriver driver;

	@Test
	@Parameters({ "browser", "name", "methodlogy" })
	public void defineDriver(String browser, String name, String methodlogy) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jordan Liu\\eclipse-workspace\\phase1_selenium_WD\\Chrome\\chromedriver.exe");

		System.out.println("Parameter value = " + browser + name);
		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Driver = New Chrome Driver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://wl004.9re1iv30n1y.xyz");
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Driver = New Firefox Driver");
		}
		System.out.println("Done! " + methodlogy);
	}

	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
