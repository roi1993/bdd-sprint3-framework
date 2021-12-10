package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignUpLinkPage {

    public SignUpLinkPage() { PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//a/small[text()='Sign up']")
    public WebElement signUpLink;

    @FindBy(xpath = "//div/h4[@class='text-center mb-2']")
    public WebElement signUpTitleOfThePage;

    public void signUpLinkClick(){
        signUpLink.click();
    }












}
