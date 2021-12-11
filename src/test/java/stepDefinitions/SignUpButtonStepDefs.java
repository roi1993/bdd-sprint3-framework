package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.SignUpButtonPage;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class SignUpButtonStepDefs {

    SignUpButtonPage signUpButtonPage = new SignUpButtonPage();

    //Scenario #1
    @When("I pass this information")
    public void i_pass_this_information(List<Map<String,String>> data) {
        Map<String, String> row = data.get(0);

        signUpButtonPage.firstName.sendKeys(row.get("First Name"));
        signUpButtonPage.lastName.sendKeys(row.get("Last Name"));
        signUpButtonPage.emailAddress.sendKeys(row.get("Email Address"));
        signUpButtonPage.password.sendKeys(row.get("Password"));

    }

    @When("I click on Sign Up Button")
    public void i_click_on_sign_up_button() {
        signUpButtonPage.clickOnSignUpButton();

    }

    @Then("I should land on back on Login main Page")
    public void i_should_land_on_back_on_login_main_page() throws InterruptedException {

        Thread.sleep(2000);
        String expected = "Welcome Back, Automation Testers!";
        String actual = signUpButtonPage.backToLogInPage.getText();
        Assert.assertEquals(expected,actual);

    }


    @Then("I should get error message")
    public void i_should_get_error_message() {
       Assert.assertTrue(Driver.getDriver().getPageSource().contains(signUpButtonPage.firstName.getAttribute("validationMessage")));

    }


    @Then("I should get error message on email address field")
    public void i_should_get_error_message_on_email_address_field() {
        String expectedErrorMsg = "Please enter a part following '@'.'l.Butcher@' is incomplete.";
        String actualErrorMsg = signUpButtonPage.emailAddressLineErrorMsg.getText();
     //   Assert.assertEquals(expectedErrorMsg,actualErrorMsg);
        Assert.assertTrue(actualErrorMsg.contains(expectedErrorMsg));
    }


    @When("I leave a blank on field first name and last name")
    public void i_leave_a_blank_on_field_first_name_and_last_name() {
        signUpButtonPage.firstName.sendKeys(Keys.TAB,Keys.TAB);
    }

    @When("I only enter email address and password")
    public void i_only_enter_email_address_and_password() {
        signUpButtonPage.emailAddress.sendKeys("doseman3c@lulu.com");
        signUpButtonPage.password.sendKeys("NY0vsFpQ4");

    }

    @Then("I should get error message on First Name Field")
    public void i_should_get_error_message_on_first_name_field() {
        String expectedErrorMessage = "Please fill out this field.";
        String actualErrorMessage = signUpButtonPage.firstName.getAttribute("validationMessage");
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }



}
