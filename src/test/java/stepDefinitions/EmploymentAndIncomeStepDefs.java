package stepDefinitions;
package pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.LoginButtonValidationPage;

import java.util.List;
import java.util.Map;
public class EmploymentAndIncomeStepDefs {

   EmploymentAndIncomePage employmentAndIncomePage = new EmploymentAndIncomePage;

   @Then("I check mark my current job")
   public void i_check_mark_my_current_job() {

      employmentAndIncomePage.currentBoxcheckBox.click();
   }

   @Then("I enter employer name")
   public void i_enter_employer_name() {
      employmentAndIncomePage.employerName.click().sendKeys("Anna Jordan");


   }

   @Then("I enter position")
   public void i_enter_position() {

      employmentAndIncomePage.position.click().sendKeys("Upper position");
   }

   @Then("I enter city")
   public void i_enter_city() {

      employmentAndIncomePage.city.click().sendKeys("Fairfax");
   }
   //@Then("I enter state")
   //public void i_enter_state() {
   // }

   //@Then("I enter start date")
   // public void i_enter_start_date() {
//}
   //@Then("I enter end date"
   // public void i_enter_end_date() {
//}

   @Then("I enter monthly gross income")
   public void i_enter_monthly_gross_income() {
      employmentAndIncomePage.monthlyGrossIncome.click().sendKeys("$2000");
   }

   @Then("I enter monthly overtime")
   public void i_enter_monthly_overtime() {
      employmentAndIncomePage.monthlyOvertime.click().sendKeys("10");

   }

   @Then("I enter monthly bonus")
   public void i_enter_monthly_bonus() {
      employmentAndIncomePage.monthlyBonuses.click().sendKeys("$100");

   }

   @Then("I enter monthly commission")
   public void i_enter_monthly_commission() {
      employmentAndIncomePage.monthlyCommission.click().sendKeys("$2000");
   }

   @Then("I enter monthly dividents")
   public void i_enter_monthly_dividents() {
      employmentAndIncomePage.monthlyDividents.click().sendKeys("$1000");

   }
   // @Then("I select income source")
   // public void i_select_income_source() {
// }

   @Then("I enter amount")
   public void i_enter_amount() {
      employmentAndIncomePage.amount1.click().sendKeys("$1000");

   }
   //@Then("I select second income source")
   // public void i_select_second_income_source() {

   //}
   @Then("I enter second amount")
   public void i_enter_second_amount() {
      employmentAndIncomePage.amount2.click().sendKeys("$1000");
   }

   //@Then("I select third income source")
   // public void i_select_third_income_source() {
//}

   @Then("I enter third amount")
   public void i_enter_third_amount() {
      employmentAndIncomePage.amount3.click().sendKeys("$500");
   }
   @Then("I click next button")
   public void i_click_next_button() {
      employmentAndIncomePage.nextButton.click();
   }








}