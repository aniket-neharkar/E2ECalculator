package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG extends TestBase{

    static ExtentReports extentReport;

    public static ExtentReports getReportObject()
    {
        String path = System.getProperty("user.dir")+"\\extentReports\\report_"+getCurrentDateTime()+".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Calculator Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        reporter.config().setTheme(Theme.DARK);

        extentReport = new ExtentReports();
        extentReport.attachReporter(reporter);
        extentReport.setSystemInfo("Tester","Aniket");

        return extentReport;

    }

}
