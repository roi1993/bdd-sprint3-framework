package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EConsentPage {
    public EConsentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //FIRST NAME*
    @FindBy(id = "eConsentdeclarerFirstName")
    public WebElement eConsentFirstName;

    //LAST NAME*
    @FindBy (id = "eConsentdeclarerLastName")
    public WebElement eConsentLastName;

    //EMAIL*
    @FindBy(id = "eConsentdeclarerEmail")
    public WebElement eConsentEmail;

    //Agree
    @FindBy(xpath = "//*[@id=\"steps-uid-0-p-5\"]/ul/li[1]/fieldset/div/label")
    public WebElement agreeOption;

    //Don't Agree
    @FindBy(xpath = "//*[@id=\"steps-uid-0-p-5\"]/ul/li[2]/fieldset/div/label")
    public WebElement dontAgreeOption; ;

    //NEXT BUTTON
    @FindBy(linkText = "Next")
    public WebElement nextEConsent;

    //PREVIOUS BUTTON
    @FindBy(linkText = "Previous")
    public WebElement previousEConsent;




}
