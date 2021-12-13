package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EmploymentAndIncomePage{

    public EmploymentAndIncomePage() {
        PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//label[@for='currentjob1']")
    public WebElement currentBoxcheckBox;

    @FindBy(xpath = "//input[@id='employername1']")
    public WebElement employerName;

    @FindBy(xpath = "//input[@id='position1']")
    public WebElement position;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement city;

    @FindBy(xpath = "//select[@id='state1']")
    public WebElement stateDropDown;

    @FindBy(xpath = "//input[@id='start_date1']")
    public WebElement startDateDropDown;

    @FindBy(xpath = "//input[@id='end_date1']" )
    public WebElement endDateDropDown;

    @FindBy(xpath = "//input[@id='grossmonthlyincome']")
    public WebElement monthlyGrossIncome;

    @FindBy(xpath = "//input[@id='monthlyovertime']")
    public WebElement monthlyOvertime;

    @FindBy(xpath = "//input[@id='monthlybonuses']")
    public WebElement monthlyBonuses;

    @FindBy(xpath = "//input[@id='monthlycommission']")
    public WebElement monthlyCommission;

    @FindBy(xpath = "//input[@id='monthlydividents']")
    public WebElement monthlyDividents;

    @FindBy(xpath = "//select[@id='incomesource1']")
    public WebElement incomeSourceDropDown;

    @FindBy(xpath = "//input[@id='amount1']" )
    public WebElement amount1;

    @FindBy(xpath = "//select[@id='incomesource2']" )
    public WebElement incomeSourceDropDown2;

    @FindBy(xpath = "//input[@id='amount2']")
    public WebElement amount2;

    @FindBy(xpath = "//select[@id='incomesource3']")
    public WebElement incomeSourceDropDown3;

    @FindBy(xpath = "//input[@id='amount3']")
    public WebElement amount3;

    @FindBy(xpath = "//a[@href='#next']")
    public WebElement nextButton;

    @FindBy(xpath = "//fieldset/h6[@class='pb-50'][text()='PreApproval Inquiry']")
    public WebElement preApprovalPageTitle;


}