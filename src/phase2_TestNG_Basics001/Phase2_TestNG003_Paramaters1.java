package phase2_TestNG_Basics001;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Phase2_TestNG003_Paramaters1 {
	
//	String browser = "chrome";
	
	@Test
	@Parameters({"browser", "name", "methodlogy"})
	public void defineDriver(String browser, String name, String methodlogy) {
		System.out.println("Parameter value = " + browser + name);
		if(browser.equalsIgnoreCase("chrome")) {
			System.out.println("Driver = New Chrome Driver");
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Driver = New Firefox Driver");
		}
		System.out.println("Done! " + methodlogy);
	}
}
