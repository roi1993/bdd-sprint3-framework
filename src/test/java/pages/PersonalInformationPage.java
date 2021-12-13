package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PersonalInformationPage {

    public PersonalInformationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //ARE YOU APPLYING WITH A CO-BORROWER?(yes/no)
    @FindBy(xpath = "//label[@for='coborrower1']")
    public WebElement coBorrowerYES;

    @FindBy(xpath = "//label[@for='coborrower2']")
    public WebElement coBorrowerNO;

    //Borrower's Information
    //FIRST NAME*
    @FindBy(id = "b_firstName")
    public WebElement bFirstName;

    //MIDDLE NAME
    @FindBy(id = "b_middleName")
    public WebElement bMiddleName;

    //LAST NAME*
    @FindBy(id = "b_lastName")
    public WebElement bLastName;

    //SUFFIX
    @FindBy(id = "select2-b_suffix-container")
    public WebElement bSelectSuffix;

    //EMAIL*
    @FindBy(id = "b_email")
    public WebElement bEmail;

    //DATE OF BIRTH*
    @FindBy(id = "b_dob")
    public WebElement bDOB;

    //SOCIAL SECURITY NUMBER*
    @FindBy(id = "b_ssn")
    public WebElement bSSN;

    //MARITAL STATUS*
    @FindBy(id = "select2-b_marital-container")
    public WebElement bMaritalStatus;

    //CELL PHONE*
    @FindBy(id = "b_cell")
    public WebElement bCellPhone;

    //HOME PHONE
    @FindBy(id = "b_home")
    public WebElement bHomePhone;

    //PRIVACY POLICY*
    @FindBy(xpath = "//label[@for='privacypolicy']")
    public WebElement privacyPolicy;


    //Co-Borrower's Information

    //FIRST NAME*
    @FindBy(id = "c_firstName")
    public WebElement cFirstName;

    //MIDDLE NAME
    @FindBy(id = "c_middleName")
    public WebElement cMiddleName;

    //LAST NAME*
    @FindBy(id = "c_lastName")
    public WebElement cLastName;

    //SUFFIX
    @FindBy(id = "select2-c_suffix-container")
    public WebElement cSuffix;

    //EMAIL*
    @FindBy(id = "c_email")
    public WebElement cEmail;

    //DATE OF BIRTH*
    @FindBy(id = "c_dob")
    public WebElement cDOB;

    //SOCIAL SECURITY NUMBER*
    @FindBy(id = "c_ssn")
    public WebElement cSSN;

    //MARITAL STATUS*
    @FindBy(id = "select2-c_marital-container")
    public WebElement cMaritalStatus;

    //CELL PHONE*
    @FindBy(id = "c_cell")
    public WebElement cCellPhone;

    //HOME PHONE
    @FindBy(id = "c_home")
    public WebElement cHomePhone;

 //   @FindBy(className = "btn btn-light-primary")  --  this will throw error again, so changed
    @FindBy(xpath = "//li//a[text()='Next']")
    public WebElement nextButton;

    //nextPage Title
    @FindBy(xpath = "//h6[@class='py-50'][text()='Current Monthly Housing Expenses']")
    public WebElement expensesPageTitle;
}
