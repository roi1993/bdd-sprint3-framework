package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.PreapprovalDetailsPage;
import utilities.Driver;

import java.util.List;

public class PreapprovalDetailsStepDefs {

    PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();

    @Then("I choose YES for working with realtor")
    public void i_choose_yes_for_working_with_realtor() {
        preapprovalDetailsPage.realtorYES.click();

    }
    @Then("I pass realtor Name and Phone Number")
    public void i_pass_realtor_name_and_phone_number(List<List<String>> data)  {
        preapprovalDetailsPage.realtorInformation.sendKeys(data.get(1).get(0)," ",data.get(1).get(1));


    }
    @Then("I choose Yes for working with a loan officer")
    public void i_choose_yes_for_working_with_a_loan_officer()  {
        preapprovalDetailsPage.loanOfficerYES.click();


    }

    @Then("I enter estimated purchase price {string}")
    public void i_enter_estimated_purchase_price(String purchasePrice) {
        preapprovalDetailsPage.purchasePrice.sendKeys(purchasePrice);

    }
    @And("I enter down payment percentage {string}")
    public void iEnterDownPaymentPercentage(String percentage) {
        preapprovalDetailsPage.downPaymentPercent.sendKeys(percentage);

    }
//    @Then("My down payment amount should be {string}")
//    public void myDownPaymentAmountShouldBe(String downAmount) {
//        String expected=downAmount;
//        String actual= preapprovalDetailsPage.downpayment.getText();
//        Assert.assertEquals(expected,actual);
//    }


    @Then("My loan amount is {string}")
    public void my_loan_amount_is(String loanAmount) {
        String expected= loanAmount;
        String actual= preapprovalDetailsPage.loanAmount.getText();
        Assert.assertEquals(expected,actual);

    }
//    @Then("I provide source of down payment")
//    public void i_provide_source_of_down_payment() {
//        new Select(preapprovalDetailsPage.sourceOfDownPayment).selectByVisibleText("Equity on Pending Sale (executed sales contract)");
//
//
//    }
    @Then("I click on next button")
    public void i_click_on_next_button() {
        preapprovalDetailsPage.nextButton.click();

    }
    @Then("I should land on personal information part of application")
    public void i_should_land_on_personal_information_part_of_application() {
        String expected="Loan Application";
        String actual= Driver.getDriver().getTitle();
        Assert.assertEquals(expected,actual);

    }

    //And I choose purpose of the loan
    //Then I provide source of down payment


}
