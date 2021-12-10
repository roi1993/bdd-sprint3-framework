package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginButtonValidationPage;
import pages.SignInLinkPage;
import pages.SignUpButtonPage;
import pages.SignUpLinkPage;
import utilities.ConfigReader;
import utilities.Driver;

public class SignInLinkStepDefs {

    @Given("I am on Sign Up Page")
    public void i_am_on_sign_up_page() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        SignUpLinkPage signUpLinkPage = new SignUpLinkPage();
        signUpLinkPage.signUpLinkClick();

    }

    @When("I click on Sign In Blue Link")
    public void i_click_on_sign_in_blue_link() {
        SignInLinkPage signInLinkPage = new SignInLinkPage();
        signInLinkPage.clickOnSignInLink();
    }

    @Then("I should land on Login main Page")
    public void i_should_land_on_login_main_page() {
        LoginButtonValidationPage loginButtonValidationPage = new LoginButtonValidationPage();
        String expectedText = "LOGIN WITH EMAIL";
        Assert.assertEquals(expectedText,loginButtonValidationPage.verificationOfLogIn.getText());


    }
}
