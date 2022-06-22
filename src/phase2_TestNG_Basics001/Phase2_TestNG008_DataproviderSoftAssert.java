package phase2_TestNG_Basics001;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Phase2_TestNG008_DataproviderSoftAssert {

	WebDriver driver;

	@Test
	@Parameters({ "browser" })
	public void defineDriver(String browser) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jordan Liu\\eclipse-workspace\\phase1_selenium_WD\\Chrome\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@Test(dataProvider = "dataProviderMethod")
	public void loginMethod(String username, String password) throws InterruptedException {
		WebElement user1 = driver.findElement(By.id("email"));
		WebElement pass1 = driver.findElement(By.id("passwd"));

		user1.clear();
		user1.sendKeys(username);
		pass1.clear();
		pass1.sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
		WebElement errorM = driver.findElement(By.xpath("//p[normalize-space()='There is 1 error']"));
		System.out.println(username + "---" + password);
		//Continues even if error occurs!!
		SoftAssert softA = new SoftAssert();
		softA.assertEquals(errorM.getText(), "There is one error");
		softA.assertAll();
		Thread.sleep(2000);
	}

	@DataProvider
	public String[][] dataProviderMethod() {
		String loginD[][] = { { "jordan", "test" }, { "hello", "world" }, { "time", "dime" } };
		return loginD;
	}

	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
