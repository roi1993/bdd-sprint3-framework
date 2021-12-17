package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CreditReportPage {

public CreditReportPage(){
    PageFactory.initElements(Driver.getDriver(),this);
}
    //ORDER CREDIT REPORT
    @FindBy(xpath = "//label[@for='creditreport1']")
    public WebElement orderCreditReportYES;

    @FindBy(id = "creditreport2")
    public WebElement orderCreditReportNO;

    //NEXT BUTTON
    @FindBy(xpath = "(//a[@class='btn btn-light-primary'])[2]")
    public WebElement nextButton;

    //PREVIOUS BUTTON
    @FindBy(xpath = "//a[@class='btn btn-light-primary']")
    public WebElement previousButton;



}
