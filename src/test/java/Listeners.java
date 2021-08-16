import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.ExtentReporterNG;
import common.TestBase;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends TestBase implements ITestListener {

    ExtentReports extentReport = ExtentReporterNG.getReportObject();
    ExtentTest test;
    ThreadLocal<ExtentTest> threadTesst = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {

        test = extentReport.createTest(result.getMethod().getMethodName());
        threadTesst.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        threadTesst.get().log(Status.PASS, "Test Passed");
        Logger log = null;
        try {
            log = (Logger) result.getTestClass().getRealClass().getField("log").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Test Case " + result.getMethod().getMethodName() + " PASSED successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        //getThrowable() returns failure logs
        threadTesst.get().fail(result.getThrowable());

        WebDriver driver = null;
        String testMethodName = result.getMethod().getMethodName();

        Logger log = null;
        try {
            log = (Logger) result.getTestClass().getRealClass().getField("log").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Test Case " + testMethodName + " FAILED");
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
//            threadTesst.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName, driver), result.getMethod().getMethodName());
            threadTesst.get().addScreenCaptureFromBase64String(getScreenshotPathBase64(testMethodName, driver),"Click above to see screenshot");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();
    }
}
