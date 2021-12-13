package stepDefinitions;
package pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class ExpenseStepDefs {
    ExpensePage expensePage = new ExpensePage();
    @Then("I choose YES for current monthly housing expenses")
    public void i_choose_yes_for_current_monthly_housing_expenses() {
        expensePage.currentMonthlyHousingExpenses.click();
    }
    @Then("I enter value for payment")
    public void i_enter_value_for_payment() {
        expensePage.monthlyRentalPayment.sendKeys("2000");

    }
    @Then("I click next to land on next page")
    public void i_click_next_to_land_on_next_page() {
        expensePage.nextButton.click();
    }


}