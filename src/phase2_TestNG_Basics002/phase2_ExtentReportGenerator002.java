package phase2_TestNG_Basics002;

import com.relevantcodes.extentreports.ExtentReports;

public class phase2_ExtentReportGenerator002 {

	ExtentReports extent;
	
	public ExtentReports createReport() {
		extent = new ExtentReports
				("\\Users\\Jordan Liu\\eclipse-workspace\\phase2_TestNG_Basics\\Reports\\Report.html");
		return extent;
	}
}
