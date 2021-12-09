package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PersonalInformationPage {

    public PersonalInformationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //ARE YOU APPLYING WITH A CO-BORROWER?
    @FindBy(xpath = "//label[@for='coborrower1']")
    public WebElement coBorrowerYES;


}
