package phase2_TestNG_Basics002;

import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class phase2_ExtentReport001 {

	WebDriver driver;
	
	@Test
	public void extentReport() {
		ExtentReports extent1 = new ExtentReports
				("/Users/Jordan Liu/eclipse-workspace/phase2_TestNG_Basics/Reports/Report.html");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		
		extent1.addSystemInfo("Link", "www.the777888.com");
		extent1.addSystemInfo("Environment", "Staging");
		extent1.addSystemInfo("Username", "Jordan Liu");

		ExtentTest test1 = extent1.startTest("1st test");
		test1.assignCategory("1st Test");
		test1.log(LogStatus.PASS, "1st test result");
		test1.log(LogStatus.FAIL, "Failed", 
				test1.addScreenCapture("C:\\Users\\Jordan Liu\\eclipse-workspace\\phase2_TestNG_Basics\\Image\\App_IM_basketball.png"));
		test1.log(LogStatus.WARNING, "Warning");
		
		ExtentTest test2 = extent1.startTest("2nd test");
		test1.assignCategory("2nd Test");
		test2.log(LogStatus.ERROR, "Error");
		
		extent1.endTest(test1);
		extent1.flush();
	}
}
