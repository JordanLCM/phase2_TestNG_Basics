package phase2_TestNG_Basics003;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Phase2_GridExecution {
	WebDriver driver;
	URL url;
	DesiredCapabilities capab;
	
	@BeforeTest
	public void executeOnGrid() throws MalformedURLException {

		capab = new DesiredCapabilities();
		capab.setBrowserName("chrome");
		url = new URL("http://192.168.88.141:4444/wd/hub");
		driver = new RemoteWebDriver(url, capab);

		driver.get("https://www.youtube.com/");
	}

	@Test
	public void performSomeActs() {
		driver.findElement(By.xpath("//div[@id='start']//yt-icon[@id='guide-icon']")).click();
		driver.findElement(By.xpath("//ytd-mini-guide-entry-renderer[@aria-label='Explore']//yt-icon[@id='icon']")).click();
		driver.findElement(By.xpath("//ytd-destination-button-renderer[1]//a[1]")).click();
	}
	
	@AfterTest
	public void closeWindows() {
		driver.quit();
	}
}
