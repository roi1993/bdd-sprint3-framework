package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.formula.functions.T;
import pages.HomePage;
import pages.LoginPage;
import pages.PreapprovalDetailsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PreapprovalDetailsStepDefs {

    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();
    PreapprovalDetailsPage preapprovalDetailsPage=new PreapprovalDetailsPage();


    @Then("I enter email and password")
    public void i_enter_email_and_password() throws InterruptedException {

        loginPage.email.sendKeys(ConfigReader.getProperty("email"));
        loginPage.password.sendKeys(ConfigReader.getProperty("password"));

    }
    @Then("I click on login button")
    public void i_click_on_login_button() throws InterruptedException {
        loginPage.loginButton.click();
        Thread.sleep(2000);
    }


    @Then("I click on Mortgage application")
    public void iClickOnMortgageApplication() {
        homePage.mortgageApplicationButton.click();
    }

    @Then("I choose Yes working with realtor")
    public void i_choose_yes_working_with_realtor() {
        preapprovalDetailsPage.realtorYES.click();

    }
    @And("I pass realtor information {string} and {string}")
    public void iPassRealtorInformationAnd(String name, String phoneNumber) {
      name="Mary";
      phoneNumber="3433332322";
    preapprovalDetailsPage.realtorInformation.sendKeys(name,phoneNumber);

    }
    @Then("I choose Yes for working with a loan officer")
    public void i_choose_yes_for_working_with_a_loan_officer() {
        preapprovalDetailsPage.loanOfficerYES.click();

    }
    @Then("I choose purpose of the loan")
    public void i_choose_purpose_of_the_loan() {
        preapprovalDetailsPage.purposeOfLoan.click();

    }
    @Then("I enter {int}")
    public void i_enter(Integer int1) {

    }
    @Then("My down payment {int} $ should be")
    public void my_down_payment_$_shoud_be(Integer int1) {

    }

    @Then("My {int}")
    public void my(Integer int1) {

    }
    @Then("I provide source of down payment")
    public void i_provide_source_of_down_payment() {
        preapprovalDetailsPage.sourceOfDownPayment.click();

    }
    @Then("I click on next button")
    public void i_click_on_next_button() {

    }
    @Then("I should land on personal information part of application")
    public void i_should_land_on_personal_information_part_of_application() {

    }



}
