package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SignUpLinkPage;
import utilities.ConfigReader;
import utilities.Driver;

public class SignUpLinkStepDefs {

    @Given("I am on Login main Page")
    public void i_am_on_login_main_page() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("I click on Sign Up Blue Link")
    public void i_click_on_sign_up_blue_link() {
        SignUpLinkPage signUpLinkPage = new SignUpLinkPage();
        signUpLinkPage.signUpLinkClick();
    }

    @Then("I should land on Sign Up Page to be able to register to the website")
    public void i_should_land_on_sign_up_page_to_be_able_to_register_to_the_website() {
        SignUpLinkPage signUpLinkPage = new SignUpLinkPage();
        String expectedText = "Sign Up";
        Assert.assertEquals(expectedText,signUpLinkPage.signUpTitleOfThePage.getText());

    }
}
