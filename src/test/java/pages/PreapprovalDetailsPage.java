package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PreapprovalDetailsPage {

    public PreapprovalDetailsPage(){ PageFactory.initElements(Driver.getDriver(),this); }

    //ARE YOU WORKING WITH A REALTOR?(yes/no)
    @FindBy(xpath = "//label[@for='realtor1']")
    public WebElement realtorYES;
    @FindBy(xpath = "//*[@id=\"steps-uid-0-p-0\"]/div[1]/div[3]/div/ul/li[2]/fieldset/div/label")
    public WebElement realtorNO;


    //REALTOR INFORMATION (NAME AND PHONE NUMBER OR EMAIL ADDRESS)

    @FindBy(id = "realtorinfo")
    public WebElement realtorInformation;

    //ARE YOU CURRENTLY WORKING WITH A LOAN OFFICER?(yes/no)
    @FindBy(xpath = "//label[@for='loanofficer1']")
    public WebElement loanOfficerYES;
    @FindBy(xpath = "//label[@for='loanofficer2']")
    public WebElement loanOfficerNO;

    //PURPOSE OF LOAN
    @FindBy(id = "select2-purpose_loan-bi-container")
    public WebElement purposeOfLoan;

    //ESTIMATED PURCHASE PRICE
    @FindBy(name = "est_purchase_price")
    public WebElement purchasePrice;

    //DOWN PAYMENT AMOUNT
    @FindBy(id = "downpayment")
    public WebElement downpayment;

    //DOWN PAYMENT PERCENTAGE
    @FindBy(name = "down_payment_percent")
    public WebElement downPaymentPercent;

    //SOURCE OF DOWN PAYMENT (DOCUMENTATION THAT MAY BE REQUESTED)
    @FindBy(xpath = "select2-search select2-search--dropdown")
    public WebElement sourceOfDownPayment;

    //NEXT BUTTON
    @FindBy(xpath = "//li//a[text()='Next']")
 //   @FindBy(className = "btn btn-light-primary")
    public WebElement nextButton;

    @FindBy(xpath = "//div[@class='loanamount']//span")
    public WebElement loanAmount;
}
