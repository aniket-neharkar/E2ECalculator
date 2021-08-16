package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='loanamount']")
    WebElement loadAmount;

    @FindBy(xpath = "//input[@id='loaninterest']")
    WebElement interestRate;

    @FindBy(xpath = "//input[@id='loanterm']")
    WebElement loanTenure;

    @FindBy(xpath = "//div[@id='emiamount']/p/span")
    WebElement loanEMI;

    @FindBy(xpath = "//li[@id='personal-loan']/a")
    WebElement personalLoanTab;

    @FindBy(xpath = "//li[@id='car-loan']/a")
    WebElement carLoanTab;

    @FindBy(xpath = "//div[@id='emitotalinterest']/p/span")
    WebElement loanInterest;

    public WebElement getLoadAmount() {
        return loadAmount;
    }

    public WebElement getInterestRate() {
        return interestRate;
    }

    public WebElement getLoanTenure() {
        return loanTenure;
    }

    public WebElement getLoanEMI() {
        return loanEMI;
    }

    public WebElement getPersonalLoanTab() {
        return personalLoanTab;
    }

    public WebElement getCarLoanTab() {
        return carLoanTab;
    }

    public WebElement getLoanInterest() {
        return loanInterest;
    }
}