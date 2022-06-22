package phase2_TestNG_Basics001;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Phase2_TestNG006_Parallel {

	WebDriver driver;
	URL url;
	DesiredCapabilities capab;

	@Test
	public void parallelMethod() throws MalformedURLException {

		capab = new DesiredCapabilities();
		capab.setBrowserName("firefox");
		url = new URL("http://192.168.88.211:4444/wd/hub");
		driver = new RemoteWebDriver(url, capab);
		
		Point a = driver.manage().window().getPosition();
		driver.manage().window().setPosition(a.moveBy(1500, 9)); 
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
	}

	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
