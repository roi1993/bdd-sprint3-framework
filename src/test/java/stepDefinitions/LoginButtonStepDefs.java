package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.LoginButtonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.security.Key;

public class LoginButtonStepDefs {

//        LoginButtonPage loginButtonPage = new LoginButtonPage();
//        String message = loginButtonPage.emailAddress.getAttribute("validationMessage");
//        System.out.println(message);
    LoginButtonPage loginButtonPage = new LoginButtonPage();

    @Given("I am on main Login page")
    public void i_am_on_main_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    //scenario #1

    @When("I enter {string} and {string}")
    public void i_enter_and(String email, String password) {
        loginButtonPage.emailAddress.sendKeys("ditote3350@leanrights.com");
        loginButtonPage.password.sendKeys("Janeray2021");
    }

    @Then("I click on Login Button")
    public void i_click_on_login_button() {
        loginButtonPage.clickOnLoginButton();
    }

    @Then("I should land on my DuoBank Dashboard")
    public void i_should_land_on_my_duo_bank_dashboard() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(loginButtonPage.userNameOnDashboard.getText()));
    }

    //scenario #2
    @When("I enter {string} and leave {string} field empty")
    public void i_enter_and_leave_field_empty(String string, String string2) {

    }

    @Then("System should give pop-up error message on password field")
    public void system_should_give_pop_up_error_message_on_password_field() {

    }

    //scenario #3
    @When("I leave email address field empty and enter only {string}")
    public void i_leave_email_address_field_empty_and_enter_only(String string) {

    }

    @Then("System should give pop-up error message on email address field")
    public void system_should_give_pop_up_error_message_on_email_address_field() {

    }

    //scenario #4
    @Then("I click on Login Arrow on the right")
    public void i_click_on_login_arrow_on_the_right() {

    }




}
