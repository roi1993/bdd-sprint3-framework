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
    String givenEmail;
    String givenPassword;

    @Given("I am on main Login page")
    public void i_am_on_main_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("I enter {string} and {string}")
    public void i_enter_and(String email, String password) throws InterruptedException {
        givenEmail = email;
        givenPassword = password;
        loginPage.email.sendKeys(email);
        Thread.sleep(1000);
        loginPage.password.sendKeys(password);
        Thread.sleep(1000);
    }

    @Then("I click on Login Button")
    public void i_click_on_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Then("I should land on my DuoBank Dashboard")
    public void i_should_land_on_my_duo_bank_dashboard() {
        String expectedTitle = "Loan Application";
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
    }

    @Then("The username should be {string}")
    public void the_username_should_be(String string) {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(loginPage.userNameOnDashboard.getText()));

    }
}
