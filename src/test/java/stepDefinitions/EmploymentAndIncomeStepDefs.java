package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.EmploymentAndIncomePage;
import pages.LoginButtonValidationPage;

import java.util.List;
import java.util.Map;
public class EmploymentAndIncomeStepDefs {

   EmploymentAndIncomePage employmentAndIncomePage = new EmploymentAndIncomePage();

   @Then("I check This is my current job field")
   public void iCheckThisIsMyCurrentJobField() {
      employmentAndIncomePage.currentBoxcheckBox.click();
   }

   @Then("I enter {string} for employer name")
   public void iEnterForEmployerName(String employerName) {
      employmentAndIncomePage.employerName.sendKeys(employerName);
   }

   @Then("I enter {string} for position")
   public void iEnterForPosition(String position) {
      employmentAndIncomePage.position.sendKeys(position);
   }

   @Then("I enter {string} for city and select state")
   public void iEnterForCityAndSelectState(String city) {
      employmentAndIncomePage.city.sendKeys(city);

   }

   @Then("I enter {int} for start date")
   public void iEnterForStartDate(Integer startDate) {
      employmentAndIncomePage.startDateDropDown.sendKeys(String.valueOf(startDate));
   }

   @Then("I enter {double} to monthly income and enter {double} for monthly overtime")
   public void iEnterToMonthlyIncomeAndEnterForMonthlyOvertime(Double monthlyIncome, Double monthlyOvertime) {
      employmentAndIncomePage.monthlyGrossIncome.sendKeys(String.valueOf(monthlyIncome));
      employmentAndIncomePage.monthlyOvertime.sendKeys(String.valueOf(monthlyOvertime));

   }

   @And("I should land on next Credit Report page")
   public void iShouldLandOnNextCreditReportPage() {
      String expected = "PreApproval Inquiry";
      String actual = employmentAndIncomePage.preApprovalPageTitle.getText();
      Assert.assertEquals(expected,actual);
   }



    //@Then("I enter start date")
   // public void i_enter_start_date() {
//}
   //@Then("I enter end date"
   // public void i_enter_end_date() {
//}



//   @Then("I enter monthly bonus")
//   public void i_enter_monthly_bonus() {
//      employmentAndIncomePage.monthlyBonuses.sendKeys("$100");
//
//   }
//
//   @Then("I enter monthly commission")
//   public void i_enter_monthly_commission() {
//      employmentAndIncomePage.monthlyCommission.sendKeys("$2000");
//   }
//
//   @Then("I enter monthly dividents")
//   public void i_enter_monthly_dividents() {
//      employmentAndIncomePage.monthlyDividents.sendKeys("$1000");
//
//   }
//   // @Then("I select income source")
//   // public void i_select_income_source() {
//// }
//
//   @Then("I enter amount")
//   public void i_enter_amount() {
//      employmentAndIncomePage.amount1.sendKeys("$1000");
//
//   }
//   //@Then("I select second income source")
//   // public void i_select_second_income_source() {
//
//   //}
//   @Then("I enter second amount")
//   public void i_enter_second_amount() {
//      employmentAndIncomePage.amount2.sendKeys("$1000");
//   }
//
//   //@Then("I select third income source")
//   // public void i_select_third_income_source() {
////}
//
//   @Then("I enter third amount")
//   public void i_enter_third_amount() {
//      employmentAndIncomePage.amount3.sendKeys("$500");
//   }
//   @Then("I click next button")
//   public void i_click_next_button() {
//      employmentAndIncomePage.nextButton.click();
//   }


















}