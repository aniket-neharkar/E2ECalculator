package common;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public Properties prop = new Properties();

    public WebDriver initializeDriver() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
        prop.load(fis);

        String browser = prop.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("mozilla")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else {
            System.out.println("Browser not compatible");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
        prop.load(fis);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
//        String destination = "F:\\Aniket\\Selenium\\Screenshots\\Calculator\\"+testCaseName+"_"+getCurrentDateTime()+".png";
        String destination = prop.getProperty("screenshotpath")+testCaseName+"_"+getCurrentDateTime()+".png";
        System.out.println(destination);
        FileUtils.copyFile(source,new File(destination));

        return destination;
    }

    public String getScreenshotPathBase64(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + testCaseName + "_" + getCurrentDateTime() + ".png";
        FileUtils.copyFile(source, new File(destination));
        byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(destination));
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    public static String getCurrentDateTime()
    {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss_SSS");

        return simpleDateFormat.format(date);
    }

}
