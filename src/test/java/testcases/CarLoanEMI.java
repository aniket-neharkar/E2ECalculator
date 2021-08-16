package testcases;

import common.TestBase;
import dataProviders.DataProviders;
import objectRepository.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CarLoanEMI extends TestBase {
    public static Logger log = LogManager.getLogger(CarLoanEMI.class.getName());
    WebDriver driver;

    @BeforeMethod(groups = {"Regression", "Sanity"})
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver initialized successfully");
        driver.get(prop.getProperty("url"));
        log.info("Entered URL : "+prop.getProperty("url"));
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "getDataForCarLoan", groups = {"Regression", "Sanity"})
    public void testCarLoanEMI(String loanAmount, String interestRate, String loanTenure, String expectedEmi, String expectedInterest) {
        HomePage homePage = new HomePage(driver);

        Actions actions = new Actions(driver);
        homePage.getCarLoanTab().click();
        actions.moveToElement(homePage.getLoadAmount()).doubleClick().sendKeys(loanAmount).sendKeys(Keys.TAB).build().perform();
        log.info("Entered loan Amount = "+loanAmount);
        actions.moveToElement(homePage.getInterestRate()).click().doubleClick().sendKeys(interestRate).sendKeys(Keys.TAB).build().perform();
        log.info("Entered interest rate = "+interestRate);
        actions.moveToElement(homePage.getLoanTenure()).click().doubleClick().sendKeys(loanTenure).sendKeys(Keys.TAB).build().perform();
        log.info("Entered tenure = "+loanTenure);
        log.info("Actual EMI = "+homePage.getLoanEMI().getText());
        System.out.println(homePage.getLoanEMI().getText());

        Assert.assertEquals(homePage.getLoanEMI().getText(),expectedEmi);

    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "getDataForCarLoan", groups = {"Regression"})
    public void testCarLoanInterest(String loanAmount, String interestRate, String loanTenure, String expectedEmi, String expectedInterest) {
        HomePage homePage = new HomePage(driver);

        Actions actions = new Actions(driver);
        homePage.getCarLoanTab().click();
        actions.moveToElement(homePage.getLoadAmount()).doubleClick().sendKeys(loanAmount).sendKeys(Keys.TAB).build().perform();
        log.info("Entered loan Amount = "+loanAmount);
        actions.moveToElement(homePage.getInterestRate()).click().doubleClick().sendKeys(interestRate).sendKeys(Keys.TAB).build().perform();
        log.info("Entered interest rate = "+interestRate);
        actions.moveToElement(homePage.getLoanTenure()).click().doubleClick().sendKeys(loanTenure).sendKeys(Keys.TAB).build().perform();
        log.info("Entered tenure = "+loanTenure);
        log.info("Actual EMI = "+homePage.getLoanInterest().getText());
        System.out.println(homePage.getLoanInterest().getText());

        Assert.assertEquals(homePage.getLoanInterest().getText(),expectedInterest);

    }

    @AfterMethod(groups = {"Regression", "Sanity"})
    public void tearDown()
    {
        driver.quit();
        log.info("Closed the browser");
    }
}
