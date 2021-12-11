package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("I am on main Login page")
    public void i_am_on_main_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("I enter Email and password")
    public void iEnterEmailAndPassword() {
        loginPage.email.sendKeys(ConfigReader.getProperty("email"));
        loginPage.password.sendKeys(ConfigReader.getProperty("password"));

    }

    @Then("I click on Login Button")
    public void i_click_on_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Then("I should land on my DuoBank Dashboard")
    public void i_should_land_on_my_duo_bank_dashboard() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(loginPage.userNameOnDashboard.getText()));
    }


}
