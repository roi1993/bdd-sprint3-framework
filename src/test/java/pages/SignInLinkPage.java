package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignInLinkPage {

    public SignInLinkPage(){ PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//a/small[text()='Sign in']")
    public WebElement signInBlueLink;



    public void clickOnSignInLink(){
        signInBlueLink.click();
    }
}
