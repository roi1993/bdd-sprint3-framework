package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class MortgageApplicationStepDefs {
    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();


    @When("I enter Email and password")
    public void i_enter_email_and_password() {
        loginPage.email.sendKeys(ConfigReader.getProperty("email"));
        loginPage.password.sendKeys(ConfigReader.getProperty("password"));


    }
    @Then("I click on Mortgage Application")
    public void i_click_on_mortgage_application() {
        homePage.mortgageApplicationButton.click();

    }
    @Then("I should be able to land on Mortgage Application form")
    public void i_should_be_able_to_land_on_mortgage_application_form() {
       String expected="Loan Application";
       String actual= Driver.getDriver().getTitle();
        Assert.assertEquals(expected,actual);
    }


}
