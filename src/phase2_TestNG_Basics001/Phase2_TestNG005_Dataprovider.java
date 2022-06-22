package phase2_TestNG_Basics001;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Phase2_TestNG005_Dataprovider {

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
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Driver = New Firefox Driver");
		}
		System.out.println("Done! " + methodlogy);
		driver.get("http://automationpractice.com");
		driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
	}

	@Test (dataProvider = "dataProviderMethod")
	public void loginMethod(String username, String password) throws InterruptedException {
		WebElement user1 = driver.findElement(By.id("email"));
		WebElement pass1 = driver.findElement(By.id("passwd"));

		user1.clear();
		user1.sendKeys(username);
		pass1.clear();
		pass1.sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(2000);
		System.out.println(username + "---" + password);
	}

	@DataProvider
	public String[][] dataProviderMethod() {
		String loginD[][] = {{"jordan", "test"}, {"hello", "world"}, {"time", "dime"}};
		return loginD;
	}

	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
