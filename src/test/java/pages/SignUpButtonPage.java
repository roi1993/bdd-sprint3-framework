package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignUpButtonPage {

    public SignUpButtonPage() { PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(id = "inputfirstname4")
    public WebElement firstName;

    @FindBy(id = "inputlastname4")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement emailAddress;

    @FindBy(id = "exampleInputPassword1")
    public WebElement password;

    @FindBy(name = "register")
    public WebElement signUpButton;

    @FindBy(xpath = "//button/i[@class='bx bx-right-arrow-alt']")
    public WebElement signUpArrow;

    @FindBy(xpath = "//div/h4[text()='Welcome Back, Automation Testers!']")
    public WebElement backToLogInPage;




}
