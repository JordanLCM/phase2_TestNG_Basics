package phase2_TestNG_Basics002;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class phase2_ExtentReportCreate003 {

	WebDriver driver;
	ExtentReports extent;
	ExtentTest test1;
	
	@BeforeTest
	@Parameters({ "browser" })
	public void defineDriver(String browser) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jordan Liu\\eclipse-workspace\\phase1_selenium_WD\\Chrome\\chromedriver.exe");

		phase2_ExtentReportGenerator002 reportG = new phase2_ExtentReportGenerator002();
		extent = reportG.createReport();
		extent.addSystemInfo("Link", "www.the777888.com");
		extent.addSystemInfo("Environment", "Staging");
		extent.addSystemInfo("Username", "Jordan Liu");
				
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@Test(dataProvider = "dataProviderMethod")
	public void loginMethod(String username, String password) throws InterruptedException {
		test1 = extent.startTest("TestNG implementation");
		
		WebElement user1 = driver.findElement(By.id("email"));
		WebElement pass1 = driver.findElement(By.id("passwd"));

		user1.clear();
		user1.sendKeys(username);
		pass1.clear();
		pass1.sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
		WebElement errorM = driver.findElement(By.xpath("//p[normalize-space()='There is 1 error']"));
		Boolean testR = errorM.getText().equalsIgnoreCase("There is 1 error");
		System.out.println(username + "---" + password);
		
		if(testR) {
			test1.log(LogStatus.PASS, "Error message is correct & same!");
		}
		else {
			test1.log(LogStatus.FAIL, "Error message is wrong & not matching!");
		}
		
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
		extent.endTest(test1);
		extent.flush();
		driver.quit();
	}
}
