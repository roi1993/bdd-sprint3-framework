package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginButtonPage {

    public LoginButtonPage() { PageFactory.initElements(Driver.getDriver(),this); }


    @FindBy(id = "exampleInputEmail1")
    public WebElement emailAddress;

    @FindBy(name = "password")
    public WebElement password;


    @FindBy(xpath = "//div//button[@class='btn btn-primary glow w-100 position-relative']")
    public WebElement logInButton;

    @FindBy(xpath = "//div//button/i[@id='icon-arrow']")
    public WebElement loginArrow;

    @FindBy(className = "user-name")
    public WebElement userNameOnDashboard;

    @FindBy(xpath = "//div[@class='divider-text text-uppercase text-muted']")
    public WebElement verificationOfLogIn;


    public void clickOnLoginButton(){
        logInButton.click();
    }

    public void clickOnLoginArrow(){
        loginArrow.click();
    }















}
