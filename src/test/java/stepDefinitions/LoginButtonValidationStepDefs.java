package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.LoginButtonValidationPage;

import java.util.List;
import java.util.Map;

public class LoginButtonValidationStepDefs {


    LoginButtonValidationPage loginButtonPage = new LoginButtonValidationPage();

//    @Given("I am on main Login page")
//    public void i_am_on_main_login_page() {
//        Driver.getDriver().get(ConfigReader.getProperty("url"));
//    }

    //scenario #1  -- moved to login smoke test separately
//
//    @When("I enter {string} and {string}")
//    public void i_enter_and(String email, String password) {
//        loginButtonPage.emailAddress.sendKeys("ditote3350@leanrights.com");
//        loginButtonPage.password.sendKeys("Janeray2021");
//    }
//
//    @Then("I click on Login Button")
//    public void i_click_on_login_button() {
//        loginButtonPage.clickOnLoginButton();
//    }
//
//    @Then("I should land on my DuoBank Dashboard")
//    public void i_should_land_on_my_duo_bank_dashboard() {
//        Assert.assertTrue(Driver.getDriver().getPageSource().contains(loginButtonPage.userNameOnDashboard.getText()));
 //   }

    //scenario #2
    String givenEmailAddress;

    @When("I enter {string} for email and leave password field empty")
    public void i_enter_and_leave_password_field_empty(String emailAddress) throws InterruptedException {
        givenEmailAddress = emailAddress;
        loginButtonPage.emailAddress.sendKeys(emailAddress);
        Thread.sleep(1000);
        loginButtonPage.password.sendKeys(Keys.TAB);
        Thread.sleep(1000);
    }

    @Then("System should give pop-up error message on password field")
    public void system_should_give_pop_up_error_message_on_password_field() {

        String expectedErrorMessage = "Please fill out this field.";
        String actualErrorMessage = loginButtonPage.password.getAttribute("validationMessage");
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);

    }

    //scenario #3
    String givenPassword;

    @When("I leave email address field empty and enter only {string} for password")
    public void i_leave_email_address_field_empty_and_enter_only(String password) throws InterruptedException {
        givenPassword = password;
        loginButtonPage.emailAddress.sendKeys(Keys.TAB);
        Thread.sleep(1000);
        loginButtonPage.password.sendKeys(password);
        Thread.sleep(1000);
    }

    @Then("System should give pop-up error message on email address field")
    public void system_should_give_pop_up_error_message_on_email_address_field() {
        String expectedErrorMessage = "Please fill out this field.";
        String actualErrorMessage = loginButtonPage.emailAddress.getAttribute("validationMessage");
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);

    }

    //scenario #4
    @When("I enter following info for email and password")
    public void i_enter_following_info_for_email_and_password(List<List<String>> data) {
       loginButtonPage.emailAddress.sendKeys(data.get(0).get(0));
       loginButtonPage.password.sendKeys(data.get(0).get(1));

    }

    @Then("I click on Login Arrow on the right")
    public void i_click_on_login_arrow_on_the_right() {
        loginButtonPage.clickOnLoginArrow();

    }






}
