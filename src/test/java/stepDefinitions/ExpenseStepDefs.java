package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.ExpensePage;
import pages.LoginPage;
import pages.PersonalInformationPage;
import pages.PreapprovalDetailsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;

public class ExpenseStepDefs {
    ExpensePage expensePage = new ExpensePage();
    PersonalInformationPage personalInformationPage=new PersonalInformationPage();


//    @Then("I enter following information")
//    public void iEnterFollowingInformation(List<List<String>> data) {
//      personalInformationPage.bFirstName.sendKeys(data.get(1).get(0));
//      personalInformationPage.bLastName.sendKeys(data.get(1).get(1));
//      personalInformationPage.bEmail.sendKeys(data.get(1).get(2));
//      personalInformationPage.bDOB.sendKeys(data.get(1).get(3));
//      personalInformationPage.bSSN.sendKeys(data.get(1).get(4));
//      personalInformationPage.bCellPhone.sendKeys(data.get(1).get(5));
//
//    }
    @And("I choose marital status")
    public void iChooseMaritalStatus() {
personalInformationPage.bMaritalStatus.click();
personalInformationPage.bMarried.sendKeys("Mer", Keys.ENTER);

    }

    @When("I choose Rent for current monthly expenses")
    public void i_choose_rent_for_current_monthly_expenses() {

        SeleniumUtils.jsClick(expensePage.currentMonthlyHousingExpenses);
       // expensePage.currentMonthlyHousingExpenses.click();
    }

    @Then("I enter monthly rental payment")
    public void i_enter_monthly_rental_payment() {

        expensePage.monthlyRentalPayment.sendKeys("123222");
    }

    @Then("I should land on Employment and Income Page")
    public void i_should_land_on_employment_and_income_page() {
     String expectedTitle = "Borrower Employment Information";
     Assert.assertEquals(expectedTitle,expensePage.employmentPageTitle.getText());

    }



}