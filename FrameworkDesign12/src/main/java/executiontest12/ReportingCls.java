package executiontest12;

import java.io.File;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportingCls {

	public static ExtentReports extent;
	
	public static ExtentReports GenerateReport() {

		String reportpath = System.getProperty("user.dir")+"\\reports\\ereport.html";
		
		String reportconfig = System.getProperty("user.dir")+"\\resources\\extentf-config.json";
		
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(reportpath);
		//Updating the default configuration of the report template
		
		/*sparkreporter.config().setDocumentTitle("QA Test Results");
		sparkreporter.config().setReportName("Sample Extent Report");
		sparkreporter.config().setCss(".badge-success{background-color: #19af24;}");*/
		
		try {
			sparkreporter.loadJSONConfig(new File(reportconfig));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent = new ExtentReports();
		
		extent.attachReporter(sparkreporter);
		
		extent.setSystemInfo("TeamName", "Quanton");
		extent.setSystemInfo("Team Lead", "Vijay");
		
		return extent;
		
	}
	
}
