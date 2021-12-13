package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ExpensePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

public class ExpenseStepDefs {
    ExpensePage expensePage = new ExpensePage();


    @When("I choose Rent for current monthly expenses")
    public void i_choose_rent_for_current_monthly_expenses() {

        SeleniumUtils.jsClick(expensePage.currentMonthlyHousingExpenses);
       // expensePage.currentMonthlyHousingExpenses.click();
    }

    @Then("I enter monthly rental payment")
    public void i_enter_monthly_rental_payment() {
        //giving element not intractable exception
   //     SeleniumUtils.jsClick(expensePage.monthlyRentalPayment);
        expensePage.monthlyRentalPayment.sendKeys("2000");
    }

    @Then("I should land on Employment and Income Page")
    public void i_should_land_on_employment_and_income_page() {
     String expectedTitle = "Borrower Employment Information";
     Assert.assertEquals(expectedTitle,expensePage.employmentPageTitle.getText());

    }



}